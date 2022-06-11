package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.entity.ItemCarrito;

public class Comprar1Activity extends AppCompatActivity {
    FrameLayout btnGanaderia, btnPesca, btnMaquinaria, btnInsumos, btnPesticidas, btnFertilizantes;
    public static ArrayList<ItemCarrito> itemsCarrito;
    public static double total;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_1);
        prefUtil = new PrefUtil(this);
        itemsCarrito = new ArrayList<>();
        total = 0.0;
        btnGanaderia = (FrameLayout) findViewById(R.id.flayGanaderia);
        btnPesca = (FrameLayout) findViewById(R.id.flayPesca);
        btnMaquinaria = (FrameLayout) findViewById(R.id.flayMaquinaria);
        btnInsumos = (FrameLayout) findViewById(R.id.flayInsumos);
        btnPesticidas = (FrameLayout) findViewById(R.id.flayPesticidas);
        btnFertilizantes = (FrameLayout) findViewById(R.id.flayFertilizantes);
        btnGanaderia.setOnClickListener(v -> {
            Intent intent = new Intent(Comprar1Activity.this, Comprar2Activity.class);
            intent.putExtra("categoria", "1");
            startActivity(intent);
        });
        btnPesca.setOnClickListener(v -> {
            Intent intent = new Intent(Comprar1Activity.this, Comprar2Activity.class);
            intent.putExtra("categoria", "6");
            startActivity(intent);
        });
        btnMaquinaria.setOnClickListener(v -> {
            Intent intent = new Intent(Comprar1Activity.this, Comprar2Activity.class);
            intent.putExtra("categoria", "2");
            startActivity(intent);
        });
        btnInsumos.setOnClickListener(v -> {
            Intent intent = new Intent(Comprar1Activity.this, Comprar2Activity.class);
            intent.putExtra("categoria", "3");
            startActivity(intent);
        });
        btnPesticidas.setOnClickListener(v -> {
            Intent intent = new Intent(Comprar1Activity.this, Comprar2Activity.class);
            intent.putExtra("categoria", "4");
            startActivity(intent);
        });
        btnFertilizantes.setOnClickListener(v -> {
            Intent intent = new Intent(Comprar1Activity.this, Comprar2Activity.class);
            intent.putExtra("categoria", "5");
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
