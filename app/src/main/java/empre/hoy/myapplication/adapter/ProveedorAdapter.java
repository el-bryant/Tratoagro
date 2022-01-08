package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.Producto;

public class ProveedorAdapter extends RecyclerView.Adapter<ProveedorAdapter.viewHolder> {
    Activity activity;
    ArrayList<Producto> productos;

    public ProveedorAdapter(Activity activity, ArrayList<Producto> productos) {
        this.activity = activity;
        this.productos = productos;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_producto, parent, false);
        return new ProveedorAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Producto producto = productos.get(position);
        String idProducto = producto.getIdProducto();
        String nombre = producto.getNombre();
        String descripcion = producto.getDescripcion();
        double precio = producto.getPrecio();
        String imagen = producto.getImagen();
        Picasso.get().load(imagen).into(holder.ivFotoProducto);
        holder.tvNombreProducto.setText(nombre);
        holder.tvDescripcionProducto.setText(descripcion);
        holder.tvPrecio.setText("S/ " + String.format("%.2f", precio));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ivFotoProducto;
        TextView tvNombreProducto;
        TextView tvDescripcionProducto;
        TextView tvPrecio;
        Button btnComprar;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoProducto = (ImageView) itemView.findViewById(R.id.ivFotoProducto);
            tvNombreProducto = (TextView) itemView.findViewById(R.id.tvNombreProveedor);
            tvDescripcionProducto = (TextView) itemView.findViewById(R.id.tvDescripcionProducto);
            tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
            btnComprar = (Button) itemView.findViewById(R.id.btnComprar);
        }
    }
}
