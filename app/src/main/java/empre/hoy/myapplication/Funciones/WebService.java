package empre.hoy.myapplication.Funciones;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Map;

import empre.hoy.myapplication.CarritoActivity;
import empre.hoy.myapplication.Comprar2Activity;
import empre.hoy.myapplication.DatosJuridico2Activity;
import empre.hoy.myapplication.DatosJuridicoActivity;
import empre.hoy.myapplication.DatosNatural2Activity;
import empre.hoy.myapplication.DatosNatural1Activity;
import empre.hoy.myapplication.EstadiFertilizantesActivity;
import empre.hoy.myapplication.EstadiGanaderiaActivity;
import empre.hoy.myapplication.EstadiInsumosActivity;
import empre.hoy.myapplication.EstadiMaquinariaActivity;
import empre.hoy.myapplication.EstadiPescaActivity;
import empre.hoy.myapplication.EstadiPesticidasActivity;
import empre.hoy.myapplication.IniciarSesionActivity;
import empre.hoy.myapplication.Inicio2Activity;
import empre.hoy.myapplication.ListaProveedoresActivity;
import empre.hoy.myapplication.Comprar1Activity;
import empre.hoy.myapplication.PerfilVentaProductosActivity;
import empre.hoy.myapplication.TutoFertilzantes;
import empre.hoy.myapplication.TutoGanaderia;
import empre.hoy.myapplication.TutoInsumos;
import empre.hoy.myapplication.TutoMaquinaria;
import empre.hoy.myapplication.TutoPesca;
import empre.hoy.myapplication.TutoPesticidas;
import empre.hoy.myapplication.adapter.CategoriaAdapter;
import empre.hoy.myapplication.adapter.DepartamentoAdapter;
import empre.hoy.myapplication.adapter.DistritoAdapter;
import empre.hoy.myapplication.adapter.ProductoAdapter;
import empre.hoy.myapplication.adapter.ProveedorAdapter;
import empre.hoy.myapplication.adapter.ProvinciaAdapter;
import empre.hoy.myapplication.adapter.SubcategoriaAdapter;
import empre.hoy.myapplication.entity.Categoria;
import empre.hoy.myapplication.entity.Producto;
import empre.hoy.myapplication.entity.Subcategoria;
import empre.hoy.myapplication.entity.VentasReporte;

public class WebService implements Response.Listener, Response.ErrorListener {
    private Activity activity;
    private Fragment fragment;
    private RequestQueue requestQueue;
    ArrayList<Categoria> categorias;
    ArrayList<Subcategoria> subcategorias;
    ArrayList<Producto> productos;
    ArrayList<VentasReporte> ventas;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PrefUtil prefUtil;
    String accion;
    String consulta;
    boolean correcto;
    public static String url = "https://tratoagro.com/tratoagro/ws/";

    public WebService(Activity activity) {
        this. activity = activity;
        requestQueue = Volley. newRequestQueue(activity);
        prefUtil = new PrefUtil(activity);
    }

    public WebService(Fragment fragment) {
        this. fragment = fragment;
        activity = fragment.getActivity();
        if (activity !=null) {
            requestQueue = Volley.newRequestQueue(activity);
            prefUtil = new PrefUtil(activity);
        }
    }

    public void consulta(Map<String, String> params, String nombreArchivo) {
        StringRequestApp stringRequestApp = new StringRequestApp(Request.Method.POST, url + nombreArchivo,  this,  this);
        stringRequestApp.setParametros(params);
        stringRequestApp.setRetryPolicy(new DefaultRetryPolicy(    15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        requestQueue.add(stringRequestApp);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String message = "";
        if (error instanceof NetworkError) {
            message = "No se puede conectar a Internet. Por favor, ¡compruebe su conexión!";
        } else if (error instanceof ServerError) {
            message = "No se pudo encontrar el servidor. ¡Inténtalo nuevamente dentro de unos minutos!" + error.getMessage();
        } else if (error instanceof AuthFailureError) {
            message = "No se puede conectar a Internet. Por favor, ¡compruebe su conexión!";
        } else if (error instanceof ParseError) {
            message = "¡Error! ¡Inténtalo nuevamente dentro de unos minutos!";
        } else if (error instanceof TimeoutError) {
            message = "¡El tiempo de conexión expiró! Por favor revise su conexión a Internet.";
        } else {
            message = "¡Error en obtención de datos! " + error.getMessage();
        }
        Log.i("onErrorResponse", message);
        error.printStackTrace();
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(Object response) {
        Log.i( "onResponse", response.toString());
        try {
            jsonObject = new JSONObject(response.toString());
            accion = jsonObject.getString("accion");
            consulta = jsonObject.getString("consulta");
            correcto = jsonObject.getBoolean("correcto");
            switch (accion) {
                case "obtener_categorias_fertilizantes":
                    if (correcto) {
                        categorias = new ArrayList<>();
                        jsonArray=jsonObject. getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++ ) {
                            Categoria categoria = new Categoria();
                            String id= jsonArray.getJSONObject(i). getString("id_categoria");
                            String nombre= jsonArray.getJSONObject(i). getString("nombre");
                            String icono= jsonArray.getJSONObject(i). getString("icono");
                            categoria.setIdCategoria(id);
                            categoria.setNombre(nombre);
                            categoria.setIcono(icono);
                            categorias.add(categoria);
                        }
                        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(activity, categorias);
                        TutoFertilzantes.mostrarCategorias(categoriaAdapter);
                    }
                    break;
                case "obtener_categorias_ganaderia":
                    if (correcto) {
                        categorias = new ArrayList<>();
                        jsonArray=jsonObject. getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++ ) {
                            Categoria categoria = new Categoria();
                            String id= jsonArray.getJSONObject(i). getString("id_categoria");
                            String nombre= jsonArray.getJSONObject(i). getString("nombre");
                            String icono= jsonArray.getJSONObject(i). getString("icono");
                            categoria.setIdCategoria(id);
                            categoria.setNombre(nombre);
                            categoria.setIcono(icono);
                            categorias.add(categoria);
                        }
                        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(activity, categorias);
                        TutoGanaderia.mostrarCategorias(categoriaAdapter);
                    }
                    break;
                case "obtener_categorias_insumos":
                    if (correcto) {
                        categorias = new ArrayList<>();
                        jsonArray=jsonObject. getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++ ) {
                            Categoria categoria = new Categoria();
                            String id= jsonArray.getJSONObject(i). getString("id_categoria");
                            String nombre= jsonArray.getJSONObject(i). getString("nombre");
                            String icono= jsonArray.getJSONObject(i). getString("icono");
                            categoria.setIdCategoria(id);
                            categoria.setNombre(nombre);
                            categoria.setIcono(icono);
                            categorias.add(categoria);
                        }
                        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(activity, categorias);
                        TutoInsumos.mostrarCategorias(categoriaAdapter);
                    }
                    break;
                case "obtener_categorias_maquinaria":
                    if (correcto) {
                        categorias = new ArrayList<>();
                        jsonArray=jsonObject. getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++ ) {
                            Categoria categoria = new Categoria();
                            String id= jsonArray.getJSONObject(i). getString("id_categoria");
                            String nombre= jsonArray.getJSONObject(i). getString("nombre");
                            String icono= jsonArray.getJSONObject(i). getString("icono");
                            categoria.setIdCategoria(id);
                            categoria.setNombre(nombre);
                            categoria.setIcono(icono);
                            categorias.add(categoria);
                        }
                        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(activity, categorias);
                        TutoMaquinaria.mostrarCategorias(categoriaAdapter);
                    }
                    break;
                case "obtener_categorias_pesca":
                    if (correcto) {
                        categorias = new ArrayList<>();
                        jsonArray=jsonObject. getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++ ) {
                            Categoria categoria = new Categoria();
                            String id= jsonArray.getJSONObject(i). getString("id_categoria");
                            String nombre= jsonArray.getJSONObject(i). getString("nombre");
                            String icono= jsonArray.getJSONObject(i). getString("icono");
                            categoria.setIdCategoria(id);
                            categoria.setNombre(nombre);
                            categoria.setIcono(icono);
                            categorias.add(categoria);
                        }
                        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(activity, categorias);
                        TutoPesca.mostrarCategorias(categoriaAdapter);
                    }
                    break;
                case "obtener_categorias_pesticidas":
                    if (correcto) {
                        categorias = new ArrayList<>();
                        jsonArray=jsonObject. getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++ ) {
                            Categoria categoria = new Categoria();
                            String id= jsonArray.getJSONObject(i). getString("id_categoria");
                            String nombre= jsonArray.getJSONObject(i). getString("nombre");
                            String icono= jsonArray.getJSONObject(i). getString("icono");
                            categoria.setIdCategoria(id);
                            categoria.setNombre(nombre);
                            categoria.setIcono(icono);
                            categorias.add(categoria);
                        }
                        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(activity, categorias);
                        TutoPesticidas.mostrarCategorias(categoriaAdapter);
                    }
                    break;
                case "registro_usuario":
                    if (correcto) {
                        DatosNatural2Activity.obtenerIdUsuario();
                    }
                    break;
                case "registro_usuario_juridico":
                    if (correcto) {
                        DatosJuridico2Activity.obtenerIdUsuario();
                    }
                    break;
                case "obtener_cantidad_ventas_fertilizantes":
                    if (correcto) {
                        Log.i("obtener_ventas_fertiliz", consulta);
                        ventas = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.getJSONObject(i).getString("id_categoria").equals("5")) {
                                VentasReporte venta = new VentasReporte();
                                venta.setCantidad(jsonArray.getJSONObject(i).getInt("cant"));
                                ventas.add(venta);
                            }
                        }
                        EstadiFertilizantesActivity.obtenerVentas(ventas);
                    }
                    break;
                case "obtener_cantidad_ventas_ganaderia":
                    if (correcto) {
                        Log.i("obtener_ventas_ganaderi", consulta);
                        ventas = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.getJSONObject(i).getString("id_categoria").equals("1")) {
                                VentasReporte venta = new VentasReporte();
                                venta.setCantidad(jsonArray.getJSONObject(i).getInt("cant"));
                                ventas.add(venta);
                            }
                        }
                        EstadiGanaderiaActivity.obtenerVentas(ventas);
                    }
                    break;
                case "obtener_cantidad_ventas_insumos":
                    if (correcto) {
                        Log.i("obtener_ventas_insumos", consulta);
                        ventas = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.getJSONObject(i).getString("id_categoria").equals("3")) {
                                VentasReporte venta = new VentasReporte();
                                venta.setCantidad(jsonArray.getJSONObject(i).getInt("cant"));
                                ventas.add(venta);
                            }
                        }
                        EstadiInsumosActivity.obtenerVentas(ventas);
                    }
                    break;
                case "obtener_cantidad_ventas_maquinaria":
                    if (correcto) {
                        Log.i("obtener_ventas_maquinar", consulta);
                        ventas = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.getJSONObject(i).getString("id_categoria").equals("2")) {
                                VentasReporte venta = new VentasReporte();
                                venta.setCantidad(jsonArray.getJSONObject(i).getInt("cant"));
                                ventas.add(venta);
                            }
                        }
                        EstadiMaquinariaActivity.obtenerVentas(ventas);
                    }
                    break;
                case "obtener_cantidad_ventas_pesca":
                    if (correcto) {
                        Log.i("obtener_ventas_pesca", consulta);
                        ventas = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.getJSONObject(i).getString("id_categoria").equals("6")) {
                                VentasReporte venta = new VentasReporte();
                                venta.setCantidad(jsonArray.getJSONObject(i).getInt("cant"));
                                ventas.add(venta);
                            }
                        }
                        EstadiPescaActivity.obtenerVentas(ventas);
                    }
                    break;
                case "obtener_cantidad_ventas_pesticidas":
                    if (correcto) {
                        Log.i("obtener_ventas_pesticid", consulta);
                        ventas = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.getJSONObject(i).getString("id_categoria").equals("4")) {
                                VentasReporte venta = new VentasReporte();
                                venta.setCantidad(jsonArray.getJSONObject(i).getInt("cant"));
                                ventas.add(venta);
                            }
                        }
                        EstadiPesticidasActivity.obtenerVentas(ventas);
                    }
                    break;
                case "registro_natural":
                    if (correcto) {
                        Log.i("registro_natural", consulta);
                        DatosNatural1Activity.registrado(activity);
                    }
                    break;
                case "registro_juridico":
                    if (correcto) {
                        Log.i("registro_juridico", consulta);
                        DatosJuridicoActivity.registrado(activity);
                    }
                    break;
                case "obtener_id_usuario":
                    if (correcto) {
                        Log.i("obtener_id_usuario", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        if (jsonArray.length() > 0) {
                            String idUsuario = jsonArray.getJSONObject(0).getString("id_usuario");
                            DatosNatural2Activity.enlazar(idUsuario);
                        }
                    }
                    break;
                case "obtener_id_usuario_juridico":
                    if (correcto) {
                        Log.i("obtener_id_usuario", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        if (jsonArray.length() > 0) {
                            String idUsuario = jsonArray.getJSONObject(0).getString("id_usuario");
                            DatosJuridico2Activity.enlazar(idUsuario);
                        }
                    }
                    break;
                case "enlazar_natural_usuario":
                    if (correcto) {
                        Log.i("enlazar_natural_usuario", "OK");
                        Intent intent = new Intent(activity, IniciarSesionActivity.class);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                    break;
                case "enlazar_juridico_usuario":
                    if (correcto) {
                        Log.i("enlazar_juridico_usu", "OK");
                        Intent intent = new Intent(activity, IniciarSesionActivity.class);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                    break;
                case "obtener_subcategorias":
                    if (correcto) {
                        Log.i("obtener_subcategorias", consulta);
                        subcategorias = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i ++) {
                            String idSubcategoria = jsonArray.getJSONObject(i).getString("id_subcategoria");
                            String nombre = jsonArray.getJSONObject(i).getString("nombre");
                            String idCategoria = jsonArray.getJSONObject(i).getString("id_categoria");
                            Subcategoria subcategoria = new Subcategoria();
                            subcategoria.setIdSubcategoria(idSubcategoria);
                            subcategoria.setNombre(nombre);
                            subcategoria.setIdCategoria(idCategoria);
                            subcategorias.add(subcategoria);
                        }
                        SubcategoriaAdapter subcategoriaAdapter = new SubcategoriaAdapter(activity, subcategorias);
//                        PerfilVentaProductosActivity.cargarSubcategorias(subcategoriaAdapter);
                    }
                    break;
                case "obtener_productos_subcategoria":
                    if (correcto) {
                        Log.i("obtener_productos_sub", consulta);
                        productos = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i ++) {
                            String idProducto = jsonArray.getJSONObject(i).getString("id_producto");
                            String nombre = jsonArray.getJSONObject(i).getString("nombre");
                            Producto producto = new Producto();
                            producto.setIdProducto(idProducto);
                            producto.setNombre(nombre);
                            productos.add(producto);
                        }
                        ProductoAdapter productoAdapter = new ProductoAdapter(activity, productos);
//                        PerfilVentaProductosActivity.cargarProductos(productoAdapter);
                    }
                    break;
                case "obtener_proveedores_producto":
                    if (correcto) {
                        Log.i("obtener_proveedores_pro", consulta);
                        productos = new ArrayList<>();
                        jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i ++) {
                            String idStock = jsonArray.getJSONObject(i).getString("id_stock");
                            String imagen = jsonArray.getJSONObject(i).getString("imagen");
                            String nombreProveedor = jsonArray.getJSONObject(i).getString("nombre");
                            Double precio = jsonArray.getJSONObject(i).getDouble("precio");
                            Producto producto = new Producto();
                            producto.setIdProducto(idStock);
                            producto.setImagen(imagen);
                            producto.setNombre(nombreProveedor);
                            producto.setPrecio(precio);
                            productos.add(producto);
                        }
                        ProveedorAdapter proveedorAdapter = new ProveedorAdapter(activity, productos);
                        ListaProveedoresActivity.cargarProveedores(proveedorAdapter);
                    }
                    break;
                case "iniciar_sesion":
                    if (correcto) {
                        Log.i("iniciar_sesion", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        if (jsonArray.length() > 0) {
                            String idUsuario = jsonArray.getJSONObject(0).getString("id_usuario");
                            String estado = jsonArray.getJSONObject(0).getString("estado");
                            String nombre = jsonArray.getJSONObject(0).getString("nombre");
                            if (estado.equals("D")) {
                                prefUtil.saveGenericValue("id_usuario", idUsuario);
                                prefUtil.saveGenericValue(PrefUtil.LOGIN_STATUS, "1");
                                prefUtil.saveGenericValue("nombre", nombre);
                                activity.startActivity(new Intent(activity, Inicio2Activity.class));
                                activity.finish();
                            } else {
                                Toast.makeText(activity, "Su cuenta ha sido suspendida, comuníquese con nosotros para recuperarla", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(activity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "registrar_venta":
                    if (correcto) {
                        Log.i("registrar_venta", consulta);
                        CarritoActivity.obtenerIdVenta();
                    }
                    break;
                case "obtener_id_venta":
                    if (correcto) {
                        Log.i("obtener_id_venta", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        if (jsonArray.length() > 0) {
                            String idVenta = jsonArray.getJSONObject(0).getString("id_venta");
                            CarritoActivity.llenarDetalles(idVenta);
                            activity.startActivity(new Intent(activity, Comprar1Activity.class));
                            Toast.makeText(activity, "Venta registrada satisfactoriamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case "insertar_detalles_venta":
                    if (correcto) {
                        Log.i("insertar_detalle_venta", consulta);
                    }
                    break;
                case "buscar_dni":
                    Log.i("buscar_dni", consulta);
                    String apellidos = jsonObject.getString("apellido_paterno") + " " + jsonObject.getString("apellido_materno");
                    String nombres = jsonObject.getString("nombres");
                    DatosNatural1Activity.cargarDatosDni(apellidos, nombres);
                    break;
                case "buscar_departamentos":
                    if (correcto) {
                        Log.i("buscar_departamentos", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        categorias = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Categoria categoria = new Categoria();
                            categoria.setIdCategoria(jsonArray.getJSONObject(i).getString("id_departamento"));
                            categoria.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                            categorias.add(categoria);
                        }
                        DepartamentoAdapter departamentoAdapter = new DepartamentoAdapter(activity, categorias);
                        Comprar2Activity.cargarDepartamentos(departamentoAdapter);
                    }
                    break;
                case "buscar_provincias":
                    if (correcto) {
                        Log.i("buscar_provincias", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        categorias = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Categoria categoria = new Categoria();
                            categoria.setIdCategoria(jsonArray.getJSONObject(i).getString("id_provincia"));
                            categoria.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                            categorias.add(categoria);
                        }
                        ProvinciaAdapter provinciaAdapter = new ProvinciaAdapter(activity, categorias);
                        Comprar2Activity.cargarProvincias(provinciaAdapter);
                    }
                    break;
                case "buscar_distritos":
                    if (correcto) {
                        Log.i("buscar_distritos", consulta);
                        jsonArray = jsonObject.getJSONArray("data");
                        categorias = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Categoria categoria = new Categoria();
                            categoria.setIdCategoria(jsonArray.getJSONObject(i).getString("id_distrito"));
                            categoria.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                            categorias.add(categoria);
                        }
                    }
                    DistritoAdapter distritoAdapter = new DistritoAdapter(activity, categorias);
                    Comprar2Activity.cargarDistritos(distritoAdapter);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
