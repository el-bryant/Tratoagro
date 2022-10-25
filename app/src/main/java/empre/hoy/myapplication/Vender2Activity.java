package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Vender2Activity extends AppCompatActivity {
    ImageView ivFondo;
    LinearLayout llayFertilizantes, llayGanaderia, llayInsumos, llayMaquinaria, llayPesca, llayPesticidas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_2);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        llayFertilizantes = (LinearLayout) findViewById(R.id.llayFertilizantes);
        llayGanaderia = (LinearLayout) findViewById(R.id.llayGanaderia);
        llayInsumos = (LinearLayout) findViewById(R.id.llayInsumos);
        llayMaquinaria = (LinearLayout) findViewById(R.id.llayMaquinaria);
        llayPesca = (LinearLayout) findViewById(R.id.llayPesca);
        llayPesticidas = (LinearLayout) findViewById(R.id.llayPesticidas);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        llayFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(Vender2Activity.this, Vender3Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(Vender2Activity.this, Vender3Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayInsumos.setOnClickListener(v -> {
            startActivity(new Intent(Vender2Activity.this, Vender3Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(Vender2Activity.this, Vender3Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayPesca.setOnClickListener(v -> {
            startActivity(new Intent(Vender2Activity.this, Vender3Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(Vender2Activity.this, Vender3Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }
}
