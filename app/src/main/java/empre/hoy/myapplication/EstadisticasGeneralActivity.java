package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import empre.hoy.myapplication.adapter.ProductoAdapter;
import empre.hoy.myapplication.adapter.ProvinciaAdapter;
import empre.hoy.myapplication.adapter.SubcategoriaAdapter;

public class EstadisticasGeneralActivity extends AppCompatActivity {
    ImageView ivFondo, ivSiguiente;
    public static Map<String, String> params;
    public static RecyclerView rvDepartamento, rvDistrito, rvProducto, rvProvincia, rvSubcategoria;
    public static String idCategoria;
    public static TextView tvDepartamento, tvDistrito, tvMayorista, tvMinorista, tvPersonaJuridica, tvPersonaNatural, tvProducto, tvProvincia, tvSubcategoria,
            tvTipoComerciante, tvTipoUsuario;
    public static WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_general_1);
        if (getIntent().getExtras() != null) {
            idCategoria = getIntent().getStringExtra("categoria");
        }
        webService = new WebService(this);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        ivSiguiente = (ImageView) findViewById(R.id.ivSiguiente);
        rvDepartamento = (RecyclerView) findViewById(R.id.rvDepartamento);
        rvDistrito = (RecyclerView) findViewById(R.id.rvDistrito);
        rvProducto = (RecyclerView) findViewById(R.id.rvProducto);
        rvProvincia = (RecyclerView) findViewById(R.id.rvProvincia);
        rvSubcategoria = (RecyclerView) findViewById(R.id.rvSubcategoria);
        tvDepartamento = (TextView) findViewById(R.id.tvDepartamento);
        tvDistrito = (TextView) findViewById(R.id.tvDistrito);
        tvMayorista = (TextView) findViewById(R.id.tvMayorista);
        tvMinorista = (TextView) findViewById(R.id.tvMinorista);
        tvPersonaJuridica = (TextView) findViewById(R.id.tvPersonaJuridica);
        tvPersonaNatural = (TextView) findViewById(R.id.tvPersonaNatural);
        tvProducto = (TextView) findViewById(R.id.tvProducto);
        tvProvincia = (TextView) findViewById(R.id.tvProvincia);
        tvSubcategoria = (TextView) findViewById(R.id.tvSubcategoria);
        tvTipoComerciante = (TextView) findViewById(R.id.tvTipoComerciante);
        tvTipoUsuario = (TextView) findViewById(R.id.tvTipoUsuario);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        rvDepartamento.setLayoutManager(new LinearLayoutManager(this));
        rvDistrito.setLayoutManager(new LinearLayoutManager(this));
        rvProducto.setLayoutManager(new LinearLayoutManager(this));
        rvProvincia.setLayoutManager(new LinearLayoutManager(this));
        rvSubcategoria.setLayoutManager(new LinearLayoutManager(this));
        tvTipoUsuario.setOnClickListener(v -> {
            tvPersonaNatural.setVisibility(View.VISIBLE);
            tvPersonaJuridica.setVisibility(View.VISIBLE);
        });
        tvPersonaNatural.setOnClickListener(v -> {
            tvPersonaNatural.setVisibility(View.GONE);
            tvPersonaJuridica.setVisibility(View.GONE);
            tvTipoUsuario.setText(tvPersonaNatural.getText().toString());
        });
        tvPersonaJuridica.setOnClickListener(v -> {
            tvPersonaNatural.setVisibility(View.GONE);
            tvPersonaJuridica.setVisibility(View.GONE);
            tvTipoUsuario.setText(tvPersonaJuridica.getText().toString());
        });
        tvTipoComerciante.setOnClickListener(v -> {
            tvMayorista.setVisibility(View.VISIBLE);
            tvMinorista.setVisibility(View.VISIBLE);
        });
        tvMayorista.setOnClickListener(v -> {
            tvMayorista.setVisibility(View.GONE);
            tvMinorista.setVisibility(View.GONE);
            tvTipoComerciante.setText(tvMayorista.getText().toString());
        });
        tvMinorista.setOnClickListener(v -> {
            tvMayorista.setVisibility(View.GONE);
            tvMinorista.setVisibility(View.GONE);
            tvTipoComerciante.setText(tvMinorista.getText().toString());
        });
        tvDepartamento.setOnClickListener(v -> {
            buscarDepartamentos();
        });
        tvProvincia.setOnClickListener(v -> {
            rvProvincia.setVisibility(View.VISIBLE);
        });
        tvDistrito.setOnClickListener(v -> {
            rvDistrito.setVisibility(View.VISIBLE);
        });
        tvSubcategoria.setOnClickListener(v -> {
            obtenerSubcategorias();
        });
        tvProducto.setOnClickListener(v -> {
            rvProducto.setVisibility(View.VISIBLE);
        });
        ivSiguiente.setOnClickListener(v -> {
            startActivity(new Intent(EstadisticasGeneralActivity.this, EstadiGanaderiaActivity.class)
                    .putExtra()
            );
            finish();
        });
    }

    public static void buscarDepartamentos() {
        params = new HashMap<>();
        webService.consulta(params, "buscar_departamentos.php");
    }

    public static void cargarDepartamentos(DepartamentoAdapter departamentoAdapter) {
        rvDepartamento.setAdapter(departamentoAdapter);
        rvDepartamento.setVisibility(View.VISIBLE);
    }

    public static void cargarProvincias(ProvinciaAdapter provinciaAdapter) {
        rvProvincia.setAdapter(provinciaAdapter);
    }

    public static void cargarDistritos(DistritoAdapter distritoAdapter) {
        rvDistrito.setAdapter(distritoAdapter);
    }

    public void obtenerSubcategorias() {
        params = new HashMap<>();
        params.put("categoria", idCategoria);
        webService.consulta(params, "obtener_subcategorias.php");
    }

    public static void cargarSubcategorias(SubcategoriaAdapter subcategoriaAdapter) {
        rvSubcategoria.setVisibility(View.VISIBLE);
        rvSubcategoria.setAdapter(subcategoriaAdapter);
    }

    public static void buscarProductos(ProductoAdapter productoAdapter) {
        rvProducto.setAdapter(productoAdapter);
    }
}
