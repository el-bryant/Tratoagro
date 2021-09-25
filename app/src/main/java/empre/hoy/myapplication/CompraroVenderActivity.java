package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class CompraroVenderActivity extends AppCompatActivity {
    AdvancedCardView acvvenderdorado, acvvenderblanco, acvcomprardorado, acvcomprarblanco;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_comprarovender);
        acvvenderdorado = (AdvancedCardView) findViewById(R.id.acvvenderdorado);
        acvvenderblanco = (AdvancedCardView) findViewById(R.id.acvvenderverde);
        acvcomprardorado = (AdvancedCardView) findViewById(R.id.acvcomprardorado);
        acvcomprarblanco = (AdvancedCardView) findViewById(R.id.acvcomprarverde);
        acvvenderblanco.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View v) {
            acvvenderdorado.setVisibility(View.VISIBLE);
            acvvenderblanco.setVisibility(View.GONE);
            acvcomprardorado.setVisibility(View.GONE);
            acvcomprarblanco.setVisibility(View.VISIBLE);
        Intent intent = new Intent(CompraroVenderActivity.this,TipodeAccionActivity.class);
        startActivity(intent);
        finish();
        }});

        acvcomprarblanco.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                acvvenderdorado.setVisibility(View.GONE);
                acvvenderblanco.setVisibility(View.VISIBLE);
                acvcomprardorado.setVisibility(View.VISIBLE);
                acvcomprarblanco.setVisibility(View.GONE);
                Intent intent = new Intent(CompraroVenderActivity.this,TipodeAccionActivity.class);
                startActivity(intent);
                finish();
            }});
    }

}