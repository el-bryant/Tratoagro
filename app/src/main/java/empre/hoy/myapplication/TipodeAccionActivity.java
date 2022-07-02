package empre.hoy.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TipodeAccionActivity extends AppCompatActivity {
    AdvancedCardView acvvacadorado, acvvacablanco, acvpescadorado, acvpescablanco, acvvegetalesdorado, acvvegetalesblanco, acvmaquinariadorado, acvmaquinariablanco, acvpesticidadorado, acvpesticidablanco, acvfertilizantedorado, acvfertilizanteblanco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticiasgeneral);
        acvvacadorado = (AdvancedCardView) findViewById(R.id.acvvacadorado);
        acvvacablanco = (AdvancedCardView) findViewById(R.id.acvvacablanco);
        acvpescadorado = (AdvancedCardView) findViewById(R.id.acvpescadorado);
        acvpescablanco = (AdvancedCardView) findViewById(R.id.acvpescablanco);
        acvvegetalesdorado = (AdvancedCardView) findViewById(R.id.acvvegetalesdorado);
        acvvegetalesblanco = (AdvancedCardView) findViewById(R.id.acvvegetalesblanco);
        acvmaquinariadorado = (AdvancedCardView) findViewById(R.id.acvmaquinariadorado);
        acvmaquinariablanco = (AdvancedCardView) findViewById(R.id.acvmaquinariablanco);
        acvpesticidadorado = (AdvancedCardView) findViewById(R.id.acvpesticidadorado);
        acvpesticidablanco = (AdvancedCardView) findViewById(R.id.acvpesticidablanco);
        acvfertilizantedorado = (AdvancedCardView) findViewById(R.id.acvfertilizantedorado);
        acvfertilizanteblanco = (AdvancedCardView) findViewById(R.id.acvfertilizanteblanco);
        acvvacablanco.setOnClickListener(v -> {
            acvvacadorado.setVisibility(View.VISIBLE);
            acvvacablanco.setVisibility(View.GONE);
            acvpescadorado.setVisibility(View.GONE);
            acvpescablanco.setVisibility(View.VISIBLE);
            acvvegetalesdorado.setVisibility(View.GONE);
            acvvegetalesblanco.setVisibility(View.VISIBLE);
            acvmaquinariadorado.setVisibility(View.GONE);
            acvmaquinariablanco.setVisibility(View.VISIBLE);
            acvpesticidadorado.setVisibility(View.GONE);
            acvpesticidablanco.setVisibility(View.VISIBLE);
            acvfertilizantedorado.setVisibility(View.GONE);
            acvfertilizanteblanco.setVisibility(View.VISIBLE);
        });
        acvpescablanco.setOnClickListener(v -> {
            acvvacadorado.setVisibility(View.GONE);
            acvvacablanco.setVisibility(View.VISIBLE);
            acvpescadorado.setVisibility(View.VISIBLE);
            acvpescablanco.setVisibility(View.GONE);
            acvvegetalesdorado.setVisibility(View.GONE);
            acvvegetalesblanco.setVisibility(View.VISIBLE);
            acvmaquinariadorado.setVisibility(View.GONE);
            acvmaquinariablanco.setVisibility(View.VISIBLE);
            acvpesticidadorado.setVisibility(View.GONE);
            acvpesticidablanco.setVisibility(View.VISIBLE);
            acvfertilizantedorado.setVisibility(View.GONE);
            acvfertilizanteblanco.setVisibility(View.VISIBLE);
        });
        acvvegetalesblanco.setOnClickListener(v -> {
            acvvacadorado.setVisibility(View.GONE);
            acvvacablanco.setVisibility(View.VISIBLE);
            acvpescadorado.setVisibility(View.GONE);
            acvpescablanco.setVisibility(View.VISIBLE);
            acvvegetalesdorado.setVisibility(View.VISIBLE);
            acvvegetalesblanco.setVisibility(View.GONE);
            acvmaquinariadorado.setVisibility(View.GONE);
            acvmaquinariablanco.setVisibility(View.VISIBLE);
            acvpesticidadorado.setVisibility(View.GONE);
            acvpesticidablanco.setVisibility(View.VISIBLE);
            acvfertilizantedorado.setVisibility(View.GONE);
            acvfertilizanteblanco.setVisibility(View.VISIBLE);
        });
        acvmaquinariablanco.setOnClickListener(v -> {
            acvvacadorado.setVisibility(View.GONE);
            acvvacablanco.setVisibility(View.VISIBLE);
            acvpescadorado.setVisibility(View.GONE);
            acvpescablanco.setVisibility(View.VISIBLE);
            acvvegetalesdorado.setVisibility(View.GONE);
            acvvegetalesblanco.setVisibility(View.VISIBLE);
            acvmaquinariadorado.setVisibility(View.VISIBLE);
            acvmaquinariablanco.setVisibility(View.GONE);
            acvpesticidadorado.setVisibility(View.GONE);
            acvpesticidablanco.setVisibility(View.VISIBLE);
            acvfertilizantedorado.setVisibility(View.GONE);
            acvfertilizanteblanco.setVisibility(View.VISIBLE);
        });
        acvpesticidablanco.setOnClickListener(v -> {
            acvvacadorado.setVisibility(View.GONE);
            acvvacablanco.setVisibility(View.VISIBLE);
            acvpescadorado.setVisibility(View.GONE);
            acvpescablanco.setVisibility(View.VISIBLE);
            acvvegetalesdorado.setVisibility(View.GONE);
            acvvegetalesblanco.setVisibility(View.VISIBLE);
            acvmaquinariadorado.setVisibility(View.GONE);
            acvmaquinariablanco.setVisibility(View.VISIBLE);
            acvpesticidadorado.setVisibility(View.VISIBLE);
            acvpesticidablanco.setVisibility(View.GONE);
            acvfertilizantedorado.setVisibility(View.GONE);
            acvfertilizanteblanco.setVisibility(View.VISIBLE);
        });
        acvfertilizanteblanco.setOnClickListener(v -> {
            acvvacadorado.setVisibility(View.GONE);
            acvvacablanco.setVisibility(View.VISIBLE);
            acvpescadorado.setVisibility(View.GONE);
            acvpescablanco.setVisibility(View.VISIBLE);
            acvvegetalesdorado.setVisibility(View.GONE);
            acvvegetalesblanco.setVisibility(View.VISIBLE);
            acvmaquinariadorado.setVisibility(View.GONE);
            acvmaquinariablanco.setVisibility(View.VISIBLE);
            acvpesticidadorado.setVisibility(View.GONE);
            acvpesticidablanco.setVisibility(View.VISIBLE);
            acvfertilizantedorado.setVisibility(View.VISIBLE);
            acvfertilizanteblanco.setVisibility(View.GONE);
        });
    }
}