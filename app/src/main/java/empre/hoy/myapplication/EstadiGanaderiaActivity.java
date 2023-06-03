package empre.hoy.myapplication;

import static empre.hoy.myapplication.Funciones.PrefUtil.fondoGeneral;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.entity.VentasReporte;

public class EstadiGanaderiaActivity extends AppCompatActivity {
    static XAxis xAxis;
    static BarChart bchVentas;
    BlurView blurView;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ImageView ivFiltro;
    String fecha;
    WebService webService;
    Map<String, String> params;
    YAxis left;
    static ArrayList<Integer> colores = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadiganaderia);
        bchVentas = (BarChart) findViewById(R.id.bchVentas);
        blurView = (BlurView) findViewById(R.id.blurView);
        ivFiltro = (ImageView) findViewById(R.id.ivFiltro);
        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(2.5f)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(false);
        webService = new WebService(this);
        Date date = new Date();
        fecha = dateFormat.format(date);
        for (int i = 0; i < 10; i++) {
            colores.add(Color.rgb(235, 64, 52));
            colores.add(Color.rgb(61, 52, 235));
            colores.add(Color.rgb(7, 105, 36));
            colores.add(Color.rgb(23, 24, 145));
            colores.add(Color.rgb(75, 78, 85));
            colores.add(Color.rgb(5, 86, 93));
            colores.add(Color.rgb(46, 95, 68));
            colores.add(Color.rgb(25, 100, 35));
            colores.add(Color.rgb(36, 20, 75));
        }
        mostrarCuadro();
        ivFiltro.setOnClickListener(v -> {
            startActivity(new Intent(EstadiGanaderiaActivity.this, EstadisticasGeneralActivity.class));
        });
    }

    public void mostrarCuadro() {
        bchVentas.setBackgroundColor(Color.TRANSPARENT);
        bchVentas.setExtraTopOffset(20f);
        bchVentas.setExtraBottomOffset(20f);
        bchVentas.setExtraLeftOffset(20f);
        bchVentas.setExtraRightOffset(20f);
//        bchVentas.setDrawBarShadow(false);
        bchVentas.setDrawValueAboveBar(true);
        bchVentas.getDescription().setEnabled(false);
        bchVentas.setPinchZoom(false);
        bchVentas.setScaleEnabled(false);
        bchVentas.setDrawGridBackground(false);
        xAxis = bchVentas.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
//        xAxis.setTypeface(Typeface.createFromAsset(getAssets(), "font/sofia_pro_medium.otf"));
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setAxisLineColor(Color.BLACK);
        xAxis.setAxisLineWidth(1f);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setTextSize(12f);
        xAxis.setLabelCount(4);
        xAxis.setDrawLabels(false);
        xAxis.setCenterAxisLabels(false);
//        xAxis.setGranularity(1f);
        left = bchVentas.getAxisLeft();
        left.setDrawLabels(false);
        left.setSpaceTop(30f);
        left.setSpaceBottom(0f);
        left.setDrawAxisLine(true);
        left.setDrawZeroLine(true);
        left.setAxisLineWidth(1f);
        left.setAxisLineColor(Color.BLACK);
        left.setTextColor(Color.BLACK);
        xAxis.setTextSize(12f);
        left.setDrawGridLines(true);
        left.setDrawZeroLine(true);
        left.setZeroLineColor(Color.BLACK);
        left.setZeroLineWidth(1f);
        bchVentas.getAxisRight().setEnabled(true);
        params = new HashMap<>();
        Log.i("fecha", fecha);
        params.put("fecha", fecha);
        webService.consulta(params, "obtener_cantidad_ventas_ganaderia.php");
    }

    public static void obtenerVentas(ArrayList<VentasReporte> ventas) {
        if (ventas.size() > 0) {
            final List<Data> data = new ArrayList<>();
            BarData barData = new BarData();
            barData.setValueTextSize(12f);
//            barData.setValueFormatter(new ValueFormatter());
            barData.setBarWidth(0.5f);
            for (int i = 0; i < ventas.size(); i++) {
                data.add(new Data(0, (int) ventas.get(i).getCantidad(), ventas.get(i).getNombreProducto()));
                Data d = data.get(i);
                ArrayList<BarEntry> values = new ArrayList<>();
                BarEntry entry = new BarEntry(i + 1, d.yValue);
                values.add(entry);
                BarDataSet set = new BarDataSet(values, data.get(i).xAxisValue);
                Random rand = new Random();
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();
                set.setColor(Color.rgb(r, g, b));
                set.setValueTextColor(Color.rgb(0,0,0));
                set.setValueTextSize(12f);
                set.setValueFormatter(new ValueFormatter());
                barData.addDataSet(set);
            }
            bchVentas.setData(barData);
            bchVentas.invalidate();
            Legend l = bchVentas.getLegend();
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
            l.setOrientation(Legend.LegendOrientation.VERTICAL);
            l.setDrawInside(true);
            l.setXOffset(10f);
            l.setYEntrySpace(0f);
            l.setTextSize(12f);
            bchVentas.getLegend().setYOffset(-6f * ventas.size());
            bchVentas.setExtraBottomOffset(15f * ventas.size() + 30f);
            ViewGroup.LayoutParams params = bchVentas.getLayoutParams();
            params.height = (int) (750 + 15f * ventas.size());
            bchVentas.setLayoutParams(params);
        }
    }

    private static class Data {
        final String xAxisValue;
        final int yValue;
        final int xValue;

        Data(int xValue, int yValue, String xAxisValue) {
            this.xAxisValue = xAxisValue;
            this.yValue = yValue;
            this.xValue = xValue;
        }
    }

    private static class ValueFormatter extends com.github.mikephil.charting.formatter.ValueFormatter implements IValueFormatter {
        private final DecimalFormat mFormat;

        ValueFormatter() {
            mFormat = new DecimalFormat("0");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format((int) value);
        }
    }
}
