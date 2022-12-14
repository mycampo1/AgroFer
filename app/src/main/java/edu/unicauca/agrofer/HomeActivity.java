package edu.unicauca.agrofer;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentUser, fragmentTienda, fragmentCanasta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentUser = new UserFragment();
        fragmentTienda = new TiendaFragment();
        fragmentCanasta = new canastaFragment();

        //getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmentUser).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmentTienda).commit();
    }

    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId())
        {
            case R.id.btnUser:transaction.replace(R.id.contenedor, fragmentUser);
                transaction.addToBackStack(null);
                break;

            case R.id.btnTienda:transaction.replace(R.id.contenedor, fragmentTienda);
                transaction.addToBackStack(null);
                break;

            case R.id.btnCanastas:transaction.replace(R.id.contenedor, fragmentCanasta);
                transaction.addToBackStack(null);
                break;
        }
        transaction.commit();
    }
}