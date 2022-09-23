package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida4Activity extends AppCompatActivity {
    FrameLayout flayPersonaNatural, flayPersonaJuridica;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_4_registro_tipo_de_usuario);
        flayPersonaNatural = (FrameLayout) findViewById(R.id.flayPersonaNatural);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
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
