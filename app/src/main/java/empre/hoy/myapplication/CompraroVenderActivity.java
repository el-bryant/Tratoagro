package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

import empre.hoy.myapplication.Funciones.PrefUtil;

public class CompraroVenderActivity extends AppCompatActivity {
    AdvancedCardView acvvenderdorado, acvvenderblanco, acvcomprardorado, acvcomprarblanco;
    Intent intent;
    PrefUtil prefUtil;
    String tipo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_comprarovender);
        if (getIntent().getExtras() != null) {
            tipo = getIntent().getStringExtra("tipo");
        }
        prefUtil = new PrefUtil(this);
        acvvenderdorado = (AdvancedCardView) findViewById(R.id.acvvenderdorado);
        acvvenderblanco = (AdvancedCardView) findViewById(R.id.acvvenderverde);
        acvcomprardorado = (AdvancedCardView) findViewById(R.id.acvcomprardorado);
        acvcomprarblanco = (AdvancedCardView) findViewById(R.id.acvcomprarverde);
        acvvenderdorado.setOnClickListener(v -> {
            acvvenderdorado.setVisibility(View.GONE);
            acvvenderblanco.setVisibility(View.VISIBLE);
            acvcomprardorado.setVisibility(View.VISIBLE);
            acvcomprarblanco.setVisibility(View.GONE);
            switch (tipo) {
                case "n":
                    intent = new Intent(CompraroVenderActivity.this, DatosNaturalActivity.class);
                    break;
                case "j":
                    intent = new Intent(CompraroVenderActivity.this, DatosJuridicoActivity.class);
                    break;
            }
            intent.putExtra("tipo", tipo);
            prefUtil.saveGenericValue("comprar_vender", "v");
            startActivity(intent);
            finish();
        });
        acvcomprardorado.setOnClickListener(v -> {
            acvvenderdorado.setVisibility(View.VISIBLE);
            acvvenderblanco.setVisibility(View.GONE);
            acvcomprardorado.setVisibility(View.GONE);
            acvcomprarblanco.setVisibility(View.VISIBLE);
            switch (tipo) {
                case "n":
                    intent = new Intent(CompraroVenderActivity.this, DatosNaturalActivity.class);
                    break;
                case "j":
                    intent = new Intent(CompraroVenderActivity.this, DatosJuridicoActivity.class);
                    break;
            }
            intent.putExtra("tipo", tipo);
            prefUtil.saveGenericValue("comprar_vender", "c");
            startActivity(intent);
            finish();
        });
    }
}