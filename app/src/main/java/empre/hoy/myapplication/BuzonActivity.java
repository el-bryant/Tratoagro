package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BuzonActivity extends AppCompatActivity {
    Button btnResponder;
    ImageView ivFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzon);
        btnResponder = (Button) findViewById(R.id.btnResponder);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/machu_picchu.jpg").into(ivFondo);
        btnResponder.setOnClickListener(v -> {
            startActivity(new Intent(BuzonActivity.this, OpcionesRespuestaActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }
}