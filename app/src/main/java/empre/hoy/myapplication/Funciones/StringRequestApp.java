package empre.hoy.myapplication.Funciones;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class StringRequestApp extends StringRequest {
    private Map parametros;
    public StringRequestApp(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public StringRequestApp(String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    public Map<String, String> getParametros() {
        Map<String, String> parans = parametros;
        return parans;
    }

    public void setParametros(Map parametros) {
        this.parametros = parametros;
    }
}
