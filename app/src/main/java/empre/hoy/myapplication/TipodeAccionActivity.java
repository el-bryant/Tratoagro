package empre.hoy.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TipodeAccionActivity extends AppCompatActivity {
    FrameLayout flayFertilizantes, flayGanaderia, flayInsumos, flayMaquinaria, flayPesca, flayPesticidas;

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
    }
}