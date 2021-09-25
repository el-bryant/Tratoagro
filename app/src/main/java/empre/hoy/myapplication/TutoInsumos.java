package empre.hoy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TutoInsumos extends AppCompatActivity {
    Button btseleccionar4;
    RecyclerView ruvcategoriasinsumos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoinsumos);
        btseleccionar4=(Button)findViewById(R.id.btseleccionar4);
        ruvcategoriasinsumos=(RecyclerView)findViewById(R.id.ruvcategoriasinsumos);
        ruvcategoriasinsumos.setLayoutManager(new LinearLayoutManager(this));
        btseleccionar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruvcategoriasinsumos.setVisibility(View.VISIBLE);
            }
        });
    }
}