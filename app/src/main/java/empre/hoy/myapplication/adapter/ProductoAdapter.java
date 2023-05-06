package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.EstadisticasGeneralActivity;
import empre.hoy.myapplication.ListaProveedoresActivity;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.Vender3Activity;
import empre.hoy.myapplication.entity.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.viewHolder> {
    Activity activity;
    ArrayList<Producto> productos;

    public ProductoAdapter(Activity activity, ArrayList<Producto> productos) {
        this.activity = activity;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_producto, parent, false);
        return new ProductoAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.viewHolder holder, int position) {
        Producto producto = productos.get(position);
        int idProducto = producto.getIdProducto();
        String nombre = producto.getNombre();
        holder.tvNombreProducto.setText(nombre);
        holder.tvNombreProducto.setOnClickListener(v -> {
            if (activity instanceof Comprar2Activity) {
                Comprar2Activity.tvProducto.setText(nombre);
                Comprar2Activity.rvProducto.setVisibility(View.GONE);
                Comprar2Activity.idProducto = idProducto;
            }
            if (activity instanceof EstadisticasGeneralActivity) {
                EstadisticasGeneralActivity.tvProducto.setText(nombre);
                EstadisticasGeneralActivity.rvProducto.setVisibility(View.GONE);
            }
            if (activity instanceof Vender3Activity) {
                Vender3Activity.tvProducto.setText(nombre);
                Vender3Activity.rvProducto.setVisibility(View.GONE);
            }
//                    activity.startActivity(new
//                Intent(activity, ListaProveedoresActivity.class)
//                .putExtra("idProducto", idProducto)
//                .putExtra("nombreProducto", nombre)
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreProducto;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProducto = (TextView) itemView.findViewById(R.id.tvNombreProducto);
        }
    }
}
