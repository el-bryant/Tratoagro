package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class DatosNaturalActivity extends AppCompatActivity {
    Button btnaceptar;
    String dni, nombres, apellidos, celular, correo, ubicacion;
    TextInputEditText tietDni, tietNombres, tietApellidos, tietCelular, tietCorreo, tietUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_natural);
        btnaceptar = (Button) findViewById(R.id.btnaceptar);
        tietDni = (TextInputEditText) findViewById(R.id.tietDni);
        tietNombres = (TextInputEditText) findViewById(R.id.tietNombres);
        tietApellidos = (TextInputEditText) findViewById(R.id.tietApellidos);
        tietCelular = (TextInputEditText) findViewById(R.id.tietCelular);
        tietCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        tietUbicacion = (TextInputEditText) findViewById(R.id.tietUbicacion);
        btnaceptar.setOnClickListener(v -> {
            Intent intent = new Intent(DatosNaturalActivity.this, DatosNatural2Activity.class);
            dni = tietDni.getText().toString();
            nombres = tietNombres.getText().toString();
            apellidos = tietApellidos.getText().toString();
            celular = tietCelular.getText().toString();
            correo = tietCorreo.getText().toString();
            ubicacion = tietUbicacion.getText().toString();
            intent.putExtra("dni", dni);
            intent.putExtra("nombres", nombres);
            intent.putExtra("apellidos", apellidos);
            intent.putExtra("celular", celular);
            intent.putExtra("correo", correo);
            intent.putExtra("ubicacion", ubicacion);
            startActivity(intent);
            finish();
        });
    }
}