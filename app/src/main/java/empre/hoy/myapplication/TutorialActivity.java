package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TutorialActivity extends AppCompatActivity {
    AdvancedCardView acvEmpezarTutorial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_7_empezar_tutorial_1);
        acvEmpezarTutorial = (AdvancedCardView) findViewById(R.id.acvEmpezarTutorial);
        acvEmpezarTutorial.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, Bienvenida7EmpezarTutorial11.class);
            startActivity(intent);
        });
    }
}
