package com.example.frontflix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//package com.example.frontflix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonCadastrar, buttonVoltar;
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonCadastrar = findViewById(R.id.button_cadastrar);
        buttonVoltar = findViewById(R.id.button_voltar);

        dbManager = new DatabaseManager(this);
        dbManager.open();

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String senha = editTextPassword.getText().toString();

                // Inserir o usuário no banco de dados e obter o ID da linha inserida
                long result = dbManager.addUser(email, senha);

                // Verificar se a inserção foi bem-sucedida
                if (result > 0) {
                    Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CadastroActivity.this, "Erro ao realizar cadastro. Tente novamente.", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
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


//public class CadastroActivity extends AppCompatActivity {
//
//    private EditText emailEditText, senhaEditText;
//    private DatabaseManager databaseManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.cadastro);
//
//        emailEditText = findViewById(R.id.editTextTextEmailAddress);
//        senhaEditText = findViewById(R.id.editTextTextPassword);
//        databaseManager = new DatabaseManager(this);
//
//        Button cadastrarButton = findViewById(R.id.button_cadastrar);
//        cadastrarButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cadastrarUsuario();
//            }
//        });
//
//        Button voltarButton = findViewById(R.id.button_voltar);
//        voltarButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }
//
//    private void cadastrarUsuario() {
//        String email = emailEditText.getText().toString();
//        String senha = senhaEditText.getText().toString();
//
//        if (databaseManager.addUser(email, senha)) {
//            Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
//            startActivity(intent);
//        } else {
//            Toast.makeText(CadastroActivity.this, "Erro ao cadastrar. Tente novamente.", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
