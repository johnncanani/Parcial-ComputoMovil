package com.example.parcial_compumovil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Michi extends AppCompatActivity {

    private TextView tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9;
    private boolean turno = true;
    private String letra_turno = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_michi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tv_saludo = findViewById(R.id.txt_saludo);
        String usuario = getIntent().getStringExtra("usuario_A1");
        tv_saludo.setText(String.format("Hello: %s", usuario));

        tv_1 = findViewById(R.id.tv1);
        tv_2 = findViewById(R.id.tv2);
        tv_3 = findViewById(R.id.tv3);
        tv_4 = findViewById(R.id.tv4);
        tv_5 = findViewById(R.id.tv5);
        tv_6 = findViewById(R.id.tv6);
        tv_7 = findViewById(R.id.tv7);
        tv_8 = findViewById(R.id.tv8);
        tv_9 = findViewById(R.id.tv9);

    }

    public void salir(View view) {
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
        finish();
    }

    public void primer_boton(View view) {
        tv_1.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void segundo_boton(View view) {
        tv_2.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void tercer_boton(View view) {
        tv_3.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void cuarto_boton(View view) {
        tv_4.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void quinto_boton(View view) {
        tv_5.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void sexto_boton(View view) {
        tv_6.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void septimo_boton(View view) {
        tv_7.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void octavo_boton(View view) {
        tv_8.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    public void noveno_boton(View view) {
        tv_9.setText(letra_turno);
        cambiar_turno();
        determinar_ganador();
    }

    private void cambiar_turno() {
        if (turno) {
            turno = false;
            letra_turno = "O";
        } else {
            turno = true;
            letra_turno = "X";
        }
    }

    //funsion para determinar al ganador
    private void determinar_ganador() {
        //formas de ganar
        //-> 1 forma: p1 - p2 - p3 *
        if (tv_1.getText().toString().equals("X") && tv_2.getText().toString().equals("X") && tv_3.getText().toString().equals("X")){
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_1, tv_2, tv_3);
        } else if (tv_1.getText().toString().equals("O") && tv_2.getText().toString().equals("O") && tv_3.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_1, tv_2, tv_3);
        }

        //-> 2 forma: p1 - p4 - p7 *
        if (tv_1.getText().toString().equals("X") && tv_4.getText().toString().equals("X") && tv_7.getText().toString().equals("X")){
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_1, tv_4, tv_7);
        } else if (tv_1.getText().toString().equals("O") && tv_4.getText().toString().equals("O") && tv_7.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_1, tv_4, tv_7);
        }

        //-> 3 forma: p1 - p5 - p9 *
        if (tv_1.getText().toString().equals("X") && tv_5.getText().toString().equals("X") && tv_9.getText().toString().equals("X")){
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_1, tv_5, tv_9);
        } else if (tv_1.getText().toString().equals("O") && tv_5.getText().toString().equals("O") && tv_9.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_1, tv_5, tv_9);
        }

        //-> 4 forma: p3 - p5 - p7 *
        if (tv_3.getText().toString().equals("X") && tv_5.getText().toString().equals("X") && tv_7.getText().toString().equals("X")){
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_3, tv_5, tv_7);
        } else if (tv_3.getText().toString().equals("O") && tv_5.getText().toString().equals("O") && tv_7.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_3, tv_5, tv_7);
        }

        //-> 5 forma: p3 - p6 - p9 *
        if (tv_3.getText().toString().equals("X") && tv_6.getText().toString().equals("X") && tv_9.getText().toString().equals("X")){
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_3, tv_6, tv_9);
        } else if (tv_3.getText().toString().equals("O") && tv_6.getText().toString().equals("O") && tv_9.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_3, tv_6, tv_9);
        }

        //-> 6 forma: p7 - p8 - p9 *
        if (tv_7.getText().toString().equals("X") && tv_8.getText().toString().equals("X") && tv_9.getText().toString().equals("X")){
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_7, tv_8, tv_9);
        } else if (tv_7.getText().toString().equals("O") && tv_8.getText().toString().equals("O") && tv_9.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_7, tv_8, tv_9);
        }

        //-> 7 forma: p2 - p5 - p8
        if (tv_2.getText().toString().equals("X") && tv_5.getText().toString().equals("X") && tv_8.getText().toString().equals("X")) {
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_2, tv_5, tv_8);
        } else if (tv_2.getText().toString().equals("O") && tv_5.getText().toString().equals("O") && tv_8.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_2, tv_5, tv_8);
        }

        //-> 8 forma: p4 - p5 - p6
        if (tv_4.getText().toString().equals("X") && tv_5.getText().toString().equals("X") && tv_6.getText().toString().equals("X")) {
            Toast.makeText(this, "Has ganado X", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_X(tv_4, tv_5, tv_6);
        } else if (tv_4.getText().toString().equals("O") && tv_5.getText().toString().equals("O") && tv_6.getText().toString().equals("O")){
            Toast.makeText(this, "Has ganado O", Toast.LENGTH_SHORT).show();
            juego_terminado();
            pintar_botones_O(tv_4, tv_5, tv_6);
        }

    }

    public void restaurar(View view) {
        restaurar_casillas();
        turno = true;
        letra_turno = "X";
    }

    private void juego_terminado() {
        tv_1.setEnabled(false);
        tv_2.setEnabled(false);
        tv_3.setEnabled(false);
        tv_4.setEnabled(false);
        tv_5.setEnabled(false);
        tv_6.setEnabled(false);
        tv_7.setEnabled(false);
        tv_8.setEnabled(false);
        tv_9.setEnabled(false);
    }

    private void restaurar_casillas() {
        tv_1.setEnabled(true);
        tv_2.setEnabled(true);
        tv_3.setEnabled(true);
        tv_4.setEnabled(true);
        tv_5.setEnabled(true);
        tv_6.setEnabled(true);
        tv_7.setEnabled(true);
        tv_8.setEnabled(true);
        tv_9.setEnabled(true);

        tv_1.setText("");
        tv_2.setText("");
        tv_3.setText("");
        tv_4.setText("");
        tv_5.setText("");
        tv_6.setText("");
        tv_7.setText("");
        tv_8.setText("");
        tv_9.setText("");

        tv_1.setBackgroundColor(Color.WHITE);
        tv_2.setBackgroundColor(Color.WHITE);
        tv_3.setBackgroundColor(Color.WHITE);
        tv_4.setBackgroundColor(Color.WHITE);
        tv_5.setBackgroundColor(Color.WHITE);
        tv_6.setBackgroundColor(Color.WHITE);
        tv_7.setBackgroundColor(Color.WHITE);
        tv_8.setBackgroundColor(Color.WHITE);
        tv_9.setBackgroundColor(Color.WHITE);
    }

    private void pintar_botones_X(TextView tv1, TextView tv2, TextView tv3) {
        tv1.setBackgroundColor(Color.GREEN);
        tv2.setBackgroundColor(Color.GREEN);
        tv3.setBackgroundColor(Color.GREEN);
    }

    private void pintar_botones_O(TextView tv1, TextView tv2, TextView tv3) {
        tv1.setBackgroundColor(Color.RED);
        tv2.setBackgroundColor(Color.RED);
        tv3.setBackgroundColor(Color.RED);
    }

}
