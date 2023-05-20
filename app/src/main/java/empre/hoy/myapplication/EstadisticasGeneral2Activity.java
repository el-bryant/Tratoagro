package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class EstadisticasGeneral2Activity extends AppCompatActivity {
    FrameLayout flayFertilizantes, flayGanaderia, flayInsumos, flayMaquinaria, flayPesca, flayPesticidas;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_general_2);
        flayFertilizantes = (FrameLayout) findViewById(R.id.flayFertilizantes);
        flayGanaderia = (FrameLayout) findViewById(R.id.flayGanaderia);
        flayInsumos = (FrameLayout) findViewById(R.id.flayInsumos);
        flayMaquinaria = (FrameLayout) findViewById(R.id.flayMaquinaria);
        flayPesca = (FrameLayout) findViewById(R.id.flayPesca);
        flayPesticidas = (FrameLayout) findViewById(R.id.flayPesticidas);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        flayFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneral2Activity.this, EstadiFertilizantesActivity.class).putExtra("categoria", "5"));
            finish();
        });
        flayGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneral2Activity.this, EstadiGanaderiaActivity.class).putExtra("categoria", "1"));
            finish();
        });
        flayInsumos.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneral2Activity.this, EstadiInsumosActivity.class).putExtra("categoria", "3"));
            finish();
        });
        flayMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneral2Activity.this, EstadiMaquinariaActivity.class).putExtra("categoria", "2"));
            finish();
        });
        flayPesca.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneral2Activity.this, EstadiPescaActivity.class).putExtra("categoria", "6"));
            finish();
        });
        flayPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneral2Activity.this, EstadiPesticidasActivity.class).putExtra("categoria", "4"));
            finish();
        });
    }
}
