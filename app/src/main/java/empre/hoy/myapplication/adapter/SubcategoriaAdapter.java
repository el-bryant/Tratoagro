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

import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.PerfilVentaProductosActivity;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Subcategoria;

public class SubcategoriaAdapter extends RecyclerView.Adapter<SubcategoriaAdapter.viewHolder> {
    Activity activity;
    ArrayList<Subcategoria> subcategorias;
    Map<String, String> params;
    WebService webService;

    public SubcategoriaAdapter(Activity activity, ArrayList<Subcategoria> subcategorias) {
        this.activity = activity;
        this.subcategorias = subcategorias;
    }

    @NonNull
    @Override
    public SubcategoriaAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_tutorial, parent, false);
        return new SubcategoriaAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SubcategoriaAdapter.viewHolder holder, int position) {
        Subcategoria subcategoria = subcategorias.get(position);
        String idSubcategoria = subcategoria.getIdSubcategoria();
        String nombreCategoria = subcategoria.getNombre();
        holder.tuvnombrecategoria.setText(nombreCategoria);
        holder.tuvnombrecategoria.setOnClickListener(v -> cargar(idSubcategoria));
    }

    public void cargar(String idSubcategoria) {
        if (activity instanceof PerfilVentaProductosActivity) {
            webService = new WebService(activity);
            params = new HashMap<>();
            params.put("subcategoria", idSubcategoria);
            webService.consulta(params, "obtener_productos_subcategoria.php");
        }
    }

    @Override
    public int getItemCount() {
        return subcategorias.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tuvnombrecategoria;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tuvnombrecategoria = (TextView) itemView.findViewById(R.id.tuvnombrecategoria);
        }
    }
}
