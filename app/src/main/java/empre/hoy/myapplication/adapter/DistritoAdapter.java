package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Map;
import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Categoria;

public class DistritoAdapter extends RecyclerView.Adapter<DistritoAdapter.viewHolder> {
    Activity activity;
    ArrayList<Categoria> categorias;
    Map<String, String> params;
    WebService webService;

    public DistritoAdapter(Activity activity, ArrayList<Categoria> categorias) {
        this.activity = activity;
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_tutorial, parent, false);
        return new DistritoAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        String idCategoria = categoria.getIdCategoria();
        String nombreCategoria = categoria.getNombre();
        holder.tvNombreCategoria.setText(nombreCategoria);
        holder.tvNombreCategoria.setOnClickListener(v -> {
            Comprar2Activity.tvDistrito.setText(nombreCategoria);
            Comprar2Activity.rvDistrito.setVisibility(View.GONE);
        });
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

