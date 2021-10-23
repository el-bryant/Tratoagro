package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout llayingresar, llyparati, llyregistrarse, llyubicanos, llyespacioalcliente, llyestadisticas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        llayingresar=(LinearLayout) findViewById(R.id.llayingresar);
        llyparati=(LinearLayout) findViewById(R.id.llyparati);
        llyregistrarse=(LinearLayout) findViewById(R.id.llyregistrarse);
        llyubicanos=(LinearLayout) findViewById(R.id.llyubicanos);
        llyespacioalcliente=(LinearLayout) findViewById(R.id.llyespacioalcliente);
        llyestadisticas=(LinearLayout) findViewById(R.id.llyestadisticas);
        llayingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrincipalActivity.this, IniciarSesionActivity.class);
                startActivity(intent);
            }
        });

        llyregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrincipalActivity.this, TipodeUsuarioActivity.class);
                startActivity(intent);
            }
        });
        llyestadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, EstadisticasGeneralActivity.class);
                startActivity(intent);
            }
        });
        llyubicanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, UbicanosActivity.class);
                startActivity(intent);
            }
        });
        llyparati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });
    }
}
