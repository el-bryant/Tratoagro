package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.databinding.ActivityDatosNaturalBinding;

public class DatosNaturalActivity extends AppCompatActivity {
    ActivityDatosNaturalBinding binding;
    Map<String, String> params;
    PrefUtil prefUtil;
    public static String dni;
    WebService webService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatosNaturalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefUtil = new PrefUtil(this);
        webService = new WebService(this);
        binding.btnaceptar.setOnClickListener(v -> {
            params = new HashMap<>();
            dni = binding.tietDni.getText().toString();
            params.put("dni", binding.tietDni.getText().toString());
            params.put("nombres", binding.tietNombres.getText().toString());
            params.put("apellidos", binding.tietApellidos.getText().toString());
            params.put("celular", binding.tietCelular.getText().toString());
            params.put("correo", binding.tietCorreo.getText().toString());
            params.put("direccion", binding.tietUbicacion.getText().toString());
            params.put("comprar_vender", prefUtil.getStringValue("comprar_vender"));
            webService.consulta(params, "registro_natural.php");
        });
    }

    public static void registrado(Activity activity) {
        Intent intent = new Intent(activity, DatosNatural2Activity.class);
        intent.putExtra("dni", dni);
        activity.startActivity(intent);
        activity.finish();
    }
}