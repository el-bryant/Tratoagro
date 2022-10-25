package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Vender1Activity extends AppCompatActivity {
    ImageView ivContinuar, ivFondo;
    TextView tvDolares, tvMoneda, tvSoles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_1);
        ivContinuar = (ImageView) findViewById(R.id.ivContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        tvDolares = (TextView) findViewById(R.id.tvDolares);
        tvMoneda = (TextView) findViewById(R.id.tvMoneda);
        tvSoles = (TextView) findViewById(R.id.tvSoles);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        tvMoneda.setOnClickListener(v -> {
            tvSoles.setVisibility(View.VISIBLE);
            tvDolares.setVisibility(View.VISIBLE);
            tvMoneda.setText("Seleccione...");
        });
        tvSoles.setOnClickListener(v -> {
            tvSoles.setVisibility(View.GONE);
            tvDolares.setVisibility(View.GONE);
            tvMoneda.setText("PEN");
        });
        tvDolares.setOnClickListener(v -> {
            tvSoles.setVisibility(View.GONE);
            tvDolares.setVisibility(View.GONE);
            tvMoneda.setText("USD");
        });
        ivContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Vender1Activity.this, Vender2Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Vender1Activity.this, ComprarVenderActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
