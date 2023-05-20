package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.DepartamentoAdapter;
import empre.hoy.myapplication.adapter.DistritoAdapter;
import empre.hoy.myapplication.adapter.ProductoAdapter;
import empre.hoy.myapplication.adapter.ProvinciaAdapter;
import empre.hoy.myapplication.adapter.SubcategoriaAdapter;

public class Comprar2Activity extends AppCompatActivity {
    ImageView ivContinuar, ivFondo;
    public static int departamento = 0, provincia = 0, distrito = 0, idProducto = 0, idSubcategoria = 0;
    public static Map<String, String> params;
    TextView tvTipoUsuario, tvPersonaNatural, tvPersonaJuridica;
    TextView tvTipoComerciante, tvMinorista, tvMayorista;
    public static TextView tvDepartamento, tvProvincia, tvDistrito, tvSubcategoria, tvProducto;
    public static RecyclerView rvDepartamento, rvProvincia, rvDistrito, rvSubcategoria, rvProducto;
    public static String idCategoria = "", tipoPersona = "", tipoVendedor = "";
    public static WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2);
        if (getIntent().getExtras() != null) {
            idCategoria = getIntent().getStringExtra("categoria");
        }
        webService = new WebService(this);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        ivContinuar = (ImageView) findViewById(R.id.ivContinuar);
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
        Picasso.get().load(fondoGeneral).into(ivFondo);
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
            tipoPersona = "N";
            tvTipoUsuario.setText("Persona natural");
            tvPersonaNatural.setVisibility(View.GONE);
            tvPersonaJuridica.setVisibility(View.GONE);
        });
        tvPersonaJuridica.setOnClickListener(v -> {
            tipoPersona = "J";
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
            tipoVendedor = "MIN";
            tvTipoComerciante.setText("Minorista");
            tvMinorista.setVisibility(View.GONE);
            tvMayorista.setVisibility(View.GONE);
        });
        tvMayorista.setOnClickListener(v -> {
            tipoVendedor = "MAY";
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
            obtenerSubcategorias();
        });
        tvProducto.setOnClickListener(v -> {
            rvProducto.setVisibility(View.VISIBLE);
        });
        buscarDepartamentos();
        ivContinuar.setOnClickListener(v -> {
            aplicarFiltros();
            switch (idCategoria) {
                case "1":
                    startActivity(new Intent(Comprar2Activity.this, Comprar22Activity.class).putExtra("categoria", "1"));
                    break;
                case "2":
                    startActivity(new Intent(Comprar2Activity.this, Comprar22Activity.class).putExtra("categoria", "2"));
                    break;
                case "3":
                    startActivity(new Intent(Comprar2Activity.this, Comprar22Activity.class).putExtra("categoria", "3"));
                    break;
                case "4":
                    startActivity(new Intent(Comprar2Activity.this, Comprar22Activity.class).putExtra("categoria", "4"));
                    break;
                case "5":
                    startActivity(new Intent(Comprar2Activity.this, Comprar22Activity.class).putExtra("categoria", "5"));
                    break;
                case "6":
                    startActivity(new Intent(Comprar2Activity.this, Comprar22Activity.class).putExtra("categoria", "6"));
                    break;
            }
            finish();
        });
    }

    public void aplicarFiltros() {
        params = new HashMap<>();
        String filtros = "WHERE s.id_usuario = u.id_usuario " +
                "AND c.id_categoria = su.id_categoria " +
                "AND su.id_subcategoria = p.id_subcategoria " +
                "AND p.id_producto = s.id_producto " +
                "AND (pj.id_usuario = u.id_usuario OR pn.id_usuario = u.id_usuario) " +
                "AND su.id_subcategoria = p.id_subcategoria ";
        if (!idCategoria.equals("")) {
            filtros = filtros + "AND c.id_categoria = " + idCategoria + " ";
        }
        if (!tipoPersona.equals("")) {
            filtros = filtros + "AND u.tipo_persona = '" + tipoPersona + "' ";
        }
        if (!tipoVendedor.equals("")) {
            filtros = filtros + "AND u.tipo_vendedor = '" + tipoVendedor + "' ";
        }
        if (departamento > 0) {
            filtros = filtros + "AND (pj.departamento = " + departamento + " OR pn.departamento = " + departamento + ") ";
        }
        if (provincia > 0) {
            filtros = filtros + "AND (pj.provincia = " + provincia + " OR pn.provincia = " + provincia + ") ";
        }
        if (distrito > 0) {
            filtros = filtros + "AND (pj.distrito = " + distrito + " OR pn.distrito = " + distrito + ") ";
        }
        if (idSubcategoria > 0) {
            filtros = filtros + "AND su.id_subcategoria = " + idSubcategoria + " ";
        }
        if (idProducto > 0) {
            filtros = filtros + "AND p.id_producto = " + idProducto;
        }
        filtros = filtros + ";";
        Log.i("filtros", filtros);
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