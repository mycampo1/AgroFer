package edu.unicauca.agrofer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TiendaFragment extends Fragment implements SearchView.OnQueryTextListener{

    List<ListElement> elements;
    private SearchView lySearch;


    public TiendaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tienda, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

        lySearch = view.findViewById(R.id.lySearch);

        elements = new ArrayList<>();
        elements.add(new ListElement("#008000", "DVA","4.5","https://dva.com.co/wp-content/uploads/2019/10/LOGO-DVA-fondo-azuL-200x200.jpg"));
        elements.add(new ListElement("#FFFF00", "El señor agro","3.8","https://elsenoragro.com.co/wp-content/uploads/2020/03/Logo-blanco-El-se%C3%B1or-agro-1.jpg"));
        elements.add(new ListElement("#FF0000", "Invesa","3.0","https://www.invesa.com/wp-content/uploads/2020/04/logo-invesa-150x66.png"));

        ListAdapter listAdapter = new ListAdapter(elements, this.getContext(), new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.recicleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(listAdapter);

        lySearch.setOnQueryTextListener(this);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<ListElement> filteredList = new ArrayList<>();
        for (ListElement item : elements) {
            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item);
            }
        }
        ListAdapter listAdapter = new ListAdapter(filteredList, this.getContext(), new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Bundle bundle = new Bundle();
                bundle.putString("name", elements.get(position).getName());
                Fragment fragment = new InfoTiendaFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();

            }
        });
        RecyclerView recyclerView = getView().findViewById(R.id.recicleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(listAdapter);
        return true;
    }
}
