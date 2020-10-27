package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String NumeroAntiguo="";
    String OP="+";
    boolean Operacion=true;
    EditText edl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edl=findViewById(R.id.CResultado);
    }

    public void Clic(View view){
        if(Operacion)
            edl.setText("");
        Operacion=false;
        String number = edl.getText().toString();
        Button Boton = (Button)view;
        number +=Boton.getText().toString();
        edl.setText(number);

    }
    public void EventoDeOperador(View view){
        Operacion=true;
        NumeroAntiguo = edl.getText().toString();
        switch (view.getId()){
            case R.id.CDivision: OP="/"; break;
            case R.id.CMultiplicacion: OP="*"; break;
            case R.id.CSuma: OP="+"; break;
            case R.id.CResta: OP="-"; break;
        }
    }
    public void EventoResultado(View view){
        String Final = edl.getText().toString();
        Double Resultado = 0.0;
        switch (OP){
            case "+":
                Resultado=Double.parseDouble(NumeroAntiguo)+Double.parseDouble(Final);
                break;
            case "-":
                Resultado=Double.parseDouble(NumeroAntiguo)-Double.parseDouble(Final);
                break;
            case "*":
                Resultado=Double.parseDouble(NumeroAntiguo)*Double.parseDouble(Final);
                break;
            case "/":
                Resultado=Double.parseDouble(NumeroAntiguo)/Double.parseDouble(Final);
                break;
        }
        edl.setText(Resultado+"");
    }
    public void EventoLimpiar(View view) {
        edl.setText("");
        Operacion=true;
    }
}