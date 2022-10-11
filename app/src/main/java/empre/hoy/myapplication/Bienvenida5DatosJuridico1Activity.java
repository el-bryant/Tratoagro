package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida5DatosJuridico1Activity extends AppCompatActivity {
    ImageView ivContinuar, ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_5_datos_juridico_1);
        ivContinuar = (ImageView) findViewById(R.id.ivContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        ivContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida5DatosJuridico1Activity.this, Bienvenida5DatosJuridico2Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }
}
