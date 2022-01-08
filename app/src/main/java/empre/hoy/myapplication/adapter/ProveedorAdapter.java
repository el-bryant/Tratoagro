package empre.hoy.myapplication.adapter;

import android.app.Activity;
import android.graphics.Color;
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

import empre.hoy.myapplication.Funciones.BorderedCircleTransform;
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
        View v = LayoutInflater.from(activity).inflate(R.layout.item_proveedor, parent, false);
        return new ProveedorAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Producto producto = productos.get(position);
        String idProducto = producto.getIdProducto();
        String nombre = producto.getNombre();
        double precio = producto.getPrecio();
        String imagen = producto.getImagen();
        if (imagen.equals("-") || imagen.equals("")) {
            Picasso.get()
                    .load("https://previews.123rf.com/images/alexwhite/alexwhite1609/alexwhite160908312/63119672-nuevo-producto-rojo-cuadrado-moderno-icono-del-dise%C3%B1o.jpg")
                    .transform(new BorderedCircleTransform(5, Color.rgb(255, 255, 255)))
                    .into(holder.ivFotoProducto);
        } else {
            Picasso.get().load(imagen).into(holder.ivFotoProducto);
        }
        holder.tvNombreProducto.setText(nombre);
        holder.tvPrecio.setText("S/ " + String.format("%.2f", precio));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ivFotoProducto;
        TextView tvNombreProducto;
        TextView tvPrecio;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoProducto = (ImageView) itemView.findViewById(R.id.ivFotoProducto);
            tvNombreProducto = (TextView) itemView.findViewById(R.id.tvNombreProveedor);
            tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        }
    }
}
