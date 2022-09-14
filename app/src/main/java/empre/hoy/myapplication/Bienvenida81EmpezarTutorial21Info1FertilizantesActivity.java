package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida81EmpezarTutorial21Info1FertilizantesActivity extends AppCompatActivity {
    Button btnContinuar;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_1_empezar_tutorial_2_1_info_1_fertilizantes);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/fertilizantes.jpg").into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida81EmpezarTutorial21Info1FertilizantesActivity.this, Bienvenida82EmpezarTutorial21Info2FertilizantesActivity.class));
            finish();
        });
    }
}
