package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatosJuridicoActivity extends AppCompatActivity {
    Button btnaceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_juridico);
        btnaceptar=(Button) findViewById(R.id.btnaceptar);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosJuridicoActivity.this, DatosNatural2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}