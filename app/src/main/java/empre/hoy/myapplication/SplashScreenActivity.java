package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import empre.hoy.myapplication.Funciones.PrefUtil;

public class SplashScreenActivity extends AppCompatActivity {
    PrefUtil prefUtil;
    ImageView ivFondo, ivIsotipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_1);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        ivIsotipo = (ImageView) findViewById(R.id.ivIsotipo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/machu_picchu.jpg").into(ivFondo);
        prefUtil = new PrefUtil(this);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
//                if (prefUtil.getStringValue(PrefUtil.LOGIN_STATUS).equals("1")) {
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashScreenActivity.this, ivIsotipo,
                        ivIsotipo.getTransitionName());
                startActivity(new Intent(SplashScreenActivity.this, Bienvenida2Activity.class), options.toBundle());
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
//                } else {
//                    startActivity(new Intent(SplashScreenActivity.this, Inicio1Activity.class));
//                }
                finish();
            }
        }.start();
    }
}