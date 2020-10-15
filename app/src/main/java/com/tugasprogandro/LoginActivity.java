package com.tugasprogandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText iUsername;
    private EditText iPassword;
    private TextView iAttempts;
    private Button iLogin;

    private String Username = "admin";
    private String Password = "admin";

    boolean valid = false;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iUsername = findViewById(R.id.txtUsername);
        iPassword = findViewById(R.id.txtPassword);
        iLogin = findViewById(R.id.btnLogin);
        iAttempts = findViewById(R.id.txtAttempt);

        iLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = iUsername.getText().toString();
                String inputPassword = iPassword.getText().toString();

                if(inputUsername.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else{
                    valid = validasi(inputUsername, inputPassword);

                    if(!valid){
                        counter--;
                        Toast.makeText(LoginActivity.this, "Username atau Password Anda tidak benar!", Toast.LENGTH_SHORT).show();
                        iAttempts.setText("Number of attempts remaining : " + counter);
                        if(counter==0){
                            iLogin.setEnabled(false);
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validasi(String uname, String pass){
        if(uname.equals(Username) && pass.equals(Password)){
            return true;
        }
        return false;
    }
}