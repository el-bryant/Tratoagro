package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bienvenida4Activity extends AppCompatActivity {
    FrameLayout flayPersonaNatural, flayPersonaJuridica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_4_registro_tipo_de_usuario);
        flayPersonaNatural = (FrameLayout) findViewById(R.id.flayPersonaNatural);
        flayPersonaJuridica = (FrameLayout) findViewById(R.id.flayPersonaJuridica);
        flayPersonaNatural.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida4Activity.this, Bienvenida6DatosNatural1Activity.class));
            finish();
        });
        flayPersonaJuridica.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida4Activity.this, Bienvenida5DatosJuridico1Activity.class));
            finish();
        });
    }
}
