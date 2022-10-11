package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida6DatosNatural3Activity extends AppCompatActivity {
    Button btnListo;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_6_datos_natural_3);
        btnListo = (Button) findViewById(R.id.btnListo);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        btnListo.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida6DatosNatural3Activity.this, Bienvenida7EmpezarTutorial1.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Bienvenida6DatosNatural3Activity.this, Bienvenida4Activity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
