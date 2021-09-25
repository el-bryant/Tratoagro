package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TutoGanaderia extends AppCompatActivity {
    Button btseleccionar3;
    RecyclerView ruvcategoriasganaderia;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoganaderia);
        btseleccionar3=(Button)findViewById(R.id.btseleccionar3);
        ruvcategoriasganaderia=(RecyclerView)findViewById(R.id.ruvcategoriasganaderia);
        ruvcategoriasganaderia.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriasganaderia.setVisibility(View.VISIBLE);
            }
        });
    }
}