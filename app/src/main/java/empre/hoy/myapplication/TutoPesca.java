package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TutoPesca extends AppCompatActivity {
    Button btseleccionar5;
    RecyclerView ruvcategoriaspesca;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutopesca);
        btseleccionar5=(Button)findViewById(R.id.btseleccionar5);
        ruvcategoriaspesca=(RecyclerView)findViewById(R.id.ruvcategoriaspesca);
        ruvcategoriaspesca.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriaspesca.setVisibility(View.VISIBLE);
            }
        });
    }
}