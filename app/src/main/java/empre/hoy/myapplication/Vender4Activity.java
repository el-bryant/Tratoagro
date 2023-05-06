package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Vender4Activity extends AppCompatActivity {
    Button btnSi, btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender4);
        btnSi = (Button) findViewById(R.id.btnSi);
        btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setOnClickListener(v -> {
            startActivity(new Intent(Vender4Activity.this, PrincipalActivity.class));
            finish();
        });
    }
}