package empre.hoy.myapplication;

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

public class Bienvenida88mpezarTutorial24Info2MaquinariaActivity extends AppCompatActivity {
    Button btnSubcategoriasMaquinaria;
    ImageView ivFondo;
    Map<String, String> params;
    public static RecyclerView rvProductosMaquinaria, rvSubcategoriasMaquinaria;
    public static TextView tvSubcategoria;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_8_empezar_tutorial_2_4_info_2_maquinaria);
        webService = new WebService(this);
        btnSubcategoriasMaquinaria = (Button) findViewById(R.id.btnSubcategoriasMaquinaria);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvProductosMaquinaria = (RecyclerView) findViewById(R.id.rvProductosMaquinaria);
        rvSubcategoriasMaquinaria = (RecyclerView) findViewById(R.id.rvSubcategoriasMaquinaria);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvProductosMaquinaria.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoriasMaquinaria.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/maquinaria.jpg").into(ivFondo);
        btnSubcategoriasMaquinaria.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "2");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoriasMaquinaria.setVisibility(View.VISIBLE);
        rvSubcategoriasMaquinaria.setAdapter(subcategoriaAdapter);
        tvSubcategoria.setVisibility(View.GONE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductosMaquinaria.setVisibility(View.VISIBLE);
        rvProductosMaquinaria.setAdapter(productoAdapter);
    }
}
