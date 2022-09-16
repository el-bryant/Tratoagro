package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.databinding.ActivityEspacioalclienteBinding;

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout llayComprarVender, llayNoticias, llayEspacioCliente, llayEstadisticas, llayConocenos, llayCerrarSesion;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        prefUtil = new PrefUtil(this);
        llayComprarVender = (LinearLayout) findViewById(R.id.llayComprarVender);
        llayEstadisticas = (LinearLayout) findViewById(R.id.llayEstadisticas);
        llayCerrarSesion = (LinearLayout) findViewById(R.id.llayCerrarSesion);
        llayNoticias = (LinearLayout) findViewById(R.id.llayNoticias);
        llayEspacioCliente = (LinearLayout) findViewById(R.id.llayEspacioCliente);
        llayConocenos = (LinearLayout) findViewById(R.id.llayConocenos);
        llayComprarVender.setOnClickListener(v -> {
            startActivity(new Intent(PrincipalActivity.this, ComprarVenderActivity.class));
        });
        llayCerrarSesion.setOnClickListener(v -> {
            prefUtil.clearAll();
            startActivity(new Intent(PrincipalActivity.this, IniciarSesionActivity.class));
            finish();
        });
        llayEstadisticas.setOnClickListener(v -> {
            startActivity(new Intent(PrincipalActivity.this, EstadisticasGeneral2Activity.class));
        });
        llayNoticias.setOnClickListener(v -> {
            startActivity(new Intent(PrincipalActivity.this, NoticiasGeneral2Activity.class));
        });
        llayConocenos.setOnClickListener(v -> {
//            startActivity(new Intent(PrincipalActivity.this, UbicanosActivity.class));
        });
        llayEspacioCliente.setOnClickListener(v -> {
            startActivity(new Intent(PrincipalActivity.this, EspacioAlClienteActivity.class));
        });
    }
}
