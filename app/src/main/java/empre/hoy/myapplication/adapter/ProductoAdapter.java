package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import empre.hoy.myapplication.ListaProveedoresActivity;
import empre.hoy.myapplication.R;
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
        String idProducto = producto.getIdProducto();
        String nombre = producto.getNombre();
        holder.btnProducto.setText(nombre);
        holder.btnProducto.setOnClickListener(v -> activity.startActivity(new
                Intent(activity, ListaProveedoresActivity.class).putExtra("idProducto", idProducto)));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        Button btnProducto;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            btnProducto = (Button) itemView.findViewById(R.id.btnNombreProducto);
        }
    }
}
