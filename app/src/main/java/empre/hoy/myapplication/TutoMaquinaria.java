package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TutoMaquinaria extends AppCompatActivity {
    Button btseleccionar6;
    RecyclerView ruvcategoriasmaquinaria;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutomaquinaria);
        btseleccionar6=(Button)findViewById(R.id.btseleccionar6);
        ruvcategoriasmaquinaria=(RecyclerView)findViewById(R.id.ruvcategoriasmaquinaria);
        ruvcategoriasmaquinaria.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriasmaquinaria.setVisibility(View.VISIBLE);
            }
        });
    }
}
