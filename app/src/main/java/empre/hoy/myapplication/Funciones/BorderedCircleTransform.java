package empre.hoy.myapplication.Funciones;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * By: El Bryant
 */

public class BorderedCircleTransform implements Transformation {
    private final int borderWidth;
    private final int borderColor;

    public BorderedCircleTransform(int borderWidth, int borderColor) {
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }
        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float r = size / 2f;
        Paint paintBg = new Paint();
        paintBg.setColor(borderColor);
        paintBg.setStyle(Paint.Style.FILL_AND_STROKE);
        paintBg.setAntiAlias(true);
        canvas.drawCircle(r, r, r, paintBg);
        canvas.drawCircle(r, r, r - borderWidth, paint);
        squaredBitmap.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return "bordered_circle";
    }
}