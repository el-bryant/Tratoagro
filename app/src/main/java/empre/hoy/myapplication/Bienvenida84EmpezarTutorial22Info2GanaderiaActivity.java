package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGanaderia;

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

public class Bienvenida84EmpezarTutorial22Info2GanaderiaActivity extends AppCompatActivity {
    Button btnSubcategoriasGanaderia;
    ImageView ivFondo;
    Map<String, String> params;
    public static RecyclerView rvProductosGanaderia, rvSubcategoriasGanaderia;
    public static TextView tvSubcategoria;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_4_empezar_tutorial_2_2_info_2_ganaderia);
        webService = new WebService(this);
        btnSubcategoriasGanaderia = (Button) findViewById(R.id.btnSubcategoriasGanaderia);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvProductosGanaderia = (RecyclerView) findViewById(R.id.rvProductosGanaderia);
        rvSubcategoriasGanaderia = (RecyclerView) findViewById(R.id.rvSubcategoriasGanaderia);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvProductosGanaderia.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoriasGanaderia.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load(fondoGanaderia).into(ivFondo);
        btnSubcategoriasGanaderia.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "1");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoriasGanaderia.setVisibility(View.VISIBLE);
        rvSubcategoriasGanaderia.setAdapter(subcategoriaAdapter);
        tvSubcategoria.setVisibility(View.GONE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductosGanaderia.setVisibility(View.VISIBLE);
        rvProductosGanaderia.setAdapter(productoAdapter);
    }
}
