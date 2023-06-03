package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NoticiasGeneral2Activity extends AppCompatActivity {
    FrameLayout flayFertilizantes, flayGanaderia, flayInsumos, flayMaquinaria, flayPesca, flayPesticidas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_general_2);
        flayFertilizantes = (FrameLayout) findViewById(R.id.flayFertilizantes);
        flayGanaderia = (FrameLayout) findViewById(R.id.flayGanaderia);
        flayInsumos = (FrameLayout) findViewById(R.id.flayInsumos);
        flayMaquinaria = (FrameLayout) findViewById(R.id.flayMaquinaria);
        flayPesca = (FrameLayout) findViewById(R.id.flayPesca);
        flayPesticidas = (FrameLayout) findViewById(R.id.flayPesticidas);
        flayFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasGeneral2Activity.this, NoticiasFertilizantes1Activity.class));
        });
        flayGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasGeneral2Activity.this, NoticiasGanaderia1Activity.class));
        });
        flayInsumos.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasGeneral2Activity.this, NoticiasInsumos1Activity.class));
        });
        flayMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasGeneral2Activity.this, NoticiasMaquinaria1Activity.class));
        });
        flayPesca.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasGeneral2Activity.this, NoticiasPesca1Activity.class));
        });
        flayPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasGeneral2Activity.this, NoticiasPesticidas1Activity.class));
        });
    }
}
