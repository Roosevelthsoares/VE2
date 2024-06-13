package com.example.frontflix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private TextView buttonCadastrese;
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.button);
        buttonCadastrese = findViewById(R.id.cadastrese);

        dbManager = new DatabaseManager(this);
        dbManager.open();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String senha = editTextPassword.getText().toString();

                // Autenticar o usuário
                boolean authenticated = dbManager.authenticateUser(email, senha);

                if (authenticated) {
                    Toast.makeText(MainActivity.this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, HelloActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email ou senha incorretos. Tente novamente.", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}


//public class MainActivity extends AppCompatActivity {
//
//    private EditText editTextEmail, editTextPassword;
//    private Button buttonLogin, buttonCadastrese;
//    private DatabaseManager dbManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
//        editTextPassword = findViewById(R.id.editTextTextPassword);
//        buttonLogin = findViewById(R.id.button);
//        TextView cadastreSe = findViewById(R.id.cadastrese);
//
//        dbManager = new DatabaseManager(this);
//        dbManager.open();
//
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = editTextEmail.getText().toString();
//                String senha = editTextPassword.getText().toString();
//
//                // Autenticar o usuário
//                boolean authenticated = dbManager.authenticateUser(email, senha);
//
//                if (authenticated) {
//                    Toast.makeText(MainActivity.this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(MainActivity.this, HelloActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(MainActivity.this, "Email ou senha incorretos. Tente novamente.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        buttonCadastrese.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        dbManager.close();
//    }
//}


//public class MainActivity extends AppCompatActivity {
//
//    private Button button;
//    private EditText emailEditText, senhaEditText;
//    private DatabaseManager databaseManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        emailEditText = findViewById(R.id.editTextTextEmailAddress);
//        senhaEditText = findViewById(R.id.editTextTextPassword);
//        databaseManager = new DatabaseManager(this);
//
//        Button loginButton = findViewById(R.id.button);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                autenticarUsuario();
//            }
//        });
//
//        TextView cadastreSe = findViewById(R.id.cadastrese);
//        cadastreSe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void autenticarUsuario() {
//        String email = emailEditText.getText().toString();
//        String senha = senhaEditText.getText().toString();
//
//        if (databaseManager.authenticateUser(email, senha)) {
//            Toast.makeText(MainActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, HelloActivity.class);
//            startActivity(intent);
//            finish(); // Finaliza a MainActivity para que o usuário não possa voltar para a tela de login com o botão de voltar
//        } else {
//            Toast.makeText(MainActivity.this, "Erro ao autenticar. Verifique suas credenciais.", Toast.LENGTH_SHORT).show();
//        }
//    }
//}