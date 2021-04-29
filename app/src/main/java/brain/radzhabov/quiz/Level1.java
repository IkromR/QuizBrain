package brain.radzhabov.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //код для скругление углов левой картинки
        img_left.setClipToOutline(true);


        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //код для скругление углов правой картинки
        img_right.setClipToOutline(true);


        // Приложение на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Приложение на весь экран - конец
    }
}