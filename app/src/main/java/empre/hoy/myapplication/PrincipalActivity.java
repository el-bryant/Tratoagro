package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import empre.hoy.myapplication.Funciones.PrefUtil;

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout llayingresar, llyparati, llyubicanos, llyespacioalcliente, llyestadisticas, llayCerrarSesion;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        prefUtil = new PrefUtil(this);
        llayingresar = (LinearLayout) findViewById(R.id.llayingresar);
        llyparati = (LinearLayout) findViewById(R.id.llyparati);
        llayCerrarSesion = (LinearLayout) findViewById(R.id.llayCerrarSesion);
        llyubicanos = (LinearLayout) findViewById(R.id.llyubicanos);
        llyespacioalcliente = (LinearLayout) findViewById(R.id.llyespacioalcliente);
        llyestadisticas = (LinearLayout) findViewById(R.id.llyestadisticas);
        llayingresar.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, IniciarSesionActivity.class);
            startActivity(intent);
        });
        llayCerrarSesion.setOnClickListener(v -> {
            prefUtil.clearAll();
            startActivity(new Intent(PrincipalActivity.this, IniciarSesionActivity.class));
        });
        llyestadisticas.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, EstadisticasGeneralActivity.class);
            startActivity(intent);
        });
        llyubicanos.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, UbicanosActivity.class);
            startActivity(intent);
        });
        llyparati.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, TutorialActivity.class);
            startActivity(intent);
        });
    }
}
