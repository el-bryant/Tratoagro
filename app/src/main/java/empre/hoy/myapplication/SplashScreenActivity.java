package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import empre.hoy.myapplication.Funciones.PrefUtil;

public class SplashScreenActivity extends AppCompatActivity {
    PrefUtil prefUtil;
    ImageView ivFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_1);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://static.nationalgeographic.es/files/styles/image_3200/public/1920px-llamalyingdown.jpg").into(ivFondo);
        prefUtil = new PrefUtil(this);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                if (prefUtil.getStringValue(PrefUtil.LOGIN_STATUS).equals("1")) {
                    startActivity(new Intent(SplashScreenActivity.this, Bienvenida2Activity.class));
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, Inicio1Activity.class));
                }
                finish();
            }
        }.start();
    }
}