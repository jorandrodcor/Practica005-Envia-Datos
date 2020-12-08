package ud.example.practica005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import Clases.Bebida;
import Clases.Hamburguesa;

public class MainActivity2 extends AppCompatActivity {

    private TextView logTextView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logTextView = findViewById(R.id.textView10);
        scrollView = findViewById(R.id.scrollView);
        Bundle bundle = this.getIntent().getExtras();
        log("Cliente: " +bundle.getString("CLIENTE"));
        log("");
        Hamburguesa mipedham = (Hamburguesa) bundle.get("HAMBURGUESA");
        Bebida mipedbeb = (Bebida) bundle.get("BEBIDA");

        log("Hamburguesa");
        log("Tipo: "+mipedham.getTipo());
        log("Cantidad: "+mipedham.getCantHam());
        if(mipedham.getCebolla()) log("Con cebolla");
        else log("Sin Cebolla");

        log("");
        log("Bebida");
        log("Tipo: "+mipedbeb.getTipo());
        log("Cantidad: "+mipedbeb.getCantBeb());
        if(mipedbeb.getHielo()) log("Sin hielo");
        else log("Con hielo");
    }


    public void log(String s){
        logTextView.append("\n"+s);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }



}