package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida5DatosJuridico3Activity extends AppCompatActivity {
    Button btnListo;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_5_datos_juridico_3);
        btnListo = (Button) findViewById(R.id.btnListo);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/machu_picchu.jpg").into(ivFondo);
        btnListo.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida5DatosJuridico3Activity.this, Bienvenida7EmpezarTutorial1.class));
        });
    }
}
