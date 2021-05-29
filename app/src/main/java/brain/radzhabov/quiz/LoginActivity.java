package brain.radzhabov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login, register;
    private long backPressedTime;
    private Toast backToast;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Приложение на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Приложение на весь экран - конец

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        preferences = getSharedPreferences("Userinfo", 0);

        login.setOnClickListener(v -> {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();

            String registeredUsername = preferences.getString("username", "");
            String registeredPassword = preferences.getString("password", "");


            SharedPreferences.Editor editor = preferences.edit();
            if(usernameValue.equals("admin") && passwordValue.equals("admin")) {
                editor.putString("usernameLogged", "admin");
                editor.apply();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(LoginActivity.this, "Добро пожаловать в учетную запись, администратор!", Toast.LENGTH_SHORT).show();
            } else if ((usernameValue.equals(registeredUsername) && passwordValue.equals(registeredPassword))){
                editor.putString("usernameLogged", registeredUsername);
                editor.apply();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(LoginActivity.this, "Добро пожаловать в учетную запись, пользователь!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Неправильный логин или пароль!", Toast.LENGTH_SHORT).show();
            }

        });
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
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