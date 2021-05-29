package brain.radzhabov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, address;
    RadioGroup gender;
    Button register, cancel;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        gender = findViewById(R.id.gender);

        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        preferences = getSharedPreferences("Userinfo", 0);

        // Приложение на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Приложение на весь экран - конец

        register.setOnClickListener(v -> {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            String addressValue = address.getText().toString();
            RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
            String genderValue = checkedBtn.getText().toString();
            if(usernameValue.length() > 1) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", usernameValue);
                editor.putString("password", passwordValue);
                editor.putString("address", addressValue);
                editor.putString("gender", genderValue);
                editor.apply();
                Toast.makeText(RegisterActivity.this, "User registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(RegisterActivity.this, "Enter Value in the fields", Toast.LENGTH_SHORT).show();
            }

        });
        cancel.setOnClickListener(v -> {
            emptyField();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
    public void emptyField() {
        username.setText("");
        password.setText("");
        address.setText("");
    }

}