package com.example.android.Afif_uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText)findViewById(R.id.inputUsername);
        Password = (EditText)findViewById(R.id.inputPassword);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("Kesempatan input: 5");

                Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validate(Username.getText().toString(), Password.getText().toString());
                    }
                });
    }

    private void validate(String Username, String Password){
        if(Username.equals("Admin") && Password.equals("admin")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Kesempatan input: "+String.valueOf(counter));
            if (counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
