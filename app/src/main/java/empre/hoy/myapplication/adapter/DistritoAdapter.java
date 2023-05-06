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

import empre.hoy.myapplication.Bienvenida5DatosJuridico2Activity;
import empre.hoy.myapplication.Bienvenida6DatosNatural2Activity;
import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.EstadisticasGeneral2Activity;
import empre.hoy.myapplication.EstadisticasGeneralActivity;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.Vender3Activity;
import empre.hoy.myapplication.entity.Categoria;

public class DistritoAdapter extends RecyclerView.Adapter<DistritoAdapter.viewHolder> {
    Activity activity;
    ArrayList<Categoria> distritos;
    Map<String, String> params;
    WebService webService;

    public DistritoAdapter(Activity activity, ArrayList<Categoria> categorias) {
        this.activity = activity;
        this.distritos = categorias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_departamento, parent, false);
        return new DistritoAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Categoria categoria = distritos.get(position);
        int idDistrito = categoria.getIdCategoria();
        String nombreDistrito = categoria.getNombre();
        holder.tvNombreDistrito.setText(nombreDistrito);
        holder.tvNombreDistrito.setOnClickListener(v -> {
            if (activity instanceof Comprar2Activity) {
                Comprar2Activity.tvDistrito.setText(nombreDistrito);
                Comprar2Activity.rvDistrito.setVisibility(View.GONE);
                Comprar2Activity.distrito = idDistrito;
            }
            if (activity instanceof EstadisticasGeneralActivity) {
                EstadisticasGeneralActivity.tvDistrito.setText(nombreDistrito);
                EstadisticasGeneralActivity.rvDistrito.setVisibility(View.GONE);
            }
            if (activity instanceof Bienvenida5DatosJuridico2Activity) {
                Bienvenida5DatosJuridico2Activity.tvDistrito.setText(nombreDistrito);
                Bienvenida5DatosJuridico2Activity.rvDistrito.setVisibility(View.GONE);
            }
            if (activity instanceof Bienvenida6DatosNatural2Activity) {
                Bienvenida6DatosNatural2Activity.tvDistrito.setText(nombreDistrito);
                Bienvenida6DatosNatural2Activity.rvDistrito.setVisibility(View.GONE);
            }
            if (activity instanceof Vender3Activity) {
                Vender3Activity.tvDistrito.setText(nombreDistrito);
                Vender3Activity.rvDistrito.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return distritos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView  tvNombreDistrito;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreDistrito = (TextView) itemView.findViewById(R.id.tvNombreDepartamento);
        }
    }
}

