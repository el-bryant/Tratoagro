package empre.hoy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Comprar22Activity extends AppCompatActivity {
    CarouselView carouselView;
    int[] sampleImages = {
            R.mipmap.fertilizantes2_tratoagro,
            R.mipmap.ganaderia_tratoagro,
            R.mipmap.insumos2_tratoagro,
            R.mipmap.maquinaria2_tratoagro,
            R.mipmap.pesca_tratoagro,
            R.mipmap.pesticidas2_tratoagro
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_2_2);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        ImageListener imageListener = (position, imageView) -> imageView.setImageResource(sampleImages[position]);
        carouselView.setImageListener(imageListener);
    }

}