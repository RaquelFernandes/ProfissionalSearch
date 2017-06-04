package br.iesb.profissionalsearch.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.iesb.profissionalsearch.Adapter.AreaAtuacaoRecycleViewAdapter;
import br.iesb.profissionalsearch.Models.AreaAtuacao;
import br.iesb.profissionalsearch.Models.Estado;
import br.iesb.profissionalsearch.Models.TipoServico;
import br.iesb.profissionalsearch.R;

public class TipoServicoActivity extends AppCompatActivity {

    DatabaseReference database;
    FirebaseDatabase firebase;
    ArrayList<TipoServico> lst = new ArrayList<>();
    AreaAtuacaoRecycleViewAdapter recycleAdapter = new AreaAtuacaoRecycleViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_servico);

        listar();
    }

    private void listar(){

        final List<AreaAtuacao> lista = new ArrayList<>();

        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference("tipo_servico");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot c : dataSnapshot.getChildren()) {
                    TipoServico tipoServico = c.getValue(TipoServico.class);
                    Log.d(" cc ", tipoServico.toString());
                    Log.d(" cc ", c.getValue().toString());
                    lst.add(tipoServico);
                }
                recycleAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(lista.size() == 0 ){

            lista.add(new AreaAtuacao (1, "Otimização de aplicaçoes"));
            lista.add(new AreaAtuacao (2, "Renegociação de dívidas"));
        }

        RecyclerView recycle = (RecyclerView) findViewById(R.id.tipoServico_lista);
        recycle.setAdapter(new AreaAtuacaoRecycleViewAdapter(this, lista));
        recycle.setPadding(35, 0, 0, 0);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recycle.setLayoutManager(layout);
    }
}
