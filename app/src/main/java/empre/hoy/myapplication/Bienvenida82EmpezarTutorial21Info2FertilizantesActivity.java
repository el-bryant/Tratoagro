package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoFertilizantes;

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

public class Bienvenida82EmpezarTutorial21Info2FertilizantesActivity extends AppCompatActivity {
    Button btnSucbategoriasFertilizantes;
    ImageView ivFondo;
    Map<String, String> params;
    public static RecyclerView rvProductosFertilizantes, rvSubcategoriasFertilizantes;
    public static TextView tvSubcategoria;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_2_empezar_tutorial_2_1_info_2_fertilizantes);
        webService = new WebService(this);
        btnSucbategoriasFertilizantes = (Button) findViewById(R.id.btnSucbategoriasFertilizantes);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvProductosFertilizantes = (RecyclerView) findViewById(R.id.rvProductosFertilizantes);
        rvSubcategoriasFertilizantes = (RecyclerView) findViewById(R.id.rvSubcategoriasFertilizantes);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvProductosFertilizantes.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoriasFertilizantes.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load(fondoFertilizantes).into(ivFondo);
        btnSucbategoriasFertilizantes.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "5");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoriasFertilizantes.setVisibility(View.VISIBLE);
        rvSubcategoriasFertilizantes.setAdapter(subcategoriaAdapter);
        tvSubcategoria.setVisibility(View.GONE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductosFertilizantes.setVisibility(View.VISIBLE);
        rvProductosFertilizantes.setAdapter(productoAdapter);
    }
}
