package brain.radzhabov.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Приложение на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Приложение на весь экран - конец

        preferences = getSharedPreferences("Userinfo", 0);

        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(v -> {
            //обработка кнопки "Начать"
            try {
                String registeredUsername = preferences.getString("usernameLogged", "admin");
                if(registeredUsername.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, GameLevelsAdmin.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть окно(а это в свою очередь класс)
                } else {
                    Intent intent = new Intent(MainActivity.this, GameLevels.class); //Намерение для перехода
                    startActivity(intent); //Старт намерения
                    finish(); //Закрыть окно(а это в свою очередь класс)
                }
            } catch(Exception e) {
                //пусто
            }
        });
        Button buttonLogout = findViewById(R.id.btnLogout);
        buttonLogout.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity.this, "Вы успешно вышли из учетной учетной записи!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                //пусто
            }
        });
    }
    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    //Системная кнопка "Назад" - конец
}