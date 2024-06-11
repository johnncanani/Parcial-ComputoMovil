package com.example.parcial_compumovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et_usu;
    private EditText et_cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_usu =  findViewById(R.id.txt_usuario);
        et_cont =  findViewById(R.id.txt_password);

    }

    //evitar que el boton de back funcione
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void registrar(View view) {
        Intent regresar = new Intent(this, Activity_Registro.class);
        startActivity(regresar);
    }

    public void login(View view) {

        String usuario = et_usu.getText().toString();
        String pasword = et_cont.getText().toString();

        String respuesta_validacion = validar_campos(usuario, pasword);

        if (respuesta_validacion.equals("")){

            validar_usuario_existente(usuario, pasword);

        } else {
            Toast.makeText(this, respuesta_validacion, Toast.LENGTH_SHORT).show();
        }

    }
    
    private void validar_usuario_existente(String usuario, String pasword) {

        try {
//

            if (getIntent().getStringExtra("usuario") == null || getIntent().getStringExtra("password") == null){
                Toast.makeText(this, "Este usuario no existe", Toast.LENGTH_SHORT).show();
            } else {

                String usuario_A1 = getIntent().getStringExtra("usuario");
                String password_A1 = getIntent().getStringExtra("password");

                if (usuario_A1.equals(usuario) && password_A1.equals(pasword)){
                    Intent login = new Intent(this, Activity_Michi.class);
                    login.putExtra("usuario_A1", usuario_A1);
                    startActivity(login);
                    finish();
                } else {
                    Toast.makeText(this, "El usuario no esta registrado", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Existe un error: " + e.getClass().getName(), Toast.LENGTH_LONG).show();
        }


    }

    private String validar_campos(String usuario, String password) {
        if (usuario.isEmpty() && password.isEmpty()){
            return "Ingrese su usuario y contraseña";
        } else if (usuario.isEmpty()) {
            return "Ingrese su usuario";
        } else if (password.isEmpty()) {
            return "Ingrese su contraseña";
        } else {
            return "";
        }
    }
}