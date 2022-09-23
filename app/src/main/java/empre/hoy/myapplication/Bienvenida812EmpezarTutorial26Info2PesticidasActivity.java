package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoPesticidas;

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

public class Bienvenida812EmpezarTutorial26Info2PesticidasActivity extends AppCompatActivity {
    Button btnSubcategoriasPesticidas;
    ImageView ivFondo;
    Map<String, String> params;
    public static RecyclerView rvProductosPesticidas, rvSubcategoriasPesticidas;
    public static TextView tvSubcategoria;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_12_empezar_tutorial_2_6_info_2_pesticidas);
        webService = new WebService(this);
        btnSubcategoriasPesticidas = (Button) findViewById(R.id.btnSubcategoriasPesticidas);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvProductosPesticidas = (RecyclerView) findViewById(R.id.rvProductosPesticidas);
        rvSubcategoriasPesticidas = (RecyclerView) findViewById(R.id.rvSubcategoriasPesticidas);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        rvProductosPesticidas.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoriasPesticidas.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load(fondoPesticidas).into(ivFondo);
        btnSubcategoriasPesticidas.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", "4");
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoriasPesticidas.setVisibility(View.VISIBLE);
        rvSubcategoriasPesticidas.setAdapter(subcategoriaAdapter);
        tvSubcategoria.setVisibility(View.GONE);
    }

    public static void cargarProductos(ProductoAdapter productoAdapter) {
        rvProductosPesticidas.setVisibility(View.VISIBLE);
        rvProductosPesticidas.setAdapter(productoAdapter);
    }
}
