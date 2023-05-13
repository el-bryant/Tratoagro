package empre.hoy.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class OpcionesRespuestaActivity extends AppCompatActivity {
    Button btnCorreo, btnLlamar, btnMensaje;
    ImageView ivFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_respuesta);
        btnCorreo = (Button) findViewById(R.id.btnCorreo);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnMensaje = (Button) findViewById(R.id.btnMensaje);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        Picasso.get().load("https://tratoagro.com/tratoagro/fondos/machu_picchu.jpg").into(ivFondo);
        btnCorreo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
            startActivity(Intent.createChooser(intent, "Send Email"));
        });
        btnLlamar.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT < 23) {
                phoneCall();
            } else {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    phoneCall();
                } else {
                    final String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 9);
                }
            }
        });
        btnMensaje.setOnClickListener(v -> {

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean permissionGranted = false;
        if (requestCode == 9) {
            permissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        }
        if (permissionGranted) {
            phoneCall();
        } else {
            Toast.makeText(this, "No se asignó el permiso", Toast.LENGTH_SHORT).show();
        }
    }

    private void phoneCall() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:+51" + "936794594"));
            startActivity(callIntent);
        } else {
            Toast.makeText(this, "No asignaste el permiso", Toast.LENGTH_SHORT).show();
        }
    }
}