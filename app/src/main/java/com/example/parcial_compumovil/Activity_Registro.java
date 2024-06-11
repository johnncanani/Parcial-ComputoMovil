package com.example.parcial_compumovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Registro extends AppCompatActivity {

    private Spinner sp;
    private EditText et_usuario;
    private EditText et_password;
    private RadioButton rb_m, rb_f, rb_otro;
    private CheckBox cb_fulbol, cb_voley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp = (Spinner) findViewById(R.id.spinner);
        String[] colores = {"Rojo", "Verde", "Azul", "Rosa", "Negro"};
        ArrayAdapter<String> mi_lista_colores = new ArrayAdapter<>(this, R.layout.list_view_john, colores);
        sp.setAdapter(mi_lista_colores);

        //obteniendo los datos de la parte grafica
        et_usuario = (EditText) findViewById(R.id.txt_reg_usuario);
        et_password = (EditText) findViewById(R.id.txt_reg_pass);
        rb_m = (RadioButton) findViewById(R.id.rbt_masculino);
        rb_f = (RadioButton) findViewById(R.id.rbt_femenino);
        rb_otro = (RadioButton) findViewById(R.id.rbt_otro);
        cb_fulbol = findViewById(R.id.cb_futbol);
        cb_voley = findViewById(R.id.cb_voley);

    }

    public void cancelar(View view) {
        Intent cancelar = new Intent(this, MainActivity.class);
        startActivity(cancelar);
        finish();
    }

    public void registro_A2(View view){

        obtener_datos();

    }

    private void obtener_datos(){

        String usuario = et_usuario.getText().toString();
        String password = et_password.getText().toString();
        String sexo = obtener_tipo_sexo();
        String color = obtener_color();
        String deporte = obtener_deporte();
        String respuesta_validar = Validando_datos(usuario, password, deporte);

        if (respuesta_validar.equals("")){
            String mensaje = "datos : " + usuario + ",  " + password + ",  " + sexo + ",  " + color + ",  " + deporte;
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

            enviar_datos(usuario, password);
        } else {
            Toast.makeText(this, respuesta_validar, Toast.LENGTH_SHORT).show();
        }

    }

    private String obtener_tipo_sexo() {
        if (rb_m.isChecked()) {
            return "Masculino";
        } else if (rb_f.isChecked()) {
            return "Femenino";
        } else if (rb_otro.isChecked()) {
            return "Otro";
        }
        return "hay un error-sexo";
    }

    private String obtener_deporte() {
        String d = "";
        if (cb_fulbol.isChecked()){
            d += " futbol";
        } else if (cb_voley.isChecked()) {
            d += " voley";
        }
        return d;
    }



    private String obtener_color() {
        int selecion = sp.getSelectedItemPosition() + 1;

        switch (selecion){
            case 1: return "Rojo";
            case 2: return "Verde";
            case 3: return "Azul";
            case 4: return "Rosa";
            case 5: return "Negro";
        }
        return "hay un error-color";
    }

    private void enviar_datos(String usuario, String password) {
        Intent enviar = new Intent(this, MainActivity.class);
        enviar.putExtra("usuario", usuario);
        enviar.putExtra("password", password);
        startActivity(enviar);
    }

    private String Validando_datos(String usu, String pass, String deporte) {

        if (usu.isEmpty()){
            return "Ingrese su usuario";
        } else if (pass.isEmpty()) {
            return "Ingrese la contraseña";
        } else if (deporte.isEmpty()) {
            return "Elija un deporte";
        } else{
            return "";
        }

    }


}