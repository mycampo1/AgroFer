package edu.unicauca.agrofer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;

    }
    @Override
    public int getItemCount(){ return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItem(List<ListElement> items) { mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iconStar, imgPrincipal;
        TextView name, puntaje;

        ViewHolder(View itemView){
            super(itemView);
            imgPrincipal = itemView.findViewById((R.id.imgPrincipal));
            name = itemView.findViewById(R.id.nameTV);
            puntaje = itemView.findViewById(R.id.puntajeTV);
            iconStar = itemView.findViewById(R.id.estrella);
        }

        void bindData(final  ListElement item){


            iconStar.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);

            name.setText(item.getName());
            puntaje.setText(item.getPuntaje());
        }
    }
}
