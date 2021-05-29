package brain.radzhabov.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class GameLevels extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        preferences = getSharedPreferences("Userinfo", 0);

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
        TextView textView1 = findViewById(R.id.textView1);
        boolean stateLevel1 = preferences.getBoolean("stateLevel1", true);
        if(stateLevel1) {
            textView1.setEnabled(false);
        } else {
            textView1.setOnClickListener(v -> {
                if (level >= 1) {
                    Intent intent = new Intent(GameLevels.this, Level1.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish();
                }
            });
        }
        //Кнопка для перехода на 1 уровень - конец

        //Кнопка для перехода на 2 уровень - начало
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        boolean stateLevel2 = preferences.getBoolean("stateLevel2", true);
        if(stateLevel2) {
            textView2.setEnabled(false);
        } else {
            if (level >= 2) {
                textView2.setBackgroundResource(R.drawable.secondlevel);
            }
            textView2.setOnClickListener(v -> {
                if (level >= 2) {
                    Intent intent = new Intent(GameLevels.this, Level2.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish();
                }
            });
        }
        //Кнопка для перехода на 2 уровень - конец

        //Кнопка для перехода на 3 уровень - начало
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        boolean stateLevel3 = preferences.getBoolean("stateLevel3", true);
        if(stateLevel3) {
            textView3.setEnabled(false);
        } else {
            if (level >= 3) {
                textView3.setBackgroundResource(R.drawable.thirdlevel);
            }
            textView3.setOnClickListener(v -> {
                try {
                    if (level >= 3) {
                        textView3.setCompoundDrawablePadding(R.drawable.thirdlevel);
                        Intent intent = new Intent(GameLevels.this, Level3.class); //Намерение для перехода
                        startActivity(intent); //Старт намерения
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {
                    //пусто
                }
            });
        }
        //Кнопка для перехода на 3 уровень - конец

        //Кнопка для перехода на 4 уровень - начало
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        boolean stateLevel4 = preferences.getBoolean("stateLevel4", true);
        if(stateLevel4) {
            textView4.setEnabled(false);
        } else {
            if (level >= 4) {
                textView4.setBackgroundResource(R.drawable.fourlevel);
            }
            textView4.setOnClickListener(v -> {
                try {
                    if (level >= 4) {
                        textView4.setCompoundDrawablePadding(R.drawable.fourlevel);
                        Intent intent = new Intent(GameLevels.this, Level4.class); //Намерение для перехода
                        startActivity(intent); //Старт намерения
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {
                    //пусто
                }
            });
        }
        //Кнопка для перехода на 4 уровень - конец

        //Кнопка для перехода на 5 уровень - начало
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        boolean stateLevel5 = preferences.getBoolean("stateLevel5", true);
        if(stateLevel5) {
            textView5.setEnabled(false);
        } else {
            if (level >= 5) {
                textView5.setBackgroundResource(R.drawable.fivelevel);
            }
            textView5.setOnClickListener(v -> {
                try {
                    if (level >= 5) {
                        textView5.setCompoundDrawablePadding(R.drawable.fivelevel);
                        Intent intent = new Intent(GameLevels.this, Level5.class); //Намерение для перехода
                        startActivity(intent); //Старт намерения
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {
                    //пусто
                }
            });
        }
        //Кнопка для перехода на 5 уровень - конец
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