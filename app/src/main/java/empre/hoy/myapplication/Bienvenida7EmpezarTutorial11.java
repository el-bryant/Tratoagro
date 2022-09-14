package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bienvenida7EmpezarTutorial11 extends AppCompatActivity {
    LinearLayout llayFertilizantes, llayGanaderia, llayInsumos, llayMaquinaria, llayPesca, llayPesticidas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_7_empezar_tutorial_1_1);
        llayFertilizantes = (LinearLayout) findViewById(R.id.llayFertilizantes);
        llayGanaderia = (LinearLayout) findViewById(R.id.llayGanaderia);
        llayInsumos = (LinearLayout) findViewById(R.id.llayInsumos);
        llayMaquinaria = (LinearLayout) findViewById(R.id.llayMaquinaria);
        llayPesca = (LinearLayout) findViewById(R.id.llayPesca);
        llayPesticidas = (LinearLayout) findViewById(R.id.llayPesticidas);
        llayGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial11.this, Bienvenida83EmpezarTutorial22Info1GanaderiaActivity.class));
//            finish();
        });
        llayPesca.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial11.this, Bienvenida89EmpezarTutorial25Info1PescaActivity.class));
//            finish();
        });
        llayMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial11.this, Bienvenida87EmpezarTutorial24Info1MaquinariaActivity.class));
//            finish();
        });
        llayInsumos.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial11.this, Bienvenida85EmpezarTutorial23Info1InsumosActivity.class));
//            finish();
        });
        llayFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial11.this, Bienvenida81EmpezarTutorial21Info1FertilizantesActivity.class));
//            finish();
        });
        llayPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida7EmpezarTutorial11.this, Bienvenida811EmpezarTutorial26Info1PesticidasActivity.class));
//            finish();
        });
    }
}
