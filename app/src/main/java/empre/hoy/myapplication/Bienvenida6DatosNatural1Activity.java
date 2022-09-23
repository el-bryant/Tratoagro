package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

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
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import empre.hoy.myapplication.Funciones.PrefUtil;
import empre.hoy.myapplication.Funciones.WebService;

public class Bienvenida6DatosNatural1Activity extends AppCompatActivity {
    boolean ubicacionObtenida;
    Button btnSiguiente;
    double latitud = 0.0, longitud = 0.0;
    ImageView ivFondo;
    Map<String, String> params;
    PrefUtil prefUtil;
    public static EditText etDni, etApellidos, etNombres, etUbicacion;
    public static String dni;
    String direccion;
    WebService webService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_6_datos_natural_1);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etDni = (EditText) findViewById(R.id.etDni);
        etNombres = (EditText) findViewById(R.id.etNombres);
        etUbicacion = (EditText) findViewById(R.id.etUbicacion);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load(fondoGeneral).into(ivFondo);
        btnSiguiente.setOnClickListener(v -> {
            startActivity(new Intent(Bienvenida6DatosNatural1Activity.this, Bienvenida6DatosNatural2Activity.class));
            finish();
        });
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
                    etUbicacion.setText(direccion);
                    ubicacionObtenida = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Localizacion implements LocationListener {
        Bienvenida6DatosNatural1Activity mainActivity;
        public Bienvenida6DatosNatural1Activity getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(Bienvenida6DatosNatural1Activity mainActivity) {
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
            Toast.makeText(Bienvenida6DatosNatural1Activity.this, "GPS Desactivado", Toast.LENGTH_LONG).show();
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
        params.put("dni", etDni.getText().toString());
        webService.consulta(params, "consulta_dni.php");
    }

    public static void cargarDatosDni(String apellidos, String nombres) {
        etApellidos.setText(apellidos);
        etNombres.setText(nombres);
    }

    public static void registrado(Activity activity) {
        Intent intent = new Intent(activity, DatosNatural2Activity.class);
        intent.putExtra("dni", dni);
        activity.startActivity(intent);
        activity.finish();
    }
}
