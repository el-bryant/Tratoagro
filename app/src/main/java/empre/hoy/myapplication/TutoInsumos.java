package empre.hoy.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.CategoriaAdapter;

public class TutoInsumos extends AppCompatActivity {
    WebService webservice;
    Map<String, String> params;
//    Button btseleccionar4;
//    public static RecyclerView ruvcategoriasinsumos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_5_empezar_tutorial_2_3_info_1_insumos);
        webservice = new WebService( this);
//        btseleccionar4=(Button)findViewById(R.id.btseleccionar1);
//        ruvcategoriasinsumos=(RecyclerView)findViewById(R.id.ruvcategoriasinsumos);
//        ruvcategoriasinsumos.setLayoutManager(new LinearLayoutManager(this));
//        btseleccionar4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ruvcategoriasinsumos.setVisibility(View.VISIBLE);
//                obtenerCategorias();
//            }
//        });
    }

    public void obtenerCategorias() {
        Log.i("obtenerCategorias", "TutoInsumos");
        params = new HashMap<>();
        webservice.consulta(params,"obtener_categorias_insumos.php");
    }

    public static void mostrarCategorias(CategoriaAdapter categoriaAdapter) {
        Log.i("mostrarCategorias", "TutoInsumos");
//        ruvcategoriasinsumos.setAdapter(categoriaAdapter);
    }
}