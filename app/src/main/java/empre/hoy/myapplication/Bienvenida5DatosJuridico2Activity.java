package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.DepartamentoAdapter;
import empre.hoy.myapplication.adapter.DistritoAdapter;
import empre.hoy.myapplication.adapter.ProvinciaAdapter;

public class Bienvenida5DatosJuridico2Activity extends AppCompatActivity {
    ImageView ivContinuar, ivFondo;
    public static Map<String, String> params;
    public static RecyclerView rvDepartamento, rvDistrito, rvProvincia;
    public static TextView tvDepartamento, tvDistrito, tvMayorista, tvMinorista, tvProvincia, tvTipoComerciante;
    public static WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_5_datos_juridico_2);
        webService = new WebService(this);
        ivContinuar = (ImageView) findViewById(R.id.ivContinuar);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        rvDepartamento = (RecyclerView) findViewById(R.id.rvDepartamento);
        rvProvincia = (RecyclerView) findViewById(R.id.rvProvincia);
        rvDistrito = (RecyclerView) findViewById(R.id.rvDistrito);
        tvDepartamento = (TextView) findViewById(R.id.tvDepartamento);
        tvDistrito = (TextView) findViewById(R.id.tvDistrito);
        tvMayorista = (TextView) findViewById(R.id.tvMayorista);
        tvMinorista = (TextView) findViewById(R.id.tvMinorista);
        tvProvincia = (TextView) findViewById(R.id.tvProvincia);
        tvTipoComerciante = (TextView) findViewById(R.id.tvTipoComerciante);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        rvDepartamento.setLayoutManager(new LinearLayoutManager(this));
        rvDistrito.setLayoutManager(new LinearLayoutManager(this));
        rvProvincia.setLayoutManager(new LinearLayoutManager(this));
        tvTipoComerciante.setOnClickListener(v -> {
            tvMinorista.setVisibility(View.VISIBLE);
            tvMayorista.setVisibility(View.VISIBLE);
        });
        tvMinorista.setOnClickListener(v -> {
            tvTipoComerciante.setText("Minorista");
            tvMinorista.setVisibility(View.GONE);
            tvMayorista.setVisibility(View.GONE);
        });
        tvMayorista.setOnClickListener(v -> {
            tvTipoComerciante.setText("Mayorista");
            tvMinorista.setVisibility(View.GONE);
            tvMayorista.setVisibility(View.GONE);
        });
        tvDepartamento.setOnClickListener(v -> {
            rvDepartamento.setVisibility(View.VISIBLE);
        });
        tvProvincia.setOnClickListener(v -> {
            rvProvincia.setVisibility(View.VISIBLE);
        });
        tvDistrito.setOnClickListener(v -> {
            rvDistrito.setVisibility(View.VISIBLE);
        });
        buscarDepartamentos();
        ivContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida5DatosJuridico2Activity.this, Bienvenida5DatosJuridico3Activity.class));
            finish();
        });
    }

    public static void buscarDepartamentos() {
        params = new HashMap<>();
        webService.consulta(params, "buscar_departamentos.php");
    }

    public static void cargarDepartamentos(DepartamentoAdapter departamentoAdapter) {
        rvDepartamento.setAdapter(departamentoAdapter);
    }

    public static void cargarProvincias(ProvinciaAdapter provinciaAdapter) {
        rvProvincia.setAdapter(provinciaAdapter);
    }

    public static void cargarDistritos(DistritoAdapter distritoAdapter) {
        rvDistrito.setAdapter(distritoAdapter);
    }
}
