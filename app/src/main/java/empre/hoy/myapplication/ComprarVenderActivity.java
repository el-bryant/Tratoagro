package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sinaseyfi.advancedcardview.AdvancedCardView;
import empre.hoy.myapplication.Funciones.PrefUtil;

public class ComprarVenderActivity extends AppCompatActivity {
    AdvancedCardView acvComprar, acvVender;
    Intent intent;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_vender);
        prefUtil = new PrefUtil(this);
        acvComprar = (AdvancedCardView) findViewById(R.id.acvComprar);
        acvVender = (AdvancedCardView) findViewById(R.id.acvVender);
        acvComprar.setOnClickListener(v -> {
            intent = new Intent(ComprarVenderActivity.this, Comprar1Activity.class);
            intent.putExtra("comprar_vender", "C");
            startActivity(intent);
            finish();
        });
        acvVender.setOnClickListener(v -> {
            intent = new Intent(ComprarVenderActivity.this, PerfilVentaProductosActivity.class);
            intent.putExtra("comprar_vender", "V");
            startActivity(intent);
            finish();
        });
    }
}