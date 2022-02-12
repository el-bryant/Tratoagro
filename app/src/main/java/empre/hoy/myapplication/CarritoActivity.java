package empre.hoy.myapplication;

import static empre.hoy.myapplication.Comprar1Activity.itemsCarrito;
import static empre.hoy.myapplication.Comprar1Activity.total;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import org.json.JSONException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.CarritoAdapter;
import empre.hoy.myapplication.config.Config;

public class CarritoActivity extends AppCompatActivity {
    Button btnTotal;
    static Map<String, String> params;
    private static PayPalConfiguration config = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(Config.PAYPAL_CLIENT_ID);
    private static final int PAYPAL_REQUEST_CODE = 7777;
    public static PrefUtil prefUtil;
    RecyclerView rvCarrito;
    String amount = "";
    public static WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        prefUtil = new PrefUtil(this);
        webService = new WebService(this);
        btnTotal = (Button) findViewById(R.id.btnTotal);
        rvCarrito = (RecyclerView) findViewById(R.id.rvCarrito);
        rvCarrito.setLayoutManager(new LinearLayoutManager(this));
        btnTotal.setText("Pagar S/ " + String.format("%.2f", total));
        cargarItemsCarrito();
        btnTotal.setOnClickListener(v -> {
           registrarVenta();
            /**
             * Procedimiento para pago por PayPal
             */
//                processPayment();
        });
    }

    public void registrarVenta() {
        Date date = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        params = new HashMap<>();
        params.put("fecha", formatoFecha.format(date));
        params.put("hora", formatoHora.format(date));
        params.put("id_usuario_compra", prefUtil.getStringValue("id_usuario"));
        webService.consulta(params, "registrar_venta.php");
    }

    public static void llenarDetalles(String idVenta) {
        for (int i = 0; i < itemsCarrito.size(); i++) {
            params = new HashMap<>();
            params.put("cantidad", "" + itemsCarrito.get(i).getCantidad());
            params.put("id_stock", itemsCarrito.get(i).getIdProveedor());
            params.put("id_venta", idVenta);
            webService.consulta(params, "insertar_detalles_venta.php");
        }
    }

    public static void obtenerIdVenta() {
        params = new HashMap<>();
        params.put("id_usuario_compra", prefUtil.getStringValue("id_usuario"));
        webService.consulta(params, "obtener_id_venta.php");
    }

    public void cargarItemsCarrito() {
        CarritoAdapter carritoAdapter = new CarritoAdapter(this, itemsCarrito);
        rvCarrito.setAdapter(carritoAdapter);
    }

    private void processPayment() {
        amount = String.valueOf(total);
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"USD",
                "Compras por Tratoagro para Android", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this, PaymentDetails.class)
                                .putExtra("Payment Details", paymentDetails)
                                .putExtra("Amount", amount));
                        pagoTarjeta();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
    }

    public void pagoTarjeta() {
//        Date fecha = new Date();
//        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        final DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//        Log.i("pagoTarjeta", "DetalleActivity");
//        Thread tr = new Thread() {
//            @Override
//            public void run() {
//                final String result = Funciones.primero("https://vespro.io/food/wsApp/pago_entrega.php?id_pedido="
//                        + prefUtil.getStringValue("id_pedido") + "&fecha=" + dateFormat.format(fecha) + "&hora="
//                        + hourFormat.format(fecha) + "&estado=4&direccion=" + etDireccionEntrega.getText().toString()
//                        + "&latitud=" + latitud + "&longitud=" + longitud + "&total="
//                        + btnPlataformaPagos.getText().toString().substring(18, btnPlataformaPagos.getText().length() - 1)
//                        + "&id_proveedor=" + idProveedor);
//                Log.i("pagoTarjeta", result);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        int r = Funciones.segundo(result);
//                        if (r > 0) {
                            Intent intent = new Intent(CarritoActivity.this, PrincipalActivity.class);
                            startActivity(intent);
                            finish();
//                        }
//                    }
//                });
//            }
//        };
//        tr.start();
    }
}