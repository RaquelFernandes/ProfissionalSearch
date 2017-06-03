package br.iesb.profissionalsearch.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import br.iesb.profissionalsearch.R;

public class CadastrarActivity extends AppCompatActivity {

    private DatabaseReference database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        cadastrar();
    }

    private void cadastrar() {

        auth = FirebaseAuth.getInstance();

        final EditText txtEmail = (EditText) findViewById(R.id.cadastrar_txtEmail);
        final EditText txtSenha = (EditText) findViewById(R.id.cadastrar_txtSenha);

        Button btnSalvar = (Button) findViewById(R.id.cadastrar_btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString())
                    .addOnCompleteListener(CadastrarActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(CadastrarActivity.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                                finish();

                            } else {
                                Toast.makeText(CadastrarActivity.this, "Erro ao ser cadastrado", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });

    }
}
