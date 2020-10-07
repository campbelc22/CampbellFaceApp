package up.edu.campbellfaceapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;


import androidx.annotation.RequiresApi;

import java.util.*;


/**
 * Face class for building a cute face app!
 * @ChloeCampbell
 * Version 2.0 for homework part B
 * 10-6-2020
 */

public class Face extends SurfaceView  {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    Paint paint = new Paint();

    int redColor, greenColor, blueColor, color;

    public Face(Context context, AttributeSet attr) {
        super(context, attr);
        setBackgroundColor(Color.WHITE);
        randomize();
    }
    public void randomize() {

        /**
         * External Citation:
         * Date: 10-6-2020
         * problem: need to create a random color!
         * resourc: https://stackoverflow.com/questions/5280367/android-generate-random-color-on-click
         * solution: I used sample code from this post.
         */
        Random rnd = new Random();
        this.skinColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        this.eyeColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        this.hairColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        this.hairStyle = (int)(Math.random()*3);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onDraw(Canvas canvas) {
        drawFace(canvas);
        drawEyes(canvas);
        drawHair(canvas);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawFace(Canvas canvas) {
        paint.setColor(skinColor);
        canvas.drawOval(20f,20f,1020f,750f, paint);
        paint.setColor(Color.RED);
        canvas.drawArc(425,550,525,600,180,-180,true, paint);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEyes(Canvas canvas) {
        paint.setColor(eyeColor);
        canvas.drawOval(300f,260f, 360f,310f, paint);
        canvas.drawOval(600f, 260f, 660f, 310f, paint);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawHair(Canvas canvas) {
        paint.setColor(hairColor);
        if(hairStyle == 0){
            canvas.drawArc(20f,200f, 160f, 750f, 90,180, true, paint);
            canvas.drawArc(880f,200f, 1020f, 750f, 90,-180, true, paint);
            canvas.drawArc(90f,20f, 950f, 375f, 180,180, true, paint);
            return;
        }
        else if (hairStyle == 1) {
            canvas.drawArc(20f,200f, 160f, 550f, 90,180, true, paint);
            canvas.drawArc(880f,200f, 1020f, 550f, 90,-180, true, paint);
            canvas.drawArc(90f,20f, 950f, 375f, 180,180, true, paint);
            return;
        }
        else {
            canvas.drawArc(90f,20f, 1000f, 375f, 210,180, true, paint);
            canvas.drawArc(980f,320f, 1120f, 800f, 0,-120, true, paint);
            return;
        }
    }

    public void setSkinColor(int red, int green, int blue) {
        this.skinColor = Color.rgb(red, green, blue);
    }

    public void setEyeColor(int red, int green, int blue) {
        this.eyeColor = Color.rgb(red, green, blue);
    }

    public void setHairColor(int red, int green, int blue) {
        this.hairColor = Color.rgb(red, green, blue);
    }
}
