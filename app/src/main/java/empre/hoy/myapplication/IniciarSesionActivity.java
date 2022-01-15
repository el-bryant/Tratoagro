package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;

public class IniciarSesionActivity extends AppCompatActivity {
    Button btnaceptar;
    TextInputEditText etCorreo, etClave;
    Map<String, String> params;
    WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        webService = new WebService(this);
        btnaceptar = (Button) findViewById(R.id.btnaceptar);
        etCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        etClave = (TextInputEditText) findViewById(R.id.tietClave);
        btnaceptar.setOnClickListener(v -> iniciarSesion());
    }

    public void iniciarSesion() {
        params = new HashMap<>();
        params.put("correo", etCorreo.getText().toString());
        params.put("clave", etClave.getText().toString());
        webService.consulta(params, "iniciar_sesion.php");
    }
}