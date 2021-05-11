package brain.radzhabov.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        //Приложение на вес экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Приложение на вес экран - конец

        //Обработка кнопки "Назад" - начало
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть окно(а это в свою очередь класс)
                } catch (Exception e) {
                    //пусто
                }
            }
        });
        //Обработка кнопки "Назад" - конец

        //Кнопка для перехода на 1 уровень - начало
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(GameLevels.this, Level1.class); //Намерение для перехода
                startActivity(intent); //Старт намерения
                finish();
            } catch (Exception e) {
                //пусто
            }
        });
        //Кнопка для перехода на 1 уровень - конец

        //Кнопка для перехода на 2 уровень - начало
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(GameLevels.this, Level2.class); //Намерение для перехода
                startActivity(intent); //Старт намерения
                finish();
            } catch (Exception e) {
                //пусто
            }
        });
        //Кнопка для перехода на 2 уровень - конец

        //Кнопка для перехода на 3 уровень - начало
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(GameLevels.this, Level3.class); //Намерение для перехода
                startActivity(intent); //Старт намерения
                finish();
            } catch (Exception e) {
                //пусто
            }
        });
        //Кнопка для перехода на 3 уровень - конец
    }


    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        //обработка кнопки "Назад"
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {//пусто}
        }
        //Системная кнопка "Назад" - конец
    }
}