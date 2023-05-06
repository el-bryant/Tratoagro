package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.DepartamentoAdapter;
import empre.hoy.myapplication.adapter.DistritoAdapter;
import empre.hoy.myapplication.adapter.ProductoAdapter;
import empre.hoy.myapplication.adapter.ProvinciaAdapter;
import empre.hoy.myapplication.adapter.SubcategoriaAdapter;

public class Vender3Activity extends AppCompatActivity {
    ImageView ivContinuar;
    public static Map<String, String> params;
    public static RecyclerView rvDepartamento, rvDistrito, rvProducto, rvProvincia, rvSubcategoria;
    public static TextView tvDepartamento, tvDistrito, tvProducto, tvProvincia, tvSubcategoria;
    public static WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_3);
        webService = new WebService(this);
        ivContinuar = (ImageView) findViewById(R.id.ivContinuar);
        rvDepartamento = (RecyclerView) findViewById(R.id.rvDepartamento);
        rvProvincia = (RecyclerView) findViewById(R.id.rvProvincia);
        rvDistrito = (RecyclerView) findViewById(R.id.rvDistrito);
        tvDepartamento = (TextView) findViewById(R.id.tvDepartamento);
        tvDistrito = (TextView) findViewById(R.id.tvDistrito);
        tvProducto = (TextView) findViewById(R.id.tvProducto);
        tvProvincia = (TextView) findViewById(R.id.tvProvincia);
        rvProducto = (RecyclerView) findViewById(R.id.rvProducto);
        rvSubcategoria = (RecyclerView) findViewById(R.id.rvSubcategoria);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvDepartamento.setLayoutManager(new LinearLayoutManager(this));
        rvDistrito.setLayoutManager(new LinearLayoutManager(this));
        rvProducto.setLayoutManager(new LinearLayoutManager(this));
        rvProvincia.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoria.setLayoutManager(new LinearLayoutManager(this));
        ivContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Vender3Activity.this, Vender4Activity.class));
        });
        tvDepartamento.setOnClickListener(v -> {
            rvDepartamento.setVisibility(View.VISIBLE);
        });
        tvDistrito.setOnClickListener(v -> {
            rvDistrito.setVisibility(View.VISIBLE);
        });
        tvProducto.setOnClickListener(v -> {
            rvProducto.setVisibility(View.VISIBLE);
        });
        tvProvincia.setOnClickListener(v -> {
            rvProvincia.setVisibility(View.VISIBLE);
        });
        tvSubcategoria.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
        buscarDepartamentos();
    }

    public static void buscarDepartamentos() {
        params = new HashMap<>();
        webService.consulta(params, "buscar_departamentos.php");
    }

    public static void cargarDepartamentos(DepartamentoAdapter departamentoAdapter) {
        rvDepartamento.setAdapter(departamentoAdapter);
    }

    public static void cargarProvincias(ProvinciaAdapter provinciaAdapter) {
        rvProvincia.setAdapter(provinciaAdapter);
    }

    public static void cargarDistritos(DistritoAdapter distritoAdapter) {
        rvDistrito.setAdapter(distritoAdapter);
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "1");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoria.setVisibility(View.VISIBLE);
        rvSubcategoria.setAdapter(subcategoriaAdapter);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProducto.setAdapter(productoAdapter);
    }
}
