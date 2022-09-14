package empre.hoy.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Bienvenida84EmpezarTutorial22Info2GanaderiaActivity extends AppCompatActivity {
    ImageView ivFondo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_8_4_empezar_tutorial_2_2_info_2_ganaderia);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/ganader%C3%ADa.jpg").into(ivFondo);
    }
}
