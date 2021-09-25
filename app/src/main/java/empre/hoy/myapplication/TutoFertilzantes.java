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

public class TutoFertilzantes extends AppCompatActivity {
    WebService webservice;
    Map<String, String> params;
    Button btseleccionar1;
    public static RecyclerView ruvcategoriasfertilizantes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutofertilizantes);
        webservice = new WebService( this);
        btseleccionar1=(Button)findViewById(R.id.btseleccionar1);
        ruvcategoriasfertilizantes=(RecyclerView)findViewById(R.id.ruvcategoriasfertilizantes);
        ruvcategoriasfertilizantes.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ruvcategoriasfertilizantes.setVisibility(View.VISIBLE);
                obtenerCategorias();
            }
        });
    }

    public void obtenerCategorias() {
        Log.i("obtenerCategorias", "TutoFertilzantes");
        params = new HashMap<>();
        webservice.consulta(params,"obtener_categorias_fertilizantes.php");
    }

    public static void mostrarCategorias(CategoriaAdapter categoriaAdapter) {
        Log.i("mostrarCategorias", "TutoFertilzantes");
        ruvcategoriasfertilizantes.setAdapter(categoriaAdapter);
    }
}


