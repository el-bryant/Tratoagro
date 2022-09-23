package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.entity.ItemCarrito;

public class Comprar1Activity extends AppCompatActivity {
    FrameLayout btnGanaderia, btnPesca, btnMaquinaria, btnInsumos, btnPesticidas, btnFertilizantes;
    ImageView ivFondo;
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
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        btnGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "1"));
        });
        btnPesca.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "6"));
        });
        btnMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "2"));
        });
        btnInsumos.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "3"));
        });
        btnPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "4"));
        });
        btnFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "5"));
        });
    }
}
