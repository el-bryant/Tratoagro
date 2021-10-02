package empre.hoy.myapplication.Funciones;

import android.app.Activity;
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

import empre.hoy.myapplication.EstadiFertilizantesActivity;
import empre.hoy.myapplication.EstadiGanaderiaActivity;
import empre.hoy.myapplication.EstadiInsumosActivity;
import empre.hoy.myapplication.EstadiMaquinariaActivity;
import empre.hoy.myapplication.EstadiPescaActivity;
import empre.hoy.myapplication.EstadiPesticidasActivity;
import empre.hoy.myapplication.TutoFertilzantes;
import empre.hoy.myapplication.TutoGanaderia;
import empre.hoy.myapplication.TutoInsumos;
import empre.hoy.myapplication.TutoMaquinaria;
import empre.hoy.myapplication.TutoPesca;
import empre.hoy.myapplication.TutoPesticidas;
import empre.hoy.myapplication.adapter.CategoriaAdapter;
import empre.hoy.myapplication.entity.Categoria;
import empre.hoy.myapplication.entity.VentasReporte;

public class WebService implements Response.Listener, Response.ErrorListener {
    private Activity activity;
    private Fragment fragment;
    private RequestQueue requestQueue;
    ArrayList<Categoria> categorias;
    ArrayList<VentasReporte> ventas;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String accion;
    String consulta;
    boolean correcto;
    public static String url = "https://aplicacionesperu.com/tratoagro/ws/";

    public WebService(Activity activity) {
        this. activity = activity;
        requestQueue = Volley. newRequestQueue(activity);
    }

    public WebService(Fragment fragment) {
        this. fragment = fragment;
        activity = fragment.getActivity();
        if (activity !=null) {
            requestQueue=Volley.newRequestQueue(activity);
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
