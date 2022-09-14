package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida85EmpezarTutorial23Info1InsumosActivity extends AppCompatActivity {
    Button btnContinuar;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_5_empezar_tutorial_2_3_info_1_insumos);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/insumos.jpg").into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida85EmpezarTutorial23Info1InsumosActivity.this, Bienvenida86EmpezarTutorial23Info2InsumosActivity.class));
            finish();
        });
    }
}
