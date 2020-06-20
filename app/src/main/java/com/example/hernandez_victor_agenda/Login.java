package com.example.hernandez_victor_agenda;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import android.os.Bundle;

public class Login extends AppCompatActivity {

    EditText campo1, campo2;
    String pass;
    String user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        campo1= (EditText) findViewById(R.id.txtcam1);
        campo2= (EditText) findViewById(R.id.txtcam2);

    }

    public void click(View view) {
        campo1.setText("");
        campo2.setText("");
    }

    public void Login(View view){
        user=campo1.getText().toString();
        pass=campo2.getText().toString();

        if (user.isEmpty() ){
            Toast.makeText(this,"Introduzca su user por favor", Toast.LENGTH_LONG).show();
        }
        if (pass.isEmpty()){
            Toast.makeText(this,"Introduzca su pass por favor", Toast.LENGTH_LONG).show();
        }


        else {
            if (user.equals("admin") && pass.equals("1234")) {
                Intent window = new Intent(Login.this, MainActivity.class);
                startActivity(window);

            } else {
                Toast.makeText(this, "Verifique sus credenciales", Toast.LENGTH_LONG).show();
            }
        }
    }
}
