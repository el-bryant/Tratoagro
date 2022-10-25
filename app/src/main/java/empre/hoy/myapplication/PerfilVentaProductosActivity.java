package empre.hoy.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.ProductoAdapter;
import empre.hoy.myapplication.adapter.SubcategoriaAdapter;

public class PerfilVentaProductosActivity extends AppCompatActivity {
//    Button btnSeleccionar;
    Map<String, String> params;
    public static RecyclerView rvProductos, rvSubcategorias;
    String categoria = "0";
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_2);
        if (getIntent().getExtras() != null) {
            categoria = getIntent().getStringExtra("categoria");
        }
//        btnSeleccionar = (Button) findViewById(R.id.btnSeleccionarProducto);
//        rvProductos = (RecyclerView) findViewById(R.id.rvProductos);
//        rvSubcategorias = (RecyclerView) findViewById(R.id.rvSubcategorias);
//        btnSeleccionar.setOnClickListener(v -> {
//            obtenerSubcategorias(categoria);
//            rvProductos.setVisibility(View.VISIBLE);
//        });
//        rvSubcategorias.setLayoutManager(new LinearLayoutManager(this));
//        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        webService = new WebService(this);
    }

    public void obtenerSubcategorias(String categoria) {
        Log.i("obtenerSubcategorias", "PerfilVentaProductosActivity");
        params = new HashMap<>();
        params.put("categoria", categoria);
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategorias.setAdapter(subcategoriaAdapter);
        rvSubcategorias.setVisibility(View.VISIBLE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductos.setAdapter(productoAdapter);
        rvProductos.setVisibility(View.VISIBLE);
    }
}
