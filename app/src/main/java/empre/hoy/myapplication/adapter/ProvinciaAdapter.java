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

import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.PerfilVentaProductosActivity;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Categoria;

public class ProvinciaAdapter extends RecyclerView.Adapter<ProvinciaAdapter.viewHolder> {
    Activity activity;
    ArrayList<Categoria> categorias;
    Map<String, String> params;
    WebService webService;

    public ProvinciaAdapter(Activity activity, ArrayList<Categoria> categorias) {
        this.activity = activity;
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_tutorial, parent, false);
        return new ProvinciaAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        String idCategoria = categoria.getIdCategoria();
        String nombreCategoria = categoria.getNombre();
        holder.tuvnombrecategoria.setText(nombreCategoria);
        holder.tuvnombrecategoria.setOnClickListener(v -> {
            Comprar2Activity.tvProvincia.setText(nombreCategoria);
            Comprar2Activity.rvProvincia.setVisibility(View.GONE);
            cargar(idCategoria);
        });
    }

    public void cargar(String idProvincia) {
        if (activity instanceof Comprar2Activity) {
            webService = new WebService(activity);
            params = new HashMap<>();
            params.put("id_provincia", idProvincia);
            webService.consulta(params, "buscar_distritos.php");
        }
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView  tuvnombrecategoria;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tuvnombrecategoria = (TextView) itemView.findViewById(R.id.tuvnombrecategoria);
        }
    }
}

