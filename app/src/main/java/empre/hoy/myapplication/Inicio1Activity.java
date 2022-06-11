package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Inicio1Activity extends AppCompatActivity {
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_3);
        btnRegistro = (Button) findViewById(R.id.btnRegistrar);
        btnRegistro.setOnClickListener(v -> {
            startActivity(new Intent(Inicio1Activity.this, TipoUsuarioActivity.class));
            finish();
        });
    }
}