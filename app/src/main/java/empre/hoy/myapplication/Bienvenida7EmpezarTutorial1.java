package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;
import com.squareup.picasso.Picasso;

public class Bienvenida7EmpezarTutorial1 extends AppCompatActivity {
    AdvancedCardView acvEmpezarTutorial;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_7_empezar_tutorial_1);
        acvEmpezarTutorial = (AdvancedCardView) findViewById(R.id.acvEmpezarTutorial);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        acvEmpezarTutorial.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial1.this, Bienvenida7EmpezarTutorial11.class));
            finish();
        });
    }
}
