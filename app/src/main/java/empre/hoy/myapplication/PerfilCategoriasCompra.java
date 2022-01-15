package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import empre.hoy.myapplication.entity.ItemCarrito;

public class PerfilCategoriasCompra extends AppCompatActivity {
    Button btnGanaderia, btnPesca, btnMaquinaria, btnInsumos, btnPesticidas, btnFertilizantes;
    public static ArrayList<ItemCarrito> itemsCarrito;
    public static double total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfilcategoriascompra);
        itemsCarrito = new ArrayList<>();
        total = 0.0;
        btnGanaderia = (Button) findViewById(R.id.btnGanaderia);
        btnPesca = (Button) findViewById(R.id.btnPesca);
        btnMaquinaria = (Button) findViewById(R.id.btnMaquinaria);
        btnInsumos = (Button) findViewById(R.id.btnInsumos);
        btnPesticidas = (Button) findViewById(R.id.btnPesticidas);
        btnFertilizantes = (Button) findViewById(R.id.btnFertilizantes);
        btnGanaderia.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilCategoriasCompra.this, PerfilVentaProductosActivity.class);
            intent.putExtra("categoria", "1");
            startActivity(intent);
        });
        btnPesca.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilCategoriasCompra.this, PerfilVentaProductosActivity.class);
            intent.putExtra("categoria", "6");
            startActivity(intent);
        });
        btnMaquinaria.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilCategoriasCompra.this, PerfilVentaProductosActivity.class);
            intent.putExtra("categoria", "2");
            startActivity(intent);
        });
        btnInsumos.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilCategoriasCompra.this, PerfilVentaProductosActivity.class);
            intent.putExtra("categoria", "3");
            startActivity(intent);
        });
        btnPesticidas.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilCategoriasCompra.this, PerfilVentaProductosActivity.class);
            intent.putExtra("categoria", "4");
            startActivity(intent);
        });
        btnFertilizantes.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilCategoriasCompra.this, PerfilVentaProductosActivity.class);
            intent.putExtra("categoria", "5");
            startActivity(intent);
        });
    }
}
