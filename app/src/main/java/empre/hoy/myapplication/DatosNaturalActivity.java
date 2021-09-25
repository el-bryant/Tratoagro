package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatosNaturalActivity extends AppCompatActivity {
  Button btnaceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_natural);
        btnaceptar=(Button) findViewById(R.id.btnaceptar);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosNaturalActivity.this, CompraroVenderActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}