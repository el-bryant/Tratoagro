package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TipodeUsuarioActivity extends AppCompatActivity {
    AdvancedCardView acvpersonanaturalverde, acvpersonanaturaldorado, acvpersonajuridicaverde, acvpersonajuridicadorado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tipodeusuario);
        acvpersonajuridicaverde = (AdvancedCardView) findViewById(R.id.acvpersonajuridicaverde);
        acvpersonajuridicadorado = (AdvancedCardView) findViewById(R.id.acvpersonajuridicadorado);
        acvpersonanaturalverde = (AdvancedCardView) findViewById(R.id.acvpersonanaturalverde);
        acvpersonanaturaldorado = (AdvancedCardView) findViewById(R.id.acvpersonanaturaldorado);
        acvpersonanaturaldorado.setOnClickListener(v -> {
            acvpersonanaturaldorado.setVisibility(View.GONE);
            acvpersonanaturalverde.setVisibility(View.VISIBLE);
            acvpersonajuridicadorado.setVisibility(View.GONE);
            acvpersonajuridicaverde.setVisibility(View.VISIBLE);
            Intent intent = new Intent(TipodeUsuarioActivity.this, CompraroVenderActivity.class);
            intent.putExtra("tipo", "n");
            startActivity(intent);
            finish();
        });
        acvpersonajuridicadorado.setOnClickListener(v -> {
            acvpersonajuridicaverde.setVisibility(View.GONE);
            acvpersonajuridicadorado.setVisibility(View.VISIBLE);
            acvpersonanaturaldorado.setVisibility(View.GONE);
            acvpersonanaturalverde.setVisibility(View.VISIBLE);
            Intent intent = new Intent(TipodeUsuarioActivity.this, CompraroVenderActivity.class);
            intent.putExtra("tipo", "j");
            startActivity(intent);
            finish();
        });
    }
}
