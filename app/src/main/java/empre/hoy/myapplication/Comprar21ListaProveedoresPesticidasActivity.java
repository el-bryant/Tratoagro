package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoPesticidas;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Comprar21ListaProveedoresPesticidasActivity extends AppCompatActivity {
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2_1_lista_proveedores_pesticidas);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoPesticidas).into(ivFondo);
    }
}
