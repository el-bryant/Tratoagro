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

import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Categoria;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.viewHolder> {
    Activity activity;
    ArrayList<Categoria> categorias;

    public CategoriaAdapter(Activity activity, ArrayList<Categoria> categorias) {
        this.activity = activity;
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_tutorial, parent, false);
        return new CategoriaAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        String nombreCategoria = categoria.getNombre();
        holder.tuvnombrecategoria.setText(nombreCategoria);
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

