package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class PublicacionesActivity extends AppCompatActivity {
    ImageView ivFondo;
    LinearLayout llayFertilizantes, llayGanaderia, llayInsumos, llayMaquinaria, llayPesca, llayPesticidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        llayFertilizantes = (LinearLayout) findViewById(R.id.llayFertilizantes);
        llayGanaderia = (LinearLayout) findViewById(R.id.llayGanaderia);
        llayInsumos = (LinearLayout) findViewById(R.id.llayInsumos);
        llayMaquinaria = (LinearLayout) findViewById(R.id.llayMaquinaria);
        llayPesca = (LinearLayout) findViewById(R.id.llayPesca);
        llayPesticidas = (LinearLayout) findViewById(R.id.llayPesticidas);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/machu_picchu.jpg").into(ivFondo);
        llayFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(PublicacionesActivity.this, BuzonActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(PublicacionesActivity.this, BuzonActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayInsumos.setOnClickListener(v -> {
            startActivity(new Intent(PublicacionesActivity.this, BuzonActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(PublicacionesActivity.this, BuzonActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayPesca.setOnClickListener(v -> {
            startActivity(new Intent(PublicacionesActivity.this, BuzonActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        llayPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(PublicacionesActivity.this, BuzonActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }
}