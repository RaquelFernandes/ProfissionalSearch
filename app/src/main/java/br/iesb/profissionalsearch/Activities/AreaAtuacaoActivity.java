package br.iesb.profissionalsearch.Activities;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    AreaAtuacaoRecycleViewAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_atuacao);

        RecyclerView recycle = (RecyclerView) findViewById(R.id.areaAtuacao_lista);
        recycleAdapter = new AreaAtuacaoRecycleViewAdapter(this, lst);
        recycle.setAdapter(recycleAdapter);
        recycle.setPadding(35, 0, 0, 0);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recycle.setLayoutManager(layout);

        listar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.salvar_pesquisa_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_formulario_ok) {
            Toast.makeText(this, "TESTE", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);

    }

    private void listar(){
        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference("area_atuacao");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lst.clear();
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
    }
}
