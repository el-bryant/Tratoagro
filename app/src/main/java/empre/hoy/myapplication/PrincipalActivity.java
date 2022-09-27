package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.databinding.ActivityEspacioalclienteBinding;

public class PrincipalActivity extends AppCompatActivity {
    ImageView ivFondo;
    LinearLayout llayComprarVender, llayNoticias, llayEspacioCliente, llayEstadisticas, llayConocenos, llayCerrarSesion;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        prefUtil = new PrefUtil(this);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        llayComprarVender = (LinearLayout) findViewById(R.id.llayComprarVender);
        llayEstadisticas = (LinearLayout) findViewById(R.id.llayEstadisticas);
        llayCerrarSesion = (LinearLayout) findViewById(R.id.llayCerrarSesion);
        llayNoticias = (LinearLayout) findViewById(R.id.llayNoticias);
        llayEspacioCliente = (LinearLayout) findViewById(R.id.llayEspacioCliente);
        llayConocenos = (LinearLayout) findViewById(R.id.llayConocenos);
        Picasso.get().load(fondoGeneral).into(ivFondo);
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
