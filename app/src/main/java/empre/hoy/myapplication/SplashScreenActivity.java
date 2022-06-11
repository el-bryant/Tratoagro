package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import empre.hoy.myapplication.Funciones.PrefUtil;

public class SplashScreenActivity extends AppCompatActivity {
    PrefUtil prefUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_1);
        prefUtil = new PrefUtil(this);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                if (prefUtil.getStringValue(PrefUtil.LOGIN_STATUS).equals("1")) {
                    startActivity(new Intent(SplashScreenActivity.this, PrincipalActivity.class));
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, Inicio1Activity.class));
                }
                finish();
            }
        }.start();
    }
}