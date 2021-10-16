package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesionActivity extends AppCompatActivity {
    Button btnaceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        btnaceptar = (Button) findViewById(R.id.btnaceptar);
        btnaceptar.setOnClickListener(v -> {
            Intent intent = new Intent(IniciarSesionActivity.this, PerfilCategoriasCompra.class);
            startActivity(intent);
            finish();
        });
    }
}