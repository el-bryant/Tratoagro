package empre.hoy.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida810EmpezarTutorial25Info2PescaActivity extends AppCompatActivity {
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_10_empezar_tutorial_2_5_info_2_pesca);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/pesca.jpg").into(ivFondo);
    }
}
