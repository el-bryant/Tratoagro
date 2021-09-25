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

import empre.hoy.myapplication.Funciones.WebService;

public class DatosNatural2Activity extends AppCompatActivity {
    Button btnAceptar;
    public static Map<String, String> params;
    public static String dni, nombres, apellidos, celular, correo, ubicacion;
    TextInputEditText tietUsuario, tietClave1, tietClave2;
    public static WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_natural2);
        btnAceptar = (Button) findViewById(R.id.btnaceptar);
        tietUsuario = (TextInputEditText) findViewById(R.id.tietUsuario);
        tietClave1 = (TextInputEditText) findViewById(R.id.tietClave1);
        tietClave2 = (TextInputEditText) findViewById(R.id.tietClave2);
        webService = new WebService(this);
        if (getIntent().getExtras() != null) {
            dni = getIntent().getStringExtra("dni");
            nombres = getIntent().getStringExtra("nombres");
            apellidos = getIntent().getStringExtra("apellidos");
            celular = getIntent().getStringExtra("celular");
            correo = getIntent().getStringExtra("correo");
            ubicacion = getIntent().getStringExtra("ubicacion");
        }
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tietClave1.getText().length() > 0 && tietClave2.getText().length() > 0) {
                    if (tietClave1.getText().toString().equals(tietClave2.getText().toString())) {
                        params = new HashMap<>();
                        params.put("usuario", tietUsuario.getText().toString());
                        params.put("clave", tietClave1.getText().toString());
                        webService.consulta(params, "registro_usuario.php");
                    } else {
                        Toast.makeText(DatosNatural2Activity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DatosNatural2Activity.this, "Debe indicar una contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void registroPersonaNatural() {
        params = new HashMap<>();
        params.put("dni", dni);
        params.put("nombres", nombres);
        params.put("apellidos", apellidos);
        params.put("celular", celular);
        params.put("correo", correo);
        params.put("ubicacion", ubicacion);
        webService.consulta(params, "registro_persona_natural.php");
    }
}
