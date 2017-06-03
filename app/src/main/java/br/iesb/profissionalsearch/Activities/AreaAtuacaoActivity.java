package br.iesb.profissionalsearch.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.iesb.profissionalsearch.Adapter.AreaAtuacaoRecycleViewAdapter;
import br.iesb.profissionalsearch.Models.AreaAtuacao;
import br.iesb.profissionalsearch.R;

public class AreaAtuacaoActivity extends AppCompatActivity {

    DatabaseReference database;
    FirebaseDatabase firebase;
    ArrayList<AreaAtuacao> lst = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_atuacao);

        listar();

    }

    private void listar(){
        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference("area_atuacao");
        Log.d("db", database.toString());

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot c : dataSnapshot.getChildren()) {
                    AreaAtuacao areaAtuacao = c.getValue(AreaAtuacao.class);
                    lst.add(areaAtuacao);
                }
                AreaAtuacaoRecycleViewAdapter recycle = new AreaAtuacaoRecycleViewAdapter(AreaAtuacaoActivity.this, lst);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
