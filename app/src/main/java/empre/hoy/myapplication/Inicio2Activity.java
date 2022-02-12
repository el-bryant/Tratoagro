package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Inicio2Activity extends AppCompatActivity {
    LinearLayout llayIniciarTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);
        llayIniciarTutorial = (LinearLayout) findViewById(R.id.llayIniciarTutorial);
        llayIniciarTutorial.setOnClickListener(v -> {
            startActivity(new Intent(Inicio2Activity.this, ComprarVenderActivity.class));
            finish();
        });
    }
}