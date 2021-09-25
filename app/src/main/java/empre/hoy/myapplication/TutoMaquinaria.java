package empre.hoy.myapplication;

import android.content.Intent;
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

public class TutoMaquinaria extends AppCompatActivity {
    WebService webservice;
    Map<String, String> params;
    Button btseleccionar6;
    public static RecyclerView ruvcategoriasmaquinaria;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutomaquinaria);
        webservice = new WebService( this);
        btseleccionar6=(Button)findViewById(R.id.btseleccionar1);
        ruvcategoriasmaquinaria=(RecyclerView)findViewById(R.id.ruvcategoriasmaquinaria);
        ruvcategoriasmaquinaria.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriasmaquinaria.setVisibility(View.VISIBLE);
                obtenerCategorias();
            }
        });
    }

    public void obtenerCategorias() {
        Log.i("obtenerCategorias", "TutoMaquinaria");
        params = new HashMap<>();
        webservice.consulta(params,"obtener_categorias_maquinaria.php");
    }

    public static void mostrarCategorias(CategoriaAdapter categoriaAdapter) {
        Log.i("mostrarCategorias", "TutoMaquinaria");
        ruvcategoriasmaquinaria.setAdapter(categoriaAdapter);
    }
}
