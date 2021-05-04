package brain.radzhabov.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level1 extends AppCompatActivity {
    Dialog dialog;

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


        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this);  //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); //путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалового окна
        dialog.setCancelable(false); //окно нельзя закрыть кнопкой "Назад"

        // Кнопка которое закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обработка нажатие кнопки - начало
                try {
                    //Вернутся назад к выбору уровня - начало
                    Intent intent = new Intent(Level1.this, GameLevels.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть окно(а это в свою очередь класс)
                    //Вернутся назад к выбору уровня - конец
                } catch (Exception e) {
                    //пусто
                }
                dialog.dismiss(); //Закрытие диалогового окна
                //Обработка нажатие кнопки - конец
            }
        });
        // Кнопка которое закрывает диалоговое окно - конец

        //Кнопка "Продолжить" - начало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //Закрытие диалогового окна
            }
        });
        //Кнопка "Продолжить" - конец

        dialog.show(); //показать диаловое окно

        //Кнопка "Назад" - начало
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обработка нажатие кнопки "Назад" - начало
                try {
                    //Вернутся назад к выбору уровня - начало
                    Intent intent = new Intent(Level1.this, GameLevels.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть окно(а это в свою очередь класс)
                    //Вернутся назад к выбору уровня - конец
                } catch (Exception e) {
                    //пусто
                }
                //Обработка нажатие кнопки "Назад" - конец
            }
        });
        //Кнопка "Назад" - конец
    }

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        //обработка кнопки "Назад"
        try {
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            //пусто
        }
        //Системная кнопка "Назад" - конец
    }
}