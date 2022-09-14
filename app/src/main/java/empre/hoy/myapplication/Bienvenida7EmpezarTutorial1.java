package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class Bienvenida7EmpezarTutorial1 extends AppCompatActivity {
    AdvancedCardView acvEmpezarTutorial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_7_empezar_tutorial_1);
        acvEmpezarTutorial = (AdvancedCardView) findViewById(R.id.acvEmpezarTutorial);
        acvEmpezarTutorial.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial1.this, Bienvenida7EmpezarTutorial11.class));
            finish();
        });
    }
}
