package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.databinding.ActivityEspacioalclienteBinding;

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout llaycomprarovender, llyparati, llynoticias, llyespacioalcliente, llyestadisticas, llyconfiguracion, llayCerrarSesion;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        prefUtil = new PrefUtil(this);
        llaycomprarovender = (LinearLayout) findViewById(R.id.llaycomprarovender);
        llyestadisticas = (LinearLayout) findViewById(R.id.llyestadisticas);
        llayCerrarSesion = (LinearLayout) findViewById(R.id.llayCerrarSesion);
        llynoticias = (LinearLayout) findViewById(R.id.llynoticias);
        llyespacioalcliente = (LinearLayout) findViewById(R.id.llyespacioalcliente);
        llyconfiguracion = (LinearLayout) findViewById(R.id.llyconfiguracion);
        llaycomprarovender.setOnClickListener(v -> {
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
        llynoticias.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, UbicanosActivity.class);
            startActivity(intent);
        });
        llyconfiguracion.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, UbicanosActivity.class);
            startActivity(intent);
        });
        llyparati.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, ActivityEspacioalcliente.class);
            startActivity(intent);
        });
    }
}
