package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida3Activity extends AppCompatActivity {
    Button btnRegistrar;
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_3);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        btnRegistrar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida3Activity.this, Bienvenida4Activity.class));
            finish();
        });
    }
}
