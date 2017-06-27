package br.iesb.profissionalsearch.Activities;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.iesb.profissionalsearch.Adapter.AreaAtuacaoRecycleViewAdapter;
import br.iesb.profissionalsearch.Models.AreaAtuacao;
import br.iesb.profissionalsearch.R;

public class AreaAtuacaoActivity extends AppCompatActivity {

    DatabaseReference database;
    FirebaseDatabase firebase;
    ArrayList<AreaAtuacao> lst = new ArrayList<>();
    AreaAtuacaoRecycleViewAdapter recycleAdapter = new AreaAtuacaoRecycleViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_area_atuacao);

        listar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.salvar_pesquisa_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void listar(){

        final List<AreaAtuacao> lista = new ArrayList<>();

        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference("area_atuacao");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot c : dataSnapshot.getChildren()) {
                    AreaAtuacao areaAtuacao = c.getValue(AreaAtuacao.class);
                    Log.d(" aa ", areaAtuacao.toString());
                    Log.d(" aa ", c.getValue().toString());
                    lst.add(areaAtuacao);
                }
                recycleAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(lista.size() == 0 ){

            lista.add(new AreaAtuacao (1, "Administração"));
            lista.add(new AreaAtuacao (2, "Financeira"));
            lista.add(new AreaAtuacao (3, "TI"));
        }
        RecyclerView recycle = (RecyclerView) findViewById(R.id.areaAtuacao_lista);
        recycle.setAdapter(new AreaAtuacaoRecycleViewAdapter(this, lista));
        recycle.setPadding(35, 0, 0, 0);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recycle.setLayoutManager(layout);
    }
}
