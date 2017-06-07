package br.iesb.profissionalsearch.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import br.iesb.profissionalsearch.R;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configuraAuthStateListener();

        TextView  cadastrar = (TextView) findViewById(R.id.login_cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastrarActivity.class));
            }
        });
        Button btnlogin = (Button) findViewById(R.id.login_btnEntrar);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticacao();
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            auth.removeAuthStateListener(mAuthListener);
        }
    }

    //Coloquei esse trecho para evitar autenticações desnecessárias
    private void configuraAuthStateListener() {
        auth = FirebaseAuth.getInstance();
        
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Bem-vindo", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, UsarComoActivity.class));
                    finish();
                } else {

                }
                // ...
            }
        };
        auth.addAuthStateListener(mAuthListener);
    }

    private void autenticacao() {

        final EditText txtEmail = (EditText) findViewById(R.id.login_txtEmail);
        final EditText txtSenha = (EditText) findViewById(R.id.login_txtSenha);

        auth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString())
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Bem-vindo", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, UsarComoActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Erro na autentcação", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

