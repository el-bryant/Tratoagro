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

public class TutoPesca extends AppCompatActivity {
    WebService webservice;
    Map<String, String> params;
//    Button btseleccionar5;
//    public static RecyclerView ruvcategoriaspesca;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_12_1_empezar_tutorial_2_5_info_1_pesca);
        webservice = new WebService(this);
//        btseleccionar5=(Button)findViewById(R.id.btseleccionar1);
//        ruvcategoriaspesca=(RecyclerView)findViewById(R.id.ruvcategoriaspesca);
//        ruvcategoriaspesca.setLayoutManager(new LinearLayoutManager(this));
//        btseleccionar5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ruvcategoriaspesca.setVisibility(View.VISIBLE);
//                obtenerCategorias();
//            }
//        });
    }

    public void obtenerCategorias() {
        Log.i("obtenerCategorias", "TutoPesca");
        params = new HashMap<>();
        webservice.consulta(params,"obtener_categorias_pesca.php");
    }

    public static void mostrarCategorias(CategoriaAdapter categoriaAdapter) {
        Log.i("mostrarCategorias", "TutoPesca");
//        ruvcategoriaspesca.setAdapter(categoriaAdapter);
    }
}