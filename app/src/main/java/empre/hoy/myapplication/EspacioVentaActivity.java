package empre.hoy.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import empre.hoy.myapplication.Funciones.PrefUtil;

public class EspacioVentaActivity  extends AppCompatActivity {
    PrefUtil prefUtil;
    TextView tvRazonSocial, tvCerrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_2);
        prefUtil = new PrefUtil(this);
//        tvCerrar = (TextView) findViewById(R.id.tvCerrar);
        tvRazonSocial = (TextView) findViewById(R.id.tvRazonSocial);
//        tvCerrar.setOnClickListener(v -> {
//            prefUtil.clearAll();
//            startActivity(new Intent(EspacioVentaActivity.this, PrincipalActivity.class));
//            finish();
//        });
        tvRazonSocial.setText(prefUtil.getStringValue("razon_social"));
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
