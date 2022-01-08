package empre.hoy.myapplication.adapter;

import static empre.hoy.myapplication.ListaProveedoresActivity.nombreProducto;
import static empre.hoy.myapplication.PerfilCategoriasCompra.itemsCarrito;
import static empre.hoy.myapplication.ListaProveedoresActivity.idProducto;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.ItemCarrito;
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
        String idProveedor = producto.getIdProducto();
        String nombre = producto.getNombre();
        double precio = producto.getPrecio();
        String imagen = producto.getImagen();
        if (imagen.equals("-") || imagen.equals("")) {
            imagen = "https://previews.123rf.com/images/alexwhite/alexwhite1609/alexwhite160908312/63119672-nuevo-producto-rojo-cuadrado-moderno-icono-del-dise%C3%B1o.jpg";
        }
        Picasso.get().load(imagen).into(holder.ivFotoProducto);
        holder.tvNombreProducto.setText(nombre);
        holder.tvPrecio.setText("S/ " + String.format("%.2f", precio));
        String finalImagen = imagen;
        holder.ivMas.setOnClickListener(v -> {
            aumentar(holder.tvCantidad);
            if (itemsCarrito.size() < 1) {
                ItemCarrito itemCarrito = new ItemCarrito();
                itemCarrito.setIdProducto(idProducto);
                itemCarrito.setCantidad(1);
                itemCarrito.setIdProveedor(idProveedor);
                itemCarrito.setFoto(finalImagen);
                itemCarrito.setNombreProveedor(nombre);
                itemCarrito.setNombreProducto(nombreProducto);
            }
        });
        holder.ivMenos.setOnClickListener(v -> {
            if (Integer.parseInt(holder.tvCantidad.getText().toString()) > 0) {
                reducir(holder.tvCantidad);
            }
        });
    }

    public void aumentar(TextView tvCantidad) {
        int cantidad = Integer.parseInt(tvCantidad.getText().toString()) + 1;
        tvCantidad.setText(String.format("%02d", cantidad));
    }

    public void reducir(TextView tvCantidad) {
        int cantidad = Integer.parseInt(tvCantidad.getText().toString()) - 1;
        tvCantidad.setText(String.format("%02d", cantidad));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ivFotoProducto;
        ImageView ivMas;
        ImageView ivMenos;
        TextView tvCantidad;
        TextView tvNombreProducto;
        TextView tvPrecio;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoProducto = (ImageView) itemView.findViewById(R.id.ivFotoProducto);
            ivMas = (ImageView) itemView.findViewById(R.id.ivMas);
            ivMenos = (ImageView) itemView.findViewById(R.id.ivMenos);
            tvCantidad = (TextView) itemView.findViewById(R.id.tvCantidad);
            tvNombreProducto = (TextView) itemView.findViewById(R.id.tvNombreProveedor);
            tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        }
    }
}
