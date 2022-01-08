package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.ProveedorAdapter;

public class ListaProveedoresActivity extends AppCompatActivity {
    Map<String, String> params;
    public static RecyclerView rvProveedores;
    public static String idProducto, nombreProducto;
    WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_proveedores);
        rvProveedores = (RecyclerView) findViewById(R.id.rvProveedores);
        rvProveedores.setLayoutManager(new LinearLayoutManager(this));
        webService = new WebService(this);
        if (getIntent().getExtras() != null) {
            idProducto = getIntent().getStringExtra("idProducto");
            nombreProducto = getIntent().getStringExtra("nombreProducto");
            buscarProveedores(idProducto);
        }
    }

    public void buscarProveedores(String idProducto) {
        params = new HashMap<>();
        params.put("id_producto", idProducto);
        webService.consulta(params, "obtener_proveedores_producto.php");
    }

    public static void cargarProveedores(ProveedorAdapter proveedorAdapter) {
        rvProveedores.setAdapter(proveedorAdapter);
        rvProveedores.setVisibility(View.VISIBLE);
    }
}