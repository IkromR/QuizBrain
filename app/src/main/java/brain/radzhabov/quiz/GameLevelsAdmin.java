package brain.radzhabov.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class GameLevelsAdmin extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    SwitchCompat level1, level2, level3, level4, level5;
    boolean stateLevel1;
    boolean stateLevel2;
    boolean stateLevel3;
    boolean stateLevel4;
    boolean stateLevel5;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels_admin);

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        level5 = findViewById(R.id.level5);

        preferences = getSharedPreferences("Userinfo", 0);

        level1.setChecked(preferences.getBoolean("stateLevel1", stateLevel1));
        level2.setChecked(preferences.getBoolean("stateLevel2", stateLevel2));
        level3.setChecked(preferences.getBoolean("stateLevel3", stateLevel3));
        level4.setChecked(preferences.getBoolean("stateLevel4", stateLevel4));
        level5.setChecked(preferences.getBoolean("stateLevel5", stateLevel5));

        //Приложение на вес экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Приложение на вес экран - конец

        //Обработка кнопки "Назад" - начало
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevelsAdmin.this, MainActivity.class); //Намерение для перехода
                startActivity(intent); //Старт намерения
                finish(); //Закрыть окно(а это в свою очередь класс)
            }
        });
        //Обработка кнопки "Назад" - конец
    }

    @Override
    protected void onStop() {
        super.onStop();

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        level5 = findViewById(R.id.level5);

        preferences = getSharedPreferences("Userinfo", 0);

        stateLevel1 = level1.isChecked();
        stateLevel2 = level2.isChecked();
        stateLevel3 = level3.isChecked();
        stateLevel4 = level4.isChecked();
        stateLevel5 = level5.isChecked();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("stateLevel1", stateLevel1);
        editor.putBoolean("stateLevel2", stateLevel2);
        editor.putBoolean("stateLevel3", stateLevel3);
        editor.putBoolean("stateLevel4", stateLevel4);
        editor.putBoolean("stateLevel5", stateLevel5);
        editor.apply();


    }

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        //обработка кнопки "Назад"
        try {
            Intent intent = new Intent(GameLevelsAdmin.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {//пусто}
        }
        //Системная кнопка "Назад" - конец
    }
}