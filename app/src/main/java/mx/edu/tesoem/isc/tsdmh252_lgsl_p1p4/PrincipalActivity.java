package mx.edu.tesoem.isc.tsdmh252_lgsl_p1p4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    EditText n1, n2;

    Button blsumar, blresta, blmulti, blpot, blpoN, blraiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //estos son EditText
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        //estos son los botones
        blsumar = findViewById(R.id.blsumar);
        blresta = findViewById(R.id.blresta);
        blmulti = findViewById(R.id.blmulti);
        blpot = findViewById(R.id.blpot);
        blpoN = findViewById(R.id.blpoN);
        blraiz = findViewById(R.id.blraiz);


    }

    public void onclicksumar(View view) {

        int v1 = Integer.parseInt(n1.getText().toString());
        int v2 = Integer.parseInt(n2.getText().toString());


        int resultado = v1 + v2;


        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("resultado", String.valueOf(resultado));
        startActivity(intent);

    }

    public void onclickrestar(View view) {

        int v1 = Integer.parseInt(n1.getText().toString());
        int v2 = Integer.parseInt(n2.getText().toString());
        int resultado = v1 - v2;

        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("resultado", String.valueOf(resultado));
        startActivity(intent);
    }

    public void onclickmultiplicar(View view) {

        int v1 = Integer.parseInt(n1.getText().toString());
        int v2 = Integer.parseInt(n2.getText().toString());
        int resultado = v1 * v2;


        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("resultado", String.valueOf(resultado));
        startActivity(intent);
    }

    public void onclickdividir(View view) {
        int v1 = Integer.parseInt(n1.getText().toString());
        int v2 = Integer.parseInt(n2.getText().toString());

        if (v2 == 0) {

            Intent intent = new Intent(this, ResultadosActivity.class);
            intent.putExtra("resultado", "Error: No se puede dividir entre 0");
            startActivity(intent);
        } else {

            double resultado = (double) v1 / (double) v2;

            Intent intent = new Intent(this, ResultadosActivity.class);
            intent.putExtra("resultado", String.valueOf(resultado));
            startActivity(intent);
        }
    }

    public void onclickraiz(View view) {

        int v1 = Integer.parseInt(n1.getText().toString());

        if (v1 < 0) {
            Intent intent = new Intent(this, ResultadosActivity.class);
            intent.putExtra("resultado", "Error: No se puede calcular la raíz de un número negativo");
            startActivity(intent);
        } else {

            double resultado = Math.sqrt(v1);

            Intent intent = new Intent(this, ResultadosActivity.class);
            intent.putExtra("resultado", String.valueOf(resultado));
            startActivity(intent);
        }
    }

    public void onclickcuadrado(View view) {

        int v1 = Integer.parseInt(n1.getText().toString());
        int resultado = v1 * v1;

        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("resultado", String.valueOf(resultado));
        startActivity(intent);
    }

    public void onclickpotencia(View view) {

        double base = Double.parseDouble(n1.getText().toString());
        double exponente = Double.parseDouble(n2.getText().toString());
        double resultado = Math.pow(base, exponente);

        Intent intent = new Intent(this, ResultadosActivity.class);
        intent.putExtra("resultado", String.valueOf(resultado));
        startActivity(intent);
    }

}
