package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoPesca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida89EmpezarTutorial25Info1PescaActivity extends AppCompatActivity {
    Button btnContinuar;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_9_empezar_tutorial_2_5_info_1_pesca);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoPesca).into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida89EmpezarTutorial25Info1PescaActivity.this, Bienvenida810EmpezarTutorial25Info2PescaActivity.class));
            finish();
        });
    }
}
