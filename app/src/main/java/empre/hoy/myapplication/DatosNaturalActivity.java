package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.databinding.ActivityDatosNaturalBinding;

public class DatosNaturalActivity extends AppCompatActivity {
    public static ActivityDatosNaturalBinding binding;
    Map<String, String> params;
    PrefUtil prefUtil;
    public static String dni;
    WebService webService;
    double latitud = 0.0, longitud = 0.0;
    String direccion;
    static String comprarVender;
    boolean ubicacionObtenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatosNaturalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefUtil = new PrefUtil(this);
        webService = new WebService(this);
        comprarVender = getIntent().getStringExtra("comprar_vender");
        binding.tietDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.tietDni.getText().length() == 8) {
//                    obtenerDatosDni();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        binding.btnaceptar.setOnClickListener(v -> {
            prefUtil.saveGenericValue("nombres", binding.tietNombres.getText().toString());
            params = new HashMap<>();
            dni = binding.tietDni.getText().toString();
            params.put("dni", binding.tietDni.getText().toString());
            params.put("nombres", binding.tietNombres.getText().toString());
            params.put("apellidos", binding.tietApellidos.getText().toString());
            params.put("celular", binding.tietCelular.getText().toString());
            params.put("correo", binding.tietCorreo.getText().toString());
            params.put("direccion", binding.tietUbicacion.getText().toString());
            params.put("comprar_vender", comprarVender);
            webService.consulta(params, "registro_natural.php");
        });
        ubicacionObtenida = false;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            locationStart();
        }
    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
        direccion = "";
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }

    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    direccion = DirCalle.getAddressLine(0);
                    binding.tietUbicacion.setText(direccion);
                    ubicacionObtenida = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Localizacion implements LocationListener {
        DatosNaturalActivity mainActivity;
        public DatosNaturalActivity getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(DatosNaturalActivity mainActivity) {
            this.mainActivity = mainActivity;
        }
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            latitud = loc.getLatitude();
            longitud = loc.getLongitude();
            if (!ubicacionObtenida) {
                this.mainActivity.setLocation(loc);
            }
        }
        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            Toast.makeText(DatosNaturalActivity.this, "GPS Desactivado", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }

    public void obtenerDatosDni() {
        params = new HashMap<>();
        params.put("dni", binding.tietDni.getText().toString());
        webService.consulta(params, "consulta_dni.php");
    }

    public static void cargarDatosDni(String apellidos, String nombres) {
        binding.tietApellidos.setText(apellidos);
        binding.tietNombres.setText(nombres);
    }

    public static void registrado(Activity activity) {
        Intent intent = new Intent(activity, DatosNatural2Activity.class);
        intent.putExtra("dni", dni);
        intent.putExtra("comprar_vender", comprarVender);
        activity.startActivity(intent);
        activity.finish();
    }
}