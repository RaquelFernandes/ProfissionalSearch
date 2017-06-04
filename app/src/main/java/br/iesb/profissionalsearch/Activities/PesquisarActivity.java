package br.iesb.profissionalsearch.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.iesb.profissionalsearch.Models.AreaAtuacao;
import br.iesb.profissionalsearch.R;

public class PesquisarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        Button btnAreaAtuacao = (Button) findViewById(R.id.pesquisar_btnAreaAtuacao);
        btnAreaAtuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PesquisarActivity.this, AreaAtuacaoActivity.class));
            }
        });

        Button btnEstado = (Button) findViewById(R.id.pesquisar_btnEstado);
        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PesquisarActivity.this, EstadoActivity.class));
            }
        });

        Button btnTipoServico = (Button) findViewById(R.id.pesquisar_btnTipoServico);
        btnTipoServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PesquisarActivity.this, TipoServicoActivity.class));
            }
        });

    }
}
