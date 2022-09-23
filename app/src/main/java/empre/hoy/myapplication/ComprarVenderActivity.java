package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sinaseyfi.advancedcardview.AdvancedCardView;
import com.squareup.picasso.Picasso;

import empre.hoy.myapplication.Funciones.PrefUtil;

public class ComprarVenderActivity extends AppCompatActivity {
    FrameLayout flayComprar, flayVender;
    ImageView ivFondo;
    Intent intent;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_o_vender);
        prefUtil = new PrefUtil(this);
        flayComprar = (FrameLayout) findViewById(R.id.flayComprar);
        flayVender = (FrameLayout) findViewById(R.id.flayVender);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        flayComprar.setOnClickListener(v -> {
            intent = new Intent(ComprarVenderActivity.this, Comprar1Activity.class);
            intent.putExtra("comprar_vender", "C");
            startActivity(intent);
            finish();
        });
        flayVender.setOnClickListener(v -> {
            intent = new Intent(ComprarVenderActivity.this, PerfilVentaProductosActivity.class);
            intent.putExtra("comprar_vender", "V");
            startActivity(intent);
            finish();
        });
    }
}