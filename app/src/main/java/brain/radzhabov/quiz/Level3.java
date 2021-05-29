package brain.radzhabov.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Level3 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;

    SharedPreferences preferences;

    public int numLeft; //Переменная для левой картинки + текст
    public int numRight; //Переменная для правой картинки + текст
    Array array = new Array(); //Создал новый объект из класса Array
    Random random = new Random(); //Для генерации случайных чисел
    public int count = 0; //счетчик правильных ответов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        preferences = getSharedPreferences("Userinfo", 0);

        //Создаю переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level3); //Установили текст


        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //Код для скругление углов левой картинки
        img_left.setClipToOutline(true);


        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //Код для скругление углов правой картинки
        img_right.setClipToOutline(true);

        //Путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        //Путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);

        // Приложение на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Приложение на весь экран - конец

        //Установка фона диалогового окна - начало
        ImageView background = findViewById(R.id.background);
        background.setImageResource(R.drawable.level3);
        //Установка фона диалогового окна - конец

        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this);  //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); //путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалового окна
        dialog.setCancelable(false); //окно нельзя закрыть кнопкой "Назад"

        //Установка картинки в диалоговое окно - начало
        ImageView prewiewimg = (ImageView)dialog.findViewById(R.id.previewimg);
        prewiewimg.setImageResource(R.drawable.previewimg3);
        //Установка картинки в диалоговое окно - конец

        //Установка фон в диалоговое окно - начало
        LinearLayout dialogfon = dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.previewbackground3);
        //Установка фон в диалоговое окно - конец

        //Установка описания задании - начало
        TextView textdiscription = (TextView)dialog.findViewById(R.id.textdescription);
        textdiscription.setText(R.string.levelthree);
        //Установка описания задании - конец

        // Кнопка которое закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(v -> {
            //Обработка нажатие кнопки - начало
            try {
                //Вернутся назад к выбору уровня - начало
                Intent intent = new Intent(Level3.this, GameLevels.class); //Намерение для перехода
                startActivity(intent); //Старт намерения
                finish(); //Закрыть окно(а это в свою очередь класс)
                //Вернутся назад к выбору уровня - конец
            } catch (Exception e) {
                //пусто
            }
            dialog.dismiss(); //Закрытие диалогового окна
            //Обработка нажатие кнопки - конец
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

        //__________________________________________________________________
        //**Вызов диалогового окна в конце игры**\\
        dialogEnd = new Dialog(this);  //создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend); //путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //окно нельзя закрыть кнопкой "Назад"

        //Установка картинки в конечной диалоговой окне - начало
        LinearLayout dialogfonEnd = dialogEnd.findViewById(R.id.dialogfon);
        dialogfonEnd.setBackgroundResource(R.drawable.previewbackground3);
        //Установка картинки в конечной диалоговой окне - конец

        //Интересней факт - начало
        TextView textdiscriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdiscriptionEnd.setText(R.string.levelthreeEnd);
        //Интересней факт - конец

        // Кнопка которое закрывает диалоговое окно - начало
        TextView btnclose2 = dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обработка нажатие кнопки - начало
                try {
                    //Вернутся назад к выбору уровня - начало
                    Intent intent = new Intent(Level3.this, GameLevels.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть окно(а это в свою очередь класс)
                    //Вернутся назад к выбору уровня - конец
                } catch (Exception e) {
                    //пусто
                }
                dialogEnd.dismiss(); //Закрытие диалогового окна
                //Обработка нажатие кнопки - конец
            }
        });
        // Кнопка которое закрывает диалоговое окно - конец

        //Кнопка "Продолжить" - начало
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(v -> {
            boolean stateLevel3 = preferences.getBoolean("stateLevel3", true);
            if(stateLevel3) {
                Intent intent = new Intent(Level3.this, GameLevels.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(Level3.this, Level4.class);
                startActivity(intent);
                finish();
            }
            dialogEnd.dismiss(); //Закрытие диалогового окна
        });
        //Кнопка "Продолжить" - конец
        //__________________________________________________________________

        //Кнопка "Назад" - начало
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обработка нажатие кнопки "Назад" - начало
                try {
                    //Вернутся назад к выбору уровня - начало
                    Intent intent = new Intent(Level3.this, GameLevels.class); //Намерение для перехода
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

        //Массив для прогресса игры - начало
        final int[] progress = {
            R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
            R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
            R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
            R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        //Массив для прогресса игры - конец

        //Подключение анимации - начало
        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);
        //Подключение анимации - конец

        numLeft = random.nextInt(21); //Генерация случайного числа
        img_left.setImageResource(array.image3[numLeft]); //Достаем из массива картинку
        text_left.setText(array.texts3[numLeft]);

        numRight = random.nextInt(21); //Генерация случайного числа от 0 до 9
        //Цикл проверяющий на равенство чисел - начало
        while (numLeft == numRight) {
            numRight = random.nextInt(21);
        }
        //Цикл проверяющий на равенство чисел - конец

        img_right.setImageResource(array.image3[numRight]); //Достаем из массива картинку
        text_right.setText(array.texts3[numRight]);

        //Обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касание картинки - начало
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки -  начало
                    img_right.setEnabled(false); //Блокировка правой картинки
                    if(numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    //Если коснулся картинки - конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Если отпустил палец -  начало
                    if(numLeft > numRight){
                        //Если левая картинка больше
                        if(count < 20 ){
                            count++;
                        }

                        //Закрашываем прогресс серым цветом - начало
                        for(int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашываем прогресс серым цветом - конец

                        //Определение правильных ответов и закрашивание их зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определение правильных ответов и закрашивание их зеленым - конец

                    } else {
                        //Если левая картинка меньше
                        if(count > 0) {
                            if(count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                        }
                        //Закрашываем прогресс серым цветом - начало
                        for(int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашываем прогресс серым цветом - конец

                        //Определение правильных ответов и закрашивание их зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определение правильных ответов и закрашивание их зеленым - конец
                    }
                    //Если отпустил палец - конец
                    if(count == 20) {
                        //Выход из уровня
                        //Сохранение данных о пройденных уровнях
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 3) {
                            //пусто
                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 4);
                            editor.commit();
                        }
                        dialogEnd.show(); //показать диаловое окно
                    }else {
                        numLeft = random.nextInt(21); //Генерация случайного числа
                        img_left.setImageResource(array.image3[numLeft]); //Достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]); //Достаем из массива текст

                        numRight = random.nextInt(21); //Генерация случайного числа
                        //Цикл проверяющий на равенство чисел - начало
                        while (numLeft == numRight) {
                            numRight = random.nextInt(21);
                        }
                        //Цикл проверяющий на равенство чисел - конец

                        img_right.setImageResource(array.image3[numRight]); //Достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]); //Достаем из массива текст
                        img_right.setEnabled(true); //Включаем обратно правую картинки
                    }
                }
                //Условие касание картинки - конец
                return true;
            }
        });
        //Обрабатываем нажатие на левую картинку - конец

        //Обрабатываем нажатие на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касание картинки - начало
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки -  начало
                    img_left.setEnabled(false); //Блокировка левую картинки
                    if(numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    //Если коснулся картинки - конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Если отпустил палец -  начало
                    if(numLeft < numRight){
                        //Если правая картинка больше
                        if(count < 20 ){
                            count++;
                        }

                        //Закрашываем прогресс серым цветом - начало
                        for(int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашываем прогресс серым цветом - конец

                        //Определение правильных ответов и закрашивание их зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определение правильных ответов и закрашивание их зеленым - конец

                    } else {
                        //Если правая картинка меньше
                        if(count > 0) {
                            if(count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                        }
                        //Закрашываем прогресс серым цветом - начало
                        for(int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашываем прогресс серым цветом - конец

                        //Определение правильных ответов и закрашивание их зеленым - начало
                        for(int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определение правильных ответов и закрашивание их зеленым - конец
                    }
                    //Если отпустил палец - конец
                    if(count == 20) {
                        //Выход из уровня
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 3) {
                            //пусто
                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 4);
                            editor.commit();
                        }
                        dialogEnd.show(); //показать диаловое окно
                    }else {
                        numLeft = random.nextInt(21); //Генерация случайного числа
                        img_left.setImageResource(array.image3[numLeft]); //Достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]); //Достаем из массива текст

                        numRight = random.nextInt(21); //Генерация случайного числа

                        //Цикл проверяющий на равенство чисел - начало
                        while (numLeft == numRight) {
                            numRight = random.nextInt(21);
                        }
                        //Цикл проверяющий на равенство чисел - конец

                        img_right.setImageResource(array.image3[numRight]); //Достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]); //Достаем из массива текст
                        img_left.setEnabled(true); //Включаем обратно левую картинки
                    }
                }
                //Условие касание картинки - конец
                return true;
            }
        });
        //Обрабатываем нажатие на правую картинку - конец
    }

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        //обработка кнопки "Назад"
        try {
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            //пусто
        }
        //Системная кнопка "Назад" - конец
    }
}