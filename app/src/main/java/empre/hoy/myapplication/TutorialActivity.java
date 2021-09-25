package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TutorialActivity extends AppCompatActivity {
    AdvancedCardView acvvacadorado, acvpescadorado, acvvegetalesdorado, acvmaquinariadorado, acvpesticidadorado, acvfertilizantedorado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        acvvacadorado = (AdvancedCardView) findViewById(R.id.acvvacadorado);
        acvpescadorado = (AdvancedCardView) findViewById(R.id.acvpescadorado);
        acvvegetalesdorado = (AdvancedCardView) findViewById(R.id.acvvegetalesdorado);
        acvmaquinariadorado = (AdvancedCardView) findViewById(R.id.acvmaquinariadorado);
        acvpesticidadorado = (AdvancedCardView) findViewById(R.id.acvpesticidadorado);
        acvfertilizantedorado = (AdvancedCardView) findViewById(R.id.acvfertilizantedorado);
        acvvacadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutoGanaderia.class);
                startActivity(intent);
            }
        });
        acvpescadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutoPesca.class);
                startActivity(intent);
            }
        });
        acvvegetalesdorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutoInsumos.class);
                startActivity(intent);
            }
        });
        acvmaquinariadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutoMaquinaria.class);
                startActivity(intent);
            }
        });
        acvpesticidadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutoPesticidas.class);
                startActivity(intent);
            }
        });
        acvfertilizantedorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, TutoFertilzantes.class);
                startActivity(intent);
            }
        });
    }
}
