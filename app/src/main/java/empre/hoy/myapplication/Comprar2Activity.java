package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.CategoriaAdapter;
import empre.hoy.myapplication.adapter.DepartamentoAdapter;
import empre.hoy.myapplication.adapter.DistritoAdapter;
import empre.hoy.myapplication.adapter.ProvinciaAdapter;

public class Comprar2Activity extends AppCompatActivity {
    public static Map<String, String> params;
    TextView tvTipoUsuario, tvPersonaNatural, tvPersonaJuridica;
    TextView tvTipoComerciante, tvMinorista, tvMayorista;
    public static TextView tvDepartamento, tvProvincia, tvDistrito, tvSubcategoria, tvProducto;
    public static RecyclerView rvDepartamento, rvProvincia, rvDistrito, rvSubcategoria, rvProducto;
    public static WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar2);
        webService = new WebService(this);
        tvTipoUsuario = (TextView) findViewById(R.id.tvTipoUsuario);
        tvPersonaNatural = (TextView) findViewById(R.id.tvPersonaNatural);
        tvPersonaJuridica = (TextView) findViewById(R.id.tvPersonaJuridica);
        tvTipoComerciante = (TextView) findViewById(R.id.tvTipoComerciante);
        tvMinorista = (TextView) findViewById(R.id.tvMinorista);
        tvMayorista = (TextView) findViewById(R.id.tvMayorista);
        tvDepartamento = (TextView) findViewById(R.id.tvDepartamento);
        tvProvincia = (TextView) findViewById(R.id.tvProvincia);
        tvDistrito = (TextView) findViewById(R.id.tvDistrito);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        tvProducto = (TextView) findViewById(R.id.tvProducto);
        rvDepartamento = (RecyclerView) findViewById(R.id.rvDepartamento);
        rvProvincia = (RecyclerView) findViewById(R.id.rvProvincia);
        rvDistrito = (RecyclerView) findViewById(R.id.rvDistrito);
        rvSubcategoria = (RecyclerView) findViewById(R.id.rvSubcategoria);
        rvProducto = (RecyclerView) findViewById(R.id.rvProducto);
        rvDepartamento.setLayoutManager(new LinearLayoutManager(this));
        rvProvincia.setLayoutManager(new LinearLayoutManager(this));
        rvDistrito.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoria.setLayoutManager(new LinearLayoutManager(this));
        rvProducto.setLayoutManager(new LinearLayoutManager(this));
        /**
         * Tipo de usuario
         */
        tvTipoUsuario.setOnClickListener(v -> {
            tvPersonaNatural.setVisibility(View.VISIBLE);
            tvPersonaJuridica.setVisibility(View.VISIBLE);
        });
        tvPersonaNatural.setOnClickListener(v -> {
            tvTipoUsuario.setText("Persona natural");
            tvPersonaNatural.setVisibility(View.GONE);
            tvPersonaJuridica.setVisibility(View.GONE);
        });
        tvPersonaJuridica.setOnClickListener(v -> {
            tvTipoUsuario.setText("Persona jurídica");
            tvPersonaNatural.setVisibility(View.GONE);
            tvPersonaJuridica.setVisibility(View.GONE);
        });
        /**
         * Tipo de comerciante
         */
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
        tvSubcategoria.setOnClickListener(v -> {
            rvSubcategoria.setVisibility(View.VISIBLE);
        });
        tvProducto.setOnClickListener(v -> {
            rvProducto.setVisibility(View.VISIBLE);
        });
        buscarDepartamentos();
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

    public static void buscarSubcategorias() {

    }

    public static void buscarProductos() {

    }
}