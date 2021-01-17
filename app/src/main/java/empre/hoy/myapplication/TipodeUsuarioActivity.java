package empre.hoy.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TipodeUsuarioActivity extends AppCompatActivity {
    AdvancedCardView acvpersonanaturalblanco, acvpersonanaturaldorado, acvpersonajuridicablanco, acvpersonajuridicadorado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tipodeusuario);
        acvpersonajuridicablanco = (AdvancedCardView) findViewById(R.id.acvpersonajuridicablanco);
        acvpersonajuridicadorado = (AdvancedCardView) findViewById(R.id.acvpersonajuridicadorado);
        acvpersonanaturalblanco = (AdvancedCardView) findViewById(R.id.acvpersonanaturalblanco);
        acvpersonanaturaldorado = (AdvancedCardView) findViewById(R.id.acvpersonanaturaldorado);
        acvpersonanaturalblanco.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                acvpersonanaturalblanco.setVisibility(View.GONE);
                acvpersonanaturaldorado.setVisibility(View.VISIBLE);
                acvpersonajuridicadorado.setVisibility(View.GONE);
                acvpersonajuridicablanco.setVisibility(View.VISIBLE);
            }
        });
        acvpersonajuridicablanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acvpersonajuridicablanco.setVisibility(View.GONE);
                acvpersonajuridicadorado.setVisibility(View.VISIBLE);
                acvpersonanaturaldorado.setVisibility(View.GONE);
                acvpersonanaturalblanco.setVisibility(View.VISIBLE);
            }
        });
    }
}
