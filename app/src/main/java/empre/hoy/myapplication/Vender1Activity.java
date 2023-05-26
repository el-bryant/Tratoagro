package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import empre.hoy.myapplication.Funciones.BorderedCircleTransform;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.adapter.UnidadAdapter;

public class Vender1Activity extends AppCompatActivity {
    Button btnContinuar, btnPublicaciones;
    ImageView ivFondo, ivFoto;
    Map<String, String> params;
    public static RecyclerView rvUnidades;
    String contenidoImagen = "";
    public static TextView tvDolares, tvMoneda, tvSoles, tvUnidad;
    WebService webService;
    int PICK_PERFIL_REQUEST = 5675;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_1);
        webService = new WebService(this);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        btnPublicaciones = (Button) findViewById(R.id.btnPublicaciones);
        ivFondo = (ImageView) findViewById(R.id.ivFondo);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
        rvUnidades = (RecyclerView) findViewById(R.id.rvUnidades);
        tvDolares = (TextView) findViewById(R.id.tvDolares);
        tvMoneda = (TextView) findViewById(R.id.tvMoneda);
        tvSoles = (TextView) findViewById(R.id.tvSoles);
        tvUnidad = (TextView) findViewById(R.id.tvUnidad);
        rvUnidades.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get().load(fondoGeneral).into(ivFondo);
        obtenerUnidades();
        btnPublicaciones.setOnClickListener(v -> {
            startActivity(new Intent(Vender1Activity.this, PublicacionesActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        tvMoneda.setOnClickListener(v -> {
            tvSoles.setVisibility(View.VISIBLE);
            tvDolares.setVisibility(View.VISIBLE);
            tvMoneda.setText("Seleccione...");
        });
        tvSoles.setOnClickListener(v -> {
            tvSoles.setVisibility(View.GONE);
            tvDolares.setVisibility(View.GONE);
            tvMoneda.setText("PEN");
        });
        tvDolares.setOnClickListener(v -> {
            tvSoles.setVisibility(View.GONE);
            tvDolares.setVisibility(View.GONE);
            tvMoneda.setText("USD");
        });
        btnContinuar.setOnClickListener(v -> {
            startActivity(new Intent(Vender1Activity.this, Vender2Activity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
        ivFoto.setOnClickListener(v -> {
            buscarFoto();
        });
        tvUnidad.setOnClickListener(v -> {
            if (rvUnidades.getVisibility() == View.VISIBLE) {
                rvUnidades.setVisibility(View.GONE);
            } else {
                rvUnidades.setVisibility(View.VISIBLE);
            }
        });
        if (!contenidoImagen.equals("")) {
            Picasso.get()
                    .load(getImageUri(this, getBitmap(contenidoImagen)))
//                    .placeholder(R.drawable.ic_camara)
//                    .transform(new BorderedCircleTransform(80, Color.rgb(1, 40, 105)))
                    .into(ivFoto);
        } else {
            Picasso.get()
                    .load(R.drawable.ic_camara)
//                    .placeholder(R.drawable.ic_camara)
//                    .transform(new BorderedCircleTransform(80, Color.rgb(1, 40, 105)))
                    .into(ivFoto);
        }
    }

    public void obtenerUnidades() {
        params = new HashMap<>();
        webService.consulta(params, "obtener_unidades.php");
    }

    public static void cargarUnidades(UnidadAdapter unidadAdapter) {
        rvUnidades.setAdapter(unidadAdapter);
    }

    public void buscarFoto() {
        Log.i("buscarFoto", "Registro2Activity");
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Seleccione Imagen"), PICK_PERFIL_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PERFIL_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                contenidoImagen = getStringImage(bitmap);
                Picasso.get()
                        .load(getImageUri(this, bitmap))
                        .transform(new BorderedCircleTransform(0, Color.rgb(1, 40, 105)))
                        .into(ivFoto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "IMG_" + Calendar.getInstance().getTime(), null);
        return Uri.parse(path);
    }

    public Bitmap getBitmap(String imagenContent) {
        String base64Image = imagenContent;
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Vender1Activity.this, ComprarVenderActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
