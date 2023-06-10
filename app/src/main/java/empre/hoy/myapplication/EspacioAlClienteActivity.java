package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EspacioAlClienteActivity extends AppCompatActivity {
    LinearLayout llayTratoventas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espacioalcliente);
        llayTratoventas = (LinearLayout) findViewById(R.id.llayTratoventas);
        llayTratoventas.setOnClickListener(v -> {
            startActivity(new Intent(EspacioAlClienteActivity.this, TratoventasActivity.class));
        });
    }
}
