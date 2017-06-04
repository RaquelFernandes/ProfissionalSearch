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
import br.iesb.profissionalsearch.R;

public class EstadoActivity extends AppCompatActivity {

    DatabaseReference database;
    FirebaseDatabase firebase;
    ArrayList<Estado> lst = new ArrayList<>();
    AreaAtuacaoRecycleViewAdapter recycleAdapter = new AreaAtuacaoRecycleViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado);

        listar();
    }

    private void listar(){

        final List<AreaAtuacao> lista = new ArrayList<>();

        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference("estados");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot c : dataSnapshot.getChildren()) {
                    Estado estado = c.getValue(Estado.class);
                    Log.d(" bb ", estado.toString());
                    Log.d(" bb ", c.getValue().toString());
                    lst.add(estado);
                }
                recycleAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(lista.size() == 0 ){

            lista.add(new AreaAtuacao (1, "Goias"));
            lista.add(new AreaAtuacao (2, "DF"));
        }

        RecyclerView recycle = (RecyclerView) findViewById(R.id.estado_lista);
        recycle.setAdapter(new AreaAtuacaoRecycleViewAdapter(this, lista));
        recycle.setPadding(35, 0, 0, 0);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recycle.setLayoutManager(layout);
    }

}
