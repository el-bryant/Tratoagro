package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.Funciones.WebService;

public class DatosJuridicoActivity extends AppCompatActivity {
    Button btnaceptar;
    boolean ubicacionObtenida;
    public static String direccion, ruc, comprarVender;
    TextInputEditText tietRuc, tietRazonSocial, tietRepresentanteLegal, tietCelular, tietDomicilioFiscal, tietCorreo, tietDireccion;
    double latitud = 0.0, longitud = 0.0;
    PrefUtil prefUtil;
    Map<String, String> params;
    WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_5_datos_juridico_1);
        prefUtil = new PrefUtil(this);
        webService = new WebService(this);
        comprarVender = getIntent().getStringExtra("comprar_vender");
        btnaceptar = (Button) findViewById(R.id.btnaceptar);
        tietRuc = (TextInputEditText) findViewById(R.id.tietRuc);
        tietRazonSocial = (TextInputEditText) findViewById(R.id.tietRazonSocial);
        tietRepresentanteLegal = (TextInputEditText) findViewById(R.id.tietRepresentanteLegal);
        tietCelular = (TextInputEditText) findViewById(R.id.tietCelular);
        tietDomicilioFiscal = (TextInputEditText) findViewById(R.id.tietDomicilioFiscal);
        tietCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        tietDireccion = (TextInputEditText) findViewById(R.id.tietUbicacion);
        btnaceptar.setOnClickListener(v -> {
            prefUtil.saveGenericValue("razon_social", tietRazonSocial.getText().toString());
            params = new HashMap<>();
            ruc = tietRuc.getText().toString();
            params.put("ruc", tietRuc.getText().toString());
            params.put("razon_social", tietRazonSocial.getText().toString());
            params.put("domicilio_fiscal", tietDomicilioFiscal.getText().toString());
            params.put("nombre_representante_legal", tietRepresentanteLegal.getText().toString());
            params.put("celular", tietCelular.getText().toString());
            params.put("comprar_vender", comprarVender);
            webService.consulta(params, "registro_juridico.php");
        });
        ubicacionObtenida = false;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            locationStart();
        }
    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        DatosJuridicoActivity.Localizacion Local = new DatosJuridicoActivity.Localizacion();
        Local.setMainActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
        direccion = "";
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }

    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    direccion = DirCalle.getAddressLine(0);
                    tietDireccion.setText(direccion);
                    ubicacionObtenida = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Localizacion implements LocationListener {
        DatosJuridicoActivity mainActivity;
        public DatosJuridicoActivity getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(DatosJuridicoActivity mainActivity) {
            this.mainActivity = mainActivity;
        }
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            latitud = loc.getLatitude();
            longitud = loc.getLongitude();
            if (!ubicacionObtenida) {
                this.mainActivity.setLocation(loc);
            }
        }
        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            Toast.makeText(DatosJuridicoActivity.this, "GPS Desactivado", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }

    public static void registrado(Activity activity) {
        Intent intent = new Intent(activity, DatosJuridico2Activity.class);
        intent.putExtra("ruc", ruc);
        intent.putExtra("comprar_vender", comprarVender);
        activity.startActivity(intent);
        activity.finish();
    }
}