package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bienvenida6DatosNatural3Activity extends AppCompatActivity {
    Button btnListo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_6_datos_natural_3);
        btnListo = (Button) findViewById(R.id.btnListo);
        btnListo.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida6DatosNatural3Activity.this, Bienvenida7EmpezarTutorial1.class));
            finish();
        });
    }
}
