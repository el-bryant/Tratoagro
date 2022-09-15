package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.PerfilVentaProductosActivity;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Categoria;

public class DepartamentoAdapter extends RecyclerView.Adapter<DepartamentoAdapter.viewHolder> {
    Activity activity;
    ArrayList<Categoria> categorias;
    Map<String, String> params;
    WebService webService;

    public DepartamentoAdapter(Activity activity, ArrayList<Categoria> categorias) {
        this.activity = activity;
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_tutorial, parent, false);
        return new DepartamentoAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        String idCategoria = categoria.getIdCategoria();
        String nombreCategoria = categoria.getNombre();
        holder.tvNombreCategoria.setText(nombreCategoria);
        holder.tvNombreCategoria.setOnClickListener(v -> {
            Comprar2Activity.tvDepartamento.setText(nombreCategoria);
            Comprar2Activity.rvDepartamento.setVisibility(View.GONE);
            cargar(idCategoria);
        });
    }

    public void cargar(String idDepartamento) {
        if (activity instanceof Comprar2Activity) {
            webService = new WebService(activity);
            params = new HashMap<>();
            params.put("id_departamento", idDepartamento);
            webService.consulta(params, "buscar_provincias.php");
        }
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView  tvNombreCategoria;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCategoria = (TextView) itemView.findViewById(R.id.tvNombreCategoria);
        }
    }
}

