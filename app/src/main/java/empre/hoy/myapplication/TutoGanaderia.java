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

public class TutoGanaderia extends AppCompatActivity {
    WebService webservice;
    Map<String, String> params;
    Button btseleccionar3;
    public static RecyclerView ruvcategoriasganaderia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_9_1_empezar_tutorial_2_2_info_1_ganaderia);
        webservice = new WebService( this);
        btseleccionar3=(Button)findViewById(R.id.btseleccionar1);
        ruvcategoriasganaderia=(RecyclerView)findViewById(R.id.ruvcategoriasganaderia);
        ruvcategoriasganaderia.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriasganaderia.setVisibility(View.VISIBLE);
                obtenerCategorias();
            }
        });
    }

    public void obtenerCategorias() {
        Log.i("obtenerCategorias", "TutoGanaderia");
        params = new HashMap<>();
        webservice.consulta(params,"obtener_categorias_ganaderia.php");
    }

    public static void mostrarCategorias(CategoriaAdapter categoriaAdapter) {
        Log.i("mostrarCategorias", "TutoGanaderia");
        ruvcategoriasganaderia.setAdapter(categoriaAdapter);
    }
}