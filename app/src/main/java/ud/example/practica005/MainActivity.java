package ud.example.practica005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import Clases.Bebida;
import Clases.Hamburguesa;

public class MainActivity extends AppCompatActivity {

    private EditText cliente;
    private Spinner lista01;
    private Spinner lista02;
    private Spinner lista03, lista04, lista05;
    private CheckBox hielo;
    private Button enviab;
    private List<String> tipoh;
    private List<String> tipob;
    private List<String> sino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliente = (EditText) findViewById(R.id.editText);
        lista01 = (Spinner) findViewById(R.id.spinner);
        lista02 = (Spinner) findViewById(R.id.spinner2);
        lista03 = (Spinner) findViewById(R.id.spinner3);
        lista04 = (Spinner) findViewById(R.id.spinner4);
        lista05 = (Spinner) findViewById(R.id.spinner5);
        hielo = (CheckBox) findViewById(R.id.checkBox);
        enviab = (Button) findViewById(R.id.button);
        datosinicio();
    }//Cierre del metodo OnCreate

    public void datosinicio(){
        List<String> tipoh = new ArrayList<>();
        //List<String> tipob = new ArrayList<>();
        List<String> sino = new ArrayList<>();
        tipoh.add("Carne");
        tipoh.add("Pollo");
        tipoh.add("Pescado");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tipoh);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista01.setAdapter(adaptador);
        sino.add("Si");
        sino.add("No");
        ArrayAdapter<String> adaptador02 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, sino);
        adaptador02.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista02.setAdapter(adaptador02);
    }//Cierre datos inicio


    public void llamaractividad(View v){
        boolean cebolla = false;
        String cantham, cantbeb;
        if(TextUtils.isEmpty(cliente.getText().toString())){
            cliente.setError("Debe digitar el nombre del cliente.");
        }
        else{
            if(lista02.getSelectedItem().toString().equals("Si")) cebolla = true;
            cantham = lista04.getSelectedItem().toString();
            cantbeb = lista05.getSelectedItem().toString();
            Hamburguesa miham = new Hamburguesa(lista01.getSelectedItem().toString(), cebolla, cantham);
            boolean hielo = this.hielo.isChecked();
            Bebida mibeb = new Bebida(lista03.getSelectedItem().toString(), hielo, lista05.getSelectedItem().toString());
            Intent int01 = new Intent (this, MainActivity2.class);
            int01.putExtra("CLIENTE", cliente.getText().toString());
            int01.putExtra("HAMBURGUESA", miham);
            int01.putExtra("BEBIDA", mibeb);
            startActivity(int01);
        }

    } //Cierre de llamaractividad


}// cierre metodo ppal