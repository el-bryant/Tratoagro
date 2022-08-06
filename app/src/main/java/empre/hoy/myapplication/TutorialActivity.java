package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TutorialActivity extends AppCompatActivity {
    AdvancedCardView acvvacadorado, acvpescadorado, acvvegetalesdorado, acvmaquinariadorado, acvpesticidadorado, acvfertilizantedorado;
//    Button btnSiguiente;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_7_empezar_tutorial_2);
        acvvacadorado = (AdvancedCardView) findViewById(R.id.acvvacadorado);
        acvpescadorado = (AdvancedCardView) findViewById(R.id.acvpescadorado);
        acvvegetalesdorado = (AdvancedCardView) findViewById(R.id.acvvegetalesdorado);
        acvmaquinariadorado = (AdvancedCardView) findViewById(R.id.acvmaquinariadorado);
        acvpesticidadorado = (AdvancedCardView) findViewById(R.id.acvpesticidadorado);
        acvfertilizantedorado = (AdvancedCardView) findViewById(R.id.acvfertilizantedorado);
//        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        acvvacadorado.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, TutoGanaderia.class);
            startActivity(intent);
        });
        acvpescadorado.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, TutoPesca.class);
            startActivity(intent);
        });
        acvvegetalesdorado.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, TutoInsumos.class);
            startActivity(intent);
        });
        acvmaquinariadorado.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, TutoMaquinaria.class);
            startActivity(intent);
        });
        acvpesticidadorado.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, TutoPesticidas.class);
            startActivity(intent);
        });
        acvfertilizantedorado.setOnClickListener(v -> {
            Intent intent = new Intent(TutorialActivity.this, TutoFertilzantes.class);
            startActivity(intent);
        });
//        btnSiguiente.setOnClickListener(v -> {
//            Intent intent = new Intent(TutorialActivity.this, PerfilUsuarioCompraActivity.class);
//            startActivity(intent);
//        });
    }
}
