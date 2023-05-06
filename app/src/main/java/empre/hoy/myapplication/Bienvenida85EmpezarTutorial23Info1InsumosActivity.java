package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoInsumos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida85EmpezarTutorial23Info1InsumosActivity extends AppCompatActivity {
    Button btnContinuar, btnMenuPrincipal;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_5_empezar_tutorial_2_3_info_1_insumos);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        btnMenuPrincipal = (Button) findViewById(R.id.btnMenuPrincipal);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoInsumos).into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida85EmpezarTutorial23Info1InsumosActivity.this, Bienvenida86EmpezarTutorial23Info2InsumosActivity.class));
            finish();
        });
        btnMenuPrincipal.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida85EmpezarTutorial23Info1InsumosActivity.this, PrincipalActivity.class));
            finish();
        });
    }
}
