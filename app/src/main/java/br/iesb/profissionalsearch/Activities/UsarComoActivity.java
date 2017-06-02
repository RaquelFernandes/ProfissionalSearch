package br.iesb.profissionalsearch.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.iesb.profissionalsearch.R;

public class UsarComoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_como);

        TextView  cadastrar = (TextView) findViewById(R.id.login_cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsarComoActivity.this, CadastrarActivity.class));
            }
        });

    }
}
