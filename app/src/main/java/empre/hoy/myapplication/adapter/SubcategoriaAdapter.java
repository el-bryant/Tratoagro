package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Bienvenida810EmpezarTutorial25Info2PescaActivity;
import empre.hoy.myapplication.Bienvenida812EmpezarTutorial26Info2PesticidasActivity;
import empre.hoy.myapplication.Bienvenida82EmpezarTutorial21Info2FertilizantesActivity;
import empre.hoy.myapplication.Bienvenida84EmpezarTutorial22Info2GanaderiaActivity;
import empre.hoy.myapplication.Bienvenida86EmpezarTutorial23Info2InsumosActivity;
import empre.hoy.myapplication.Bienvenida88mpezarTutorial24Info2MaquinariaActivity;
import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.EstadisticasGeneralActivity;
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
        holder.tvNombreCategoria.setText(nombreCategoria);
        holder.tvNombreCategoria.setOnClickListener(v -> {
            if (activity instanceof Bienvenida82EmpezarTutorial21Info2FertilizantesActivity) {
                Bienvenida82EmpezarTutorial21Info2FertilizantesActivity.rvSubcategoriasFertilizantes.setVisibility(View.GONE);
                Bienvenida82EmpezarTutorial21Info2FertilizantesActivity.tvSubcategoria.setText(nombreCategoria);
                Bienvenida82EmpezarTutorial21Info2FertilizantesActivity.tvSubcategoria.setVisibility(View.VISIBLE);
            }
            if (activity instanceof Bienvenida84EmpezarTutorial22Info2GanaderiaActivity) {
                Bienvenida84EmpezarTutorial22Info2GanaderiaActivity.rvSubcategoriasGanaderia.setVisibility(View.GONE);
                Bienvenida84EmpezarTutorial22Info2GanaderiaActivity.tvSubcategoria.setText(nombreCategoria);
                Bienvenida84EmpezarTutorial22Info2GanaderiaActivity.tvSubcategoria.setVisibility(View.VISIBLE);
            }
            if (activity instanceof Bienvenida86EmpezarTutorial23Info2InsumosActivity) {
                Bienvenida86EmpezarTutorial23Info2InsumosActivity.rvSubcategoriasInsumos.setVisibility(View.GONE);
                Bienvenida86EmpezarTutorial23Info2InsumosActivity.tvSubcategoria.setText(nombreCategoria);
                Bienvenida86EmpezarTutorial23Info2InsumosActivity.tvSubcategoria.setVisibility(View.VISIBLE);
            }
            if (activity instanceof Bienvenida88mpezarTutorial24Info2MaquinariaActivity) {
                Bienvenida88mpezarTutorial24Info2MaquinariaActivity.rvSubcategoriasMaquinaria.setVisibility(View.GONE);
                Bienvenida88mpezarTutorial24Info2MaquinariaActivity.tvSubcategoria.setText(nombreCategoria);
                Bienvenida88mpezarTutorial24Info2MaquinariaActivity.tvSubcategoria.setVisibility(View.VISIBLE);
            }
            if (activity instanceof Bienvenida810EmpezarTutorial25Info2PescaActivity) {
                Bienvenida810EmpezarTutorial25Info2PescaActivity.rvSubcategoriasPesca.setVisibility(View.GONE);
                Bienvenida810EmpezarTutorial25Info2PescaActivity.tvSubcategoria.setText(nombreCategoria);
                Bienvenida810EmpezarTutorial25Info2PescaActivity.tvSubcategoria.setVisibility(View.VISIBLE);
            }
            if (activity instanceof Bienvenida812EmpezarTutorial26Info2PesticidasActivity) {
                Bienvenida812EmpezarTutorial26Info2PesticidasActivity.rvSubcategoriasPesticidas.setVisibility(View.GONE);
                Bienvenida812EmpezarTutorial26Info2PesticidasActivity.tvSubcategoria.setText(nombreCategoria);
                Bienvenida812EmpezarTutorial26Info2PesticidasActivity.tvSubcategoria.setVisibility(View.VISIBLE);
            }
            if (activity instanceof Comprar2Activity) {
                Comprar2Activity.rvSubcategoria.setVisibility(View.GONE);
                Comprar2Activity.tvSubcategoria.setText(nombreCategoria);
            }
            if (activity instanceof EstadisticasGeneralActivity) {
                EstadisticasGeneralActivity.rvSubcategoria.setVisibility(View.GONE);
                EstadisticasGeneralActivity.tvSubcategoria.setText(nombreCategoria);
            }
            cargar(idSubcategoria);
        });
    }

    public void cargar(String idSubcategoria) {
        webService = new WebService(activity);
        params = new HashMap<>();
        params.put("subcategoria", idSubcategoria);
        webService.consulta(params, "obtener_productos_subcategoria.php");
    }

    @Override
    public int getItemCount() {
        return subcategorias.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreCategoria;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCategoria = (TextView) itemView.findViewById(R.id.tvNombreCategoria);
        }
    }
}
