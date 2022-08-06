package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class EstadisticasGeneralActivity extends AppCompatActivity {
    AdvancedCardView acvvacadorado, acvpescadorado, acvvegetalesdorado, acvmaquinariadorado, acvpesticidadorado, acvfertilizantedorado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_general_2);
        acvvacadorado = (AdvancedCardView) findViewById(R.id.acvvacadorado);
        acvpescadorado = (AdvancedCardView) findViewById(R.id.acvpescadorado);
        acvvegetalesdorado = (AdvancedCardView) findViewById(R.id.acvvegetalesdorado);
        acvmaquinariadorado = (AdvancedCardView) findViewById(R.id.acvmaquinariadorado);
        acvpesticidadorado = (AdvancedCardView) findViewById(R.id.acvpesticidadorado);
        acvfertilizantedorado = (AdvancedCardView) findViewById(R.id.acvfertilizantedorado);
        acvvacadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasGeneralActivity.this, EstadiGanaderiaActivity.class);
                startActivity(intent);
            }
        });
        acvpescadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasGeneralActivity.this, EstadiPescaActivity.class);
                startActivity(intent);
            }
        });
        acvvegetalesdorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasGeneralActivity.this, EstadiInsumosActivity.class);
                startActivity(intent);
            }
        });
        acvmaquinariadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasGeneralActivity.this, EstadiMaquinariaActivity.class);
                startActivity(intent);
            }
        });
        acvpesticidadorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasGeneralActivity.this, EstadiPesticidasActivity.class);
                startActivity(intent);
            }
        });
        acvfertilizantedorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasGeneralActivity.this, EstadiFertilizantesActivity.class);
                startActivity(intent);
            }
        });
    }
}
