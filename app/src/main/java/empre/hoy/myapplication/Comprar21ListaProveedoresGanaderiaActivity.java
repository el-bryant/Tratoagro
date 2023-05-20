package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGanaderia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Comprar21ListaProveedoresGanaderiaActivity extends AppCompatActivity {
    ImageView ivFiltro, ivFondo;
    RelativeLayout rlayProveedor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2_1_lista_proveedores_ganaderia);
        ivFiltro = (ImageView) findViewById(R.id.ivFiltro);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rlayProveedor = (RelativeLayout) findViewById(R.id.rlayProveedor);
        Picasso.get().load(fondoGanaderia).into(ivFondo);
        rlayProveedor.setOnClickListener(v -> {
            startActivity(new Intent(Comprar21ListaProveedoresGanaderiaActivity.this, Comprar22Activity.class));
            finish();
        });
        ivFiltro.setOnClickListener(v -> {
            startActivity(new Intent(Comprar21ListaProveedoresGanaderiaActivity.this, Comprar2Activity.class));
        });
    }
}
