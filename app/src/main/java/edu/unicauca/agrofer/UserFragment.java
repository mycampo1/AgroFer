package edu.unicauca.agrofer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

public class UserFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle saveInstanceState){
        super.onViewCreated(view, saveInstanceState);


        //Iniciar sesión con Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

//Obtener referencia a la colección
        FirebaseFirestore db = FirebaseFirestore.getInstance();

//Obtener referencia al documento del usuario
        DocumentReference docRef = db.collection("user").document(mAuth.getCurrentUser().getUid());

//Obtener los datos del usuario
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    //Obtener los TextViews
                    TextView usNombre = view.findViewById(R.id.usNombre);
                    TextView usApellido = view.findViewById(R.id.usApellido);
                    TextView usEmail = view.findViewById(R.id.usEmail);
                    TextView usPass = view.findViewById(R.id.usPass);

                    //Establecer el texto de los TextViews
                    usNombre.setText(document.getString("name"));
                    usApellido.setText(document.getString("surname"));
                    usEmail.setText(document.getString("email"));
                    usPass.setText(document.getString("password"));
                }
            }
        });

    }

}