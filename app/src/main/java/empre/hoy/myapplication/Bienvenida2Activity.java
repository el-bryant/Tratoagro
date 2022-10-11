package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida2Activity extends AppCompatActivity {
    ImageView ivContinuar, ivFondo, ivIsotipo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_2);
        ivContinuar = (ImageView) findViewById(R.id.ivContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        ivIsotipo = (ImageView) findViewById(R.id.ivIsotipo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        ivContinuar.setOnClickListener(v -> {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,
                    Pair.create(ivIsotipo, ivIsotipo.getTransitionName())
            );
            startActivity(new Intent(Bienvenida2Activity.this, Bienvenida3Activity.class), activityOptions.toBundle());
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }
}
