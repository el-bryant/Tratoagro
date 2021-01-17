package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    Button btnregistrarse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnregistrarse=(Button) findViewById(R.id.btnregistrarse);
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrincipalActivity.this, TipodeUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }
}
