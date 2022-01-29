package empre.hoy.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.Funciones.WebService;

public class DatosNatural2Activity extends AppCompatActivity {
    Button btnAceptar;
    public static Map<String, String> params;
    public static String dni;
    public static TextInputEditText tietUsuario, tietClave1, tietClave2;
    public static WebService webService;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_natural2);
        prefUtil = new PrefUtil(this);
        btnAceptar = (Button) findViewById(R.id.btnaceptar);
        tietUsuario = (TextInputEditText) findViewById(R.id.tietUsuario);
        tietClave1 = (TextInputEditText) findViewById(R.id.tietClave1);
        tietClave2 = (TextInputEditText) findViewById(R.id.tietClave2);
        webService = new WebService(this);
        if (getIntent().getExtras() != null) {
            dni = getIntent().getStringExtra("dni");
        }
        btnAceptar.setOnClickListener(v -> {
            if (tietClave1.getText().length() > 0 && tietClave2.getText().length() > 0) {
                if (tietClave1.getText().toString().equals(tietClave2.getText().toString())) {
                    params = new HashMap<>();
                    params.put("usuario", tietUsuario.getText().toString());
                    params.put("clave", tietClave1.getText().toString());
                    params.put("nombre", prefUtil.getStringValue("nombres"));
                    params.put("tipo_usuario", getIntent().getStringExtra("comprar_vender"));
                    webService.consulta(params, "registro_usuario.php");
                } else {
                    Toast.makeText(DatosNatural2Activity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(DatosNatural2Activity.this, "Debe indicar una contraseña", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void obtenerIdUsuario() {
        params = new HashMap<>();
        params.put("usuario", tietUsuario.getText().toString());
        params.put("clave", tietClave1.getText().toString());
        webService.consulta(params, "obtener_id_usuario.php");
    }

    public static void enlazar(String id_usuario) {
        params = new HashMap<>();
        params.put("dni", dni);
        params.put("id_usuario", id_usuario);
        webService.consulta(params, "enlazar_natural_usuario.php");
    }
}
