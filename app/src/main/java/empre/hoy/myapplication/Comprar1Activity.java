package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.entity.ItemCarrito;

public class Comprar1Activity extends AppCompatActivity {
    LinearLayout llayGanaderia, llayPesca, llayMaquinaria, llayInsumos, llayPesticidas, llayFertilizantes;
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
        llayGanaderia = (LinearLayout) findViewById(R.id.llayGanaderia);
        llayPesca = (LinearLayout) findViewById(R.id.llayPesca);
        llayMaquinaria = (LinearLayout) findViewById(R.id.llayMaquinaria);
        llayInsumos = (LinearLayout) findViewById(R.id.llayInsumos);
        llayPesticidas = (LinearLayout) findViewById(R.id.llayPesticidas);
        llayFertilizantes = (LinearLayout) findViewById(R.id.llayFertilizantes);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        llayGanaderia.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "1"));
        });
        llayPesca.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "6"));
        });
        llayMaquinaria.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "2"));
        });
        llayInsumos.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "3"));
        });
        llayPesticidas.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "4"));
        });
        llayFertilizantes.setOnClickListener(v -> {
            startActivity(new Intent(Comprar1Activity.this, Comprar2Activity.class).putExtra("categoria", "5"));
        });
    }
}
