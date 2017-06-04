package br.iesb.profissionalsearch.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.iesb.profissionalsearch.Models.AreaAtuacao;
import br.iesb.profissionalsearch.R;

public class UsarComoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_como);

        Button btnProcurar = (Button) findViewById(R.id.usarComo_btnProcurarProfissional);
        btnProcurar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsarComoActivity.this, AreaAtuacaoActivity.class));
            }

        });

        Button btnEntrarProfissional = (Button) findViewById(R.id.usarComo_btnEntrarProfissional);
        btnEntrarProfissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsarComoActivity.this, PerfilActivity.class));
            }
        });

        Button btnBatePapo = (Button) findViewById(R.id.usarComo_btnBatePapo);
        btnBatePapo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsarComoActivity.this, BatePapoActivity.class));
            }
        });
    }
}
