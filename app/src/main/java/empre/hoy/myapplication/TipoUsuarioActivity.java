package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TipoUsuarioActivity extends AppCompatActivity {
    FrameLayout acvPersonaNatural, acvPersonaJuridica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_4_registro_tipo_de_usuario);
        acvPersonaNatural = (FrameLayout) findViewById(R.id.flayPersonaNatural);
        acvPersonaJuridica = (FrameLayout) findViewById(R.id.flayPersonaJuridica);
        acvPersonaNatural.setOnClickListener(v -> {
            Intent intent = new Intent(TipoUsuarioActivity.this, Bienvenida6DatosNatural1Activity.class);
            intent.putExtra("tipo", "n");
            startActivity(intent);
            finish();
        });
        acvPersonaJuridica.setOnClickListener(v -> {
            Intent intent = new Intent(TipoUsuarioActivity.this, ComprarVenderActivity.class);
            intent.putExtra("tipo", "j");
            startActivity(intent);
            finish();
        });
    }
}
