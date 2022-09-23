package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoInsumos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.ProductoAdapter;
import empre.hoy.myapplication.adapter.SubcategoriaAdapter;

public class Bienvenida86EmpezarTutorial23Info2InsumosActivity extends AppCompatActivity {
    Button btnSubcategoriasInsumos;
    ImageView ivFondo;
    Map<String, String> params;
    public static RecyclerView rvProductosInsumos, rvSubcategoriasInsumos;
    public static TextView tvSubcategoria;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_6_empezar_tutorial_2_3_info_2_insumos);
        webService = new WebService(this);
        btnSubcategoriasInsumos = (Button) findViewById(R.id.btnSubcategoriasInsumos);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvProductosInsumos = (RecyclerView) findViewById(R.id.rvProductosInsumos);
        rvSubcategoriasInsumos = (RecyclerView) findViewById(R.id.rvSubcategoriasInsumos);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvProductosInsumos.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoriasInsumos.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load(fondoInsumos).into(ivFondo);
        btnSubcategoriasInsumos.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "3");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoriasInsumos.setVisibility(View.VISIBLE);
        rvSubcategoriasInsumos.setAdapter(subcategoriaAdapter);
        tvSubcategoria.setVisibility(View.GONE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductosInsumos.setVisibility(View.VISIBLE);
        rvProductosInsumos.setAdapter(productoAdapter);
    }
}
