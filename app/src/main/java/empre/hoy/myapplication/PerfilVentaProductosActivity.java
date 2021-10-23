package empre.hoy.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.CategoriaAdapter;
import empre.hoy.myapplication.adapter.ProductoAdapter;

public class PerfilVentaProductosActivity extends AppCompatActivity {
    Button btnSeleccionar;
    Map<String, String> params;
    public static RecyclerView rvProductos, ruvCategoriasGanaderia;
    String categoria = "0";
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfilventaproductos);
        if (getIntent().getExtras() != null) {
            categoria = getIntent().getStringExtra("categoria");
        }
        btnSeleccionar = (Button) findViewById(R.id.btnSeleccionarProducto);
        rvProductos = (RecyclerView) findViewById(R.id.rvProductos);
        ruvCategoriasGanaderia = (RecyclerView) findViewById(R.id.ruvcategoriasganaderia);
        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvProductos.setVisibility(View.VISIBLE);
            }
        });
        ruvCategoriasGanaderia.setLayoutManager(new LinearLayoutManager(this));
        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        webService = new WebService(this);
        obtenerProductos(categoria);
    }

    public void obtenerProductos(String categoria) {
        Log.i("obtenerProductos", "PerfilVentaProductosActivity");
        params = new HashMap<>();
        params.put("categoria", categoria);
        webService.consulta(params, "obtener_productos_categoria.php");
    }

    public static void cargarProductos(CategoriaAdapter categoriaAdapter) {
        ruvCategoriasGanaderia.setAdapter(categoriaAdapter);
        ruvCategoriasGanaderia.setVisibility(View.VISIBLE);
    }
}
