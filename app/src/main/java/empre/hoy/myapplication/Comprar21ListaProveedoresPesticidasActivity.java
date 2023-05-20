package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoPesticidas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Comprar21ListaProveedoresPesticidasActivity extends AppCompatActivity {
    ImageView ivFiltro, ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2_1_lista_proveedores_pesticidas);
        ivFiltro = (ImageView) findViewById(R.id.ivFiltro);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoPesticidas).into(ivFondo);
        ivFiltro.setOnClickListener(v -> {
            startActivity(new Intent(Comprar21ListaProveedoresPesticidasActivity.this, Comprar2Activity.class));
        });
    }
}
