package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Bienvenida5DatosJuridico2Activity;
import empre.hoy.myapplication.Bienvenida6DatosNatural2Activity;
import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.EstadisticasGeneralActivity;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.PerfilVentaProductosActivity;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Categoria;

public class ProvinciaAdapter extends RecyclerView.Adapter<ProvinciaAdapter.viewHolder> {
    Activity activity;
    ArrayList<Categoria> provincias;
    Map<String, String> params;
    WebService webService;

    public ProvinciaAdapter(Activity activity, ArrayList<Categoria> categorias) {
        this.activity = activity;
        this.provincias = categorias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_departamento, parent, false);
        return new ProvinciaAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria categoria = provincias.get(position);
        int idProvincia = categoria.getIdCategoria();
        String nombreProvincia = categoria.getNombre();
        holder.tvNombreProvincia.setText(nombreProvincia);
        holder.tvNombreProvincia.setOnClickListener(v -> {
            if (activity instanceof Comprar2Activity) {
                Comprar2Activity.tvProvincia.setText(nombreProvincia);
                Comprar2Activity.rvProvincia.setVisibility(View.GONE);
                Comprar2Activity.provincia = idProvincia;
            }
            if (activity instanceof EstadisticasGeneralActivity) {
                EstadisticasGeneralActivity.tvProvincia.setText(nombreProvincia);
                EstadisticasGeneralActivity.rvProvincia.setVisibility(View.GONE);
            }
            if (activity instanceof Bienvenida5DatosJuridico2Activity) {
                Bienvenida5DatosJuridico2Activity.tvProvincia.setText(nombreProvincia);
                Bienvenida5DatosJuridico2Activity.rvProvincia.setVisibility(View.GONE);
            }
            if (activity instanceof Bienvenida6DatosNatural2Activity) {
                Bienvenida6DatosNatural2Activity.tvProvincia.setText(nombreProvincia);
                Bienvenida6DatosNatural2Activity.rvProvincia.setVisibility(View.GONE);
            }
            cargar(idProvincia);
        });
    }

    public void cargar(int idProvincia) {
        if (activity instanceof Comprar2Activity || activity instanceof EstadisticasGeneralActivity || activity instanceof Bienvenida5DatosJuridico2Activity
        || activity instanceof Bienvenida6DatosNatural2Activity) {
            webService = new WebService(activity);
            params = new HashMap<>();
            params.put("id_provincia", "" + idProvincia);
            webService.consulta(params, "buscar_distritos.php");
        }
    }

    @Override
    public int getItemCount() {
        return provincias.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView  tvNombreProvincia;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProvincia = (TextView) itemView.findViewById(R.id.tvNombreDepartamento);
        }
    }
}

