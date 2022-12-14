package edu.unicauca.agrofer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin,btnGoogle, btnFacebook;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.bnSignGoogle);
        btnFacebook = findViewById(R.id.bnSignFacebook);


        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailLogin = email.getText().toString().trim();
                String passLogin = password.getText().toString().trim();

                if(!emailLogin.isEmpty() && !passLogin.isEmpty()){
                    login();
                }else {
                    Toast.makeText(LoginActivity.this, "Complete los campos",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void btnRegister(View view){
        Intent btnRegister = new Intent(this, RegisterActivity.class);
        startActivity(btnRegister);
    }

    public void btnDesarrollo(View view){
        if (view.getId() == btnGoogle.getId()){
            Toast.makeText(getApplicationContext(), "Boton Google en desarrollo", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == btnFacebook.getId()){
            Toast.makeText(getApplicationContext(), "Boton Facebook en desarrollo", Toast.LENGTH_SHORT).show();
        }
    }


    private void login(){

        String emailLogin = email.getText().toString();
        String passLogin = password.getText().toString();

        mAuth.signInWithEmailAndPassword(emailLogin, passLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Log.d("Campo","email"+emailLogin);
        Log.d("Campo","password"+passLogin);
    }

}