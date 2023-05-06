package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoMaquinaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida87EmpezarTutorial24Info1MaquinariaActivity extends AppCompatActivity {
    Button btnContinuar, btnMenuPrincipal;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_7_empezar_tutorial_2_4_info_1_maquinaria);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        btnMenuPrincipal = (Button) findViewById(R.id.btnMenuPrincipal);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoMaquinaria).into(ivFondo);
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida87EmpezarTutorial24Info1MaquinariaActivity.this, Bienvenida88mpezarTutorial24Info2MaquinariaActivity.class));
            finish();
        });
        btnMenuPrincipal.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida87EmpezarTutorial24Info1MaquinariaActivity.this, PrincipalActivity.class));
            finish();
        });
    }
}
