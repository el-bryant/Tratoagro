package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida6DatosNatural2Activity extends AppCompatActivity {
    Button btnMayoristaClaro, btnMayoristaOscuro, btnMinoristaClaro, btnMinoristaOscuro, btnContinuar;
    boolean mayorista = true, minorista = false;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_6_datos_natural_2);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        btnMayoristaClaro = (Button) findViewById(R.id.btnMayoristaClaro);
        btnMayoristaOscuro = (Button) findViewById(R.id.btnMayoristaOscuro);
        btnMinoristaClaro = (Button) findViewById(R.id.btnMinoristaClaro);
        btnMinoristaOscuro = (Button) findViewById(R.id.btnMinoristaOscuro);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        btnMayoristaClaro.setOnClickListener(v -> {
            btnMayoristaClaro.setVisibility(View.GONE);
            btnMayoristaOscuro.setVisibility(View.VISIBLE);
            btnMinoristaClaro.setVisibility(View.VISIBLE);
            btnMinoristaOscuro.setVisibility(View.GONE);
            mayorista = true;
            minorista = false;
        });
        btnMinoristaClaro.setOnClickListener(v -> {
            btnMinoristaClaro.setVisibility(View.GONE);
            btnMinoristaOscuro.setVisibility(View.VISIBLE);
            btnMayoristaClaro.setVisibility(View.VISIBLE);
            btnMayoristaOscuro.setVisibility(View.GONE);
            mayorista = false;
            minorista = true;
        });
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida6DatosNatural2Activity.this, Bienvenida6DatosNatural3Activity.class));
            finish();
        });
    }
}
