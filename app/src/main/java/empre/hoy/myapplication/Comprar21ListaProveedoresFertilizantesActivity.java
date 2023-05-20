package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoFertilizantes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Comprar21ListaProveedoresFertilizantesActivity extends AppCompatActivity {
    ImageView ivFiltro, ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2_1_lista_proveedores_fertilizantes);
        ivFiltro = (ImageView) findViewById(R.id.ivFiltro);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoFertilizantes).into(ivFondo);
        ivFiltro.setOnClickListener(v -> {
            startActivity(new Intent(Comprar21ListaProveedoresFertilizantesActivity.this, Comprar2Activity.class));
        });
    }
}
