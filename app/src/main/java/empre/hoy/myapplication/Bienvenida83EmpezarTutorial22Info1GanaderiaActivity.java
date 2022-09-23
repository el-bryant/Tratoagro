package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGanaderia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida83EmpezarTutorial22Info1GanaderiaActivity extends AppCompatActivity {
    Button btnContinuar;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_3_empezar_tutorial_2_2_info_1_ganaderia);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGanaderia).into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida83EmpezarTutorial22Info1GanaderiaActivity.this, Bienvenida84EmpezarTutorial22Info2GanaderiaActivity.class));
            finish();
        });
    }
}
