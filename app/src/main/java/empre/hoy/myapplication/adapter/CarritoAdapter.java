package empre.hoy.myapplication.adapter;

import static empre.hoy.myapplication.Comprar1Activity.itemsCarrito;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import empre.hoy.myapplication.Funciones.BorderedCircleTransform;
import empre.hoy.myapplication.R;
import empre.hoy.myapplication.entity.ItemCarrito;

public class CarritoAdapter  extends RecyclerView.Adapter<CarritoAdapter.viewHolder> {
    Activity activity;
    ArrayList<ItemCarrito> itemCarritos;

    public CarritoAdapter(Activity activity, ArrayList<ItemCarrito> itemCarritos) {
        this.activity = activity;
        this.itemCarritos = itemCarritos;
    }

    @NonNull
    @Override
    public CarritoAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_carrito_2, parent, false);
        return new CarritoAdapter.viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoAdapter.viewHolder holder, int position) {
        ItemCarrito itemCarrito = itemsCarrito.get(position);
        String idProveedor = itemCarrito.getIdProducto();
        String nombreProducto = itemCarrito.getNombreProducto();
        String nombreProveedor = itemCarrito.getNombreProveedor();
        String imagen = itemCarrito.getFoto();
        if (imagen.equals("-") || imagen.equals("")) {
            imagen = "https://previews.123rf.com/images/alexwhite/alexwhite1609/alexwhite160908312/63119672-nuevo-producto-rojo-cuadrado-moderno-icono-del-dise%C3%B1o.jpg";
        }
        Picasso.get().load(imagen).transform(new BorderedCircleTransform(5, Color.rgb(255, 255, 255))).into(holder.ivFotoProducto);
        holder.tvNombreProducto.setText(nombreProducto);
        holder.tvNombreProveedor.setText(nombreProveedor);
        holder.tvCantidad.setText(String.format("%02d", itemCarrito.getCantidad()));
    }

    @Override
    public int getItemCount() {
        return itemsCarrito.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ivFotoProducto;
        TextView tvCantidad;
        TextView tvNombreProducto;
        TextView tvNombreProveedor;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoProducto = (ImageView) itemView.findViewById(R.id.ivFotoProducto);
            tvCantidad = (TextView) itemView.findViewById(R.id.tvCantidad);
            tvNombreProducto = (TextView) itemView.findViewById(R.id.tvNombreProveedor);
            tvNombreProveedor = (TextView) itemView.findViewById(R.id.tvPrecio);
        }
    }
}