package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.ProveedorAdapter;

public class ListaProveedoresActivity extends AppCompatActivity {
//    FloatingActionButton fabCarrito;
    Map<String, String> params;
//    public static RecyclerView rvProveedores;
    public static String idProducto, nombreProducto;
    WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2_1_lista_proveedores_fertilizantes);
//        fabCarrito = (FloatingActionButton) findViewById(R.id.fabCarrito);
//        rvProveedores = (RecyclerView) findViewById(R.id.rvProveedores);
//        fabCarrito.setOnClickListener(v -> startActivity(new Intent(ListaProveedoresActivity.this, CarritoActivity.class)));
//        rvProveedores.setLayoutManager(new LinearLayoutManager(this));
        webService = new WebService(this);
        if (getIntent().getExtras() != null) {
            idProducto = getIntent().getStringExtra("idProducto");
            nombreProducto = getIntent().getStringExtra("nombreProducto");
            buscarProveedores(idProducto);
        }
    }

    public void buscarProveedores(String idProducto) {
        params = new HashMap<>();
        params.put("id_producto", idProducto);
        webService.consulta(params, "obtener_proveedores_producto.php");
    }

    public static void cargarProveedores(ProveedorAdapter proveedorAdapter) {
//        rvProveedores.setAdapter(proveedorAdapter);
//        rvProveedores.setVisibility(View.VISIBLE);
    }
}