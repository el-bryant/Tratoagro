package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import empre.hoy.myapplication.R;
import empre.hoy.myapplication.Vender1Activity;
import empre.hoy.myapplication.entity.Unidad;

public class UnidadAdapter extends RecyclerView.Adapter<UnidadAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Unidad> unidades;

    public UnidadAdapter(Activity activity, ArrayList<Unidad> unidades) {
        this.activity = activity;
        this.unidades = unidades;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_texto_blanco, viewGroup, false);
        return new UnidadAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Unidad unidad = unidades.get(i);
        int idUnidad = unidad.getIdUnidad();
        String nombre = unidad.getNombre();
        viewHolder.tvNombre.setText(nombre);
        viewHolder.tvNombre.setOnClickListener(v -> {
            if (activity instanceof Vender1Activity) {
                Vender1Activity.rvUnidades.setVisibility(View.GONE);
                Vender1Activity.tvUnidad.setText(nombre);
            }
        });
    }

    @Override
    public int getItemCount() {
        return unidades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        }
    }
}
