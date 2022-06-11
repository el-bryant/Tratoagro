package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sinaseyfi.advancedcardview.AdvancedCardView;

public class TipoUsuarioActivity extends AppCompatActivity {
    AdvancedCardView acvPersonaNatural, acvPersonaJuridica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_4_registro_tipo_de_usuario);
        acvPersonaNatural = (AdvancedCardView) findViewById(R.id.acvPersonaNatural);
        acvPersonaJuridica = (AdvancedCardView) findViewById(R.id.acvPersonaJuridica);
        acvPersonaNatural.setOnClickListener(v -> {
            Intent intent = new Intent(TipoUsuarioActivity.this, DatosNatural1Activity.class);
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
