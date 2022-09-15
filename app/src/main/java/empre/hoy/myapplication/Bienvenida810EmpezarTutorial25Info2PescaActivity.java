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

public class Bienvenida810EmpezarTutorial25Info2PescaActivity extends AppCompatActivity {
    Button btnSubcategoriasPesca;
    ImageView ivFondo;
    Map<String, String> params;
    public static RecyclerView rvProductosPesca, rvSubcategoriasPesca;
    public static TextView tvSubcategoria;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_10_empezar_tutorial_2_5_info_2_pesca);
        webService = new WebService(this);
        btnSubcategoriasPesca = (Button) findViewById(R.id.btnSubcategoriasPesca);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvProductosPesca = (RecyclerView) findViewById(R.id.rvProductosPesca);
        rvSubcategoriasPesca = (RecyclerView) findViewById(R.id.rvSubcategoriasPesca);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvProductosPesca.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoriasPesca.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/pesca.jpg").into(ivFondo);
        btnSubcategoriasPesca.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "6");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoriasPesca.setVisibility(View.VISIBLE);
        rvSubcategoriasPesca.setAdapter(subcategoriaAdapter);
        tvSubcategoria.setVisibility(View.GONE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductosPesca.setVisibility(View.VISIBLE);
        rvProductosPesca.setAdapter(productoAdapter);
    }
}
