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
        elements.add(new ListElement("#775447", "Tienda agro","4.8",""));
        elements.add(new ListElement("#FFE900", "Electroluz","5.0","https://comerciodecolombia.com/wp-content/uploads/electrl20201.jpg"));

        ListAdapter listAdapter = new ListAdapter(elements, this.getContext());
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
        ListAdapter listAdapter = new ListAdapter(filteredList, this.getContext());
        RecyclerView recyclerView = getView().findViewById(R.id.recicleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(listAdapter);
        return true;
    }
}