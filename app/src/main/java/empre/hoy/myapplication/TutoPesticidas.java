package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TutoPesticidas extends AppCompatActivity {
    Button btseleccionar2;
    RecyclerView ruvcategoriaspesticidas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutopesticidas);
        btseleccionar2=(Button)findViewById(R.id.btseleccionar1);
        ruvcategoriaspesticidas=(RecyclerView)findViewById(R.id.ruvcategoriaspesticidas);
        ruvcategoriaspesticidas.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriaspesticidas.setVisibility(View.VISIBLE);
            }
        });
    }
}