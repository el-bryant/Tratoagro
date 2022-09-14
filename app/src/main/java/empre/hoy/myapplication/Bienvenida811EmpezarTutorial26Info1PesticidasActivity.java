package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida811EmpezarTutorial26Info1PesticidasActivity extends AppCompatActivity {
    Button btnContinuar;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_11_empezar_tutorial_2_6_info_1_pesticidas);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/pesticidas.jpg").into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida811EmpezarTutorial26Info1PesticidasActivity.this, Bienvenida812EmpezarTutorial26Info2PesticidasActivity.class));
            finish();
        });
    }
}
