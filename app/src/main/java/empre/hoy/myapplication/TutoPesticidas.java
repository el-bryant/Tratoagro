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

public class TutoPesticidas extends AppCompatActivity {
    WebService webservice;
    Map<String, String> params;
    Button btseleccionar2;
    public static RecyclerView ruvcategoriaspesticidas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_13_1_empezar_tutorial_2_6_info_1_pesticidas);
        webservice = new WebService( this);
        btseleccionar2=(Button)findViewById(R.id.btseleccionar1);
        ruvcategoriaspesticidas=(RecyclerView)findViewById(R.id.ruvcategoriaspesticidas);
        ruvcategoriaspesticidas.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriaspesticidas.setVisibility(View.VISIBLE);
                obtenerCategorias();
            }
        });
    }

    public void obtenerCategorias() {
        Log.i("obtenerCategorias", "TutoPesticidas");
        params = new HashMap<>();
        webservice.consulta(params,"obtener_categorias_pesticidas.php");
    }

    public static void mostrarCategorias(CategoriaAdapter categoriaAdapter) {
        Log.i("mostrarCategorias", "TutoPesticidas");
        ruvcategoriaspesticidas.setAdapter(categoriaAdapter);
    }
}