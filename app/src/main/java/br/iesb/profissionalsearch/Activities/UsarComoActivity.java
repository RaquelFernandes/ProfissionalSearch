package br.iesb.profissionalsearch.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.iesb.profissionalsearch.R;

public class UsarComoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_como);
    }

    private void autenticar(){

        EditText txtEmail = (EditText) findViewById(R.id.login_txtEmail);
        EditText txtSenha = (EditText) findViewById(R.id.login_txtSenha);



        Button btnEntrar = (Button) findViewById(R.id.login_btnEntrar);

    }

}
