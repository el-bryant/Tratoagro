package empre.hoy.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida86EmpezarTutorial23Info2InsumosActivity extends AppCompatActivity {
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_6_empezar_tutorial_2_3_info_2_insumos);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/insumos.jpg").into(ivFondo);
    }
}
