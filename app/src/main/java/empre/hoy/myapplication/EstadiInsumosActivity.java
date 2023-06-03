package empre.hoy.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import empre.hoy.myapplication.Funciones.WebService;
import empre.hoy.myapplication.entity.VentasReporte;

public class EstadiInsumosActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_estadiinsumos);
        bchVentas = (BarChart) findViewById(R.id.bchVentas);
        blurView = (BlurView) findViewById(R.id.blurView);
        ivFiltro = (ImageView) findViewById(R.id.ivFiltro);
        webService = new WebService(this);
        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(2.5f)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(false);
        Date date = new Date();
        fecha = dateFormat.format(date);
        colores.add(Color.rgb(2, 124, 130));
        colores.add(Color.rgb(213, 213, 82));
        colores.add(Color.rgb(124, 63, 96));
        colores.add(Color.rgb(23, 24, 145));
        colores.add(Color.rgb(75, 78, 85));
        colores.add(Color.rgb(5, 86, 93));
        colores.add(Color.rgb(46, 95, 68));
        colores.add(Color.rgb(25, 100, 35));
        colores.add(Color.rgb(36, 20, 75));
        mostrarCuadro();
        ivFiltro.setOnClickListener(v -> {
            startActivity(new Intent(EstadiInsumosActivity.this, EstadisticasGeneralActivity.class));
        });
    }

    public void mostrarCuadro() {
        bchVentas.setBackgroundColor(Color.TRANSPARENT);
        bchVentas.setExtraTopOffset(20f);
        bchVentas.setExtraBottomOffset(20f);
        bchVentas.setExtraLeftOffset(20f);
        bchVentas.setExtraRightOffset(20f);
        bchVentas.setDrawBarShadow(false);
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
        xAxis.setAxisLineColor(Color.WHITE);
        xAxis.setAxisLineWidth(1f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(12f);
        xAxis.setLabelCount(4);
        xAxis.setDrawLabels(false);
        xAxis.setCenterAxisLabels(false);
        xAxis.setGranularity(1f);
        left = bchVentas.getAxisLeft();
        left.setDrawLabels(false);
        left.setSpaceTop(30f);
        left.setSpaceBottom(0f);
        left.setDrawAxisLine(true);
        left.setDrawZeroLine(true);
        left.setAxisLineWidth(1f);
        left.setAxisLineColor(Color.WHITE);
        left.setTextColor(Color.WHITE);
        left.setDrawGridLines(true);
        left.setDrawZeroLine(true);
        left.setZeroLineColor(Color.WHITE);
        left.setZeroLineWidth(1f);
        bchVentas.getAxisRight().setEnabled(true);
        bchVentas.getLegend().setEnabled(true);
        params = new HashMap<>();
        Log.i("fecha", fecha);
        params.put("fecha", fecha);
        webService.consulta(params, "obtener_cantidad_ventas_insumos.php");
    }

    public static void obtenerVentas(ArrayList<VentasReporte> ventas) {
        if (ventas.size() > 0) {
            final List<EstadiInsumosActivity.Data> data = new ArrayList<>();
            for (int i = 0; i < ventas.size(); i++) {
                data.add(new EstadiInsumosActivity.Data(0, (float) ventas.get(i).getCantidad(), "Revisión " + (i + 1)));
            }
            xAxis.setValueFormatter(new EstadiInsumosActivity.ValueFormatter() {
                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    return data.get(Math.min(Math.max((int) value, 0), data.size()) - 1).xAxisValue;
                }
            });
            setData(data);
        }
    }

    private static void setData(List<EstadiInsumosActivity.Data> dataList) {
        ArrayList<BarEntry> values = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            EstadiInsumosActivity.Data d = dataList.get(i);
            BarEntry entry = new BarEntry(i + 1, d.yValue);
            values.add(entry);
            colors.add(colores.get(i));
        }
        BarDataSet set;
        if (bchVentas.getData() != null && bchVentas.getData().getDataSetCount() > 0) {
            set = (BarDataSet) bchVentas.getData().getDataSetByIndex(0);
            set.setValues(values);
            bchVentas.getData().notifyDataChanged();
            bchVentas.notifyDataSetChanged();
        } else {
            set = new BarDataSet(values, "Productos");
            set.setColors(colors);
            set.setValueTextColors(colors);
            BarData data = new BarData(set);
            data.setValueTextSize(12f);
            data.setValueFormatter(new EstadiInsumosActivity.ValueFormatter());
            data.setBarWidth(0.5f);
            bchVentas.setData(data);
            bchVentas.invalidate();
        }
    }

    private static class Data {
        final String xAxisValue;
        final float yValue;
        final int xValue;

        Data(int xValue, float yValue, String xAxisValue) {
            this.xAxisValue = xAxisValue;
            this.yValue = yValue;
            this.xValue = xValue;
        }
    }

    private static class ValueFormatter extends com.github.mikephil.charting.formatter.ValueFormatter implements IValueFormatter {
        private final DecimalFormat mFormat;

        ValueFormatter() {
            mFormat = new DecimalFormat("#####");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value);
        }
    }
}
