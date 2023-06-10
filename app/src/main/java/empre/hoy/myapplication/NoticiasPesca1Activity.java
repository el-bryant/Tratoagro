package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NoticiasPesca1Activity extends AppCompatActivity {
    FrameLayout flayNoticias, flayPublicidad, flayRevistas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_pesca_1);
        flayNoticias = (FrameLayout) findViewById(R.id.flayNoticias);
        flayPublicidad = (FrameLayout) findViewById(R.id.flayPublicidad);
        flayRevistas = (FrameLayout) findViewById(R.id.flayRevistas);
        flayNoticias.setOnClickListener(v -> {
            startActivity(new Intent(NoticiasPesca1Activity.this, NoticiasPesca2Activity.class));
        });
    }
}
