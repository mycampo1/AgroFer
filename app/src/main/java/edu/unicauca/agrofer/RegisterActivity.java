package edu.unicauca.agrofer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    /*Button btn_register;
    EditText name, email, password;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;*/

    Button btnCrear;
    EditText name, surname, email, password, confPassword;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.ctaName);
        surname = findViewById(R.id.ctaSurname);
        email = findViewById(R.id.ctaCorreo);
        password = findViewById(R.id.ctaContrasenia);
        confPassword = findViewById(R.id.ctaConfContrasenia);
        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameUser = name.getText().toString().trim();
                String surnameUser = surname.getText().toString().trim();
                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();
                String confPassUser = confPassword.getText().toString().trim();

                if(!nameUser.isEmpty() && !surnameUser.isEmpty() && !emailUser.isEmpty() && !passUser.isEmpty() && !confPassUser.isEmpty()){
                    if(validarEmail(emailUser)){
                        if(passUser.equals(confPassUser)){
                            if(passUser.length() >= 6){
                                registerUser(nameUser, surnameUser,emailUser,passUser,confPassUser);
                            }else{
                                Toast.makeText(RegisterActivity.this, "La contraseña debe tener 6 caracteres",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "La contraseña no coincide",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Email invalido",Toast.LENGTH_LONG).show();
                    }



                }else {
                    Toast.makeText(RegisterActivity.this, "Complete los datos",Toast.LENGTH_LONG).show();
                    //Toast.makeText(RegisterActivity.this, "",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
    //Toast.makeText(RegisterActivity.this, "",Toast.LENGTH_LONG).show();
    private void registerUser(String nameUser, String surnameUser, String emailUser, String passUser, String confPassUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", nameUser);
                map.put("surname", surnameUser);
                map.put("email", emailUser);
                map.put("password", passUser);
                map.put("confPassword", confPassUser);

                mFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        Toast.makeText(RegisterActivity.this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error al registrar",Toast.LENGTH_LONG).show();

            }
        });
    }

    public boolean validarEmail(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}