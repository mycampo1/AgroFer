package edu.unicauca.agrofer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class InfoTiendaFragment extends Fragment {

    ImageView imageView, im1,im2,im3,im4,im5,im6;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_tienda, container, false);

        imageView = (ImageView) view.findViewById(R.id.imgViewDVA);
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;

        im1 = (ImageView) view.findViewById(R.id.pro1);
        im1.getLayoutParams().width = 450;
        im1.getLayoutParams().height = 600;

        im2 = (ImageView) view.findViewById(R.id.pro2);
        im2.getLayoutParams().width = 450;
        im2.getLayoutParams().height = 600;

        im3 = (ImageView) view.findViewById(R.id.pro3);
        im3.getLayoutParams().width = 450;
        im3.getLayoutParams().height = 600;

        im4 = (ImageView) view.findViewById(R.id.pro4);
        im4.getLayoutParams().width = 450;
        im4.getLayoutParams().height = 600;

        im5 = (ImageView) view.findViewById(R.id.pro5);
        im5.getLayoutParams().width = 450;
        im5.getLayoutParams().height = 600;

        im6 = (ImageView) view.findViewById(R.id.pro6);
        im6.getLayoutParams().width = 450;
        im6.getLayoutParams().height = 600;


        Glide.with(this).load("https://dva.com.co/wp-content/uploads/2019/10/LOGO-DVA-fondo-azuL-1000X1000.jpg").into(imageView);

        Glide.with(this).load("https://dva.com/wp-content/uploads/2020/11/CARPIDORA-41-SL-uai-516x516.jpg").into(im1);
        Glide.with(this).load("https://dva.com/wp-content/uploads/2020/11/CHOIQUE-200-SL-uai-516x516.jpg").into(im2);
        Glide.with(this).load("https://dva.com/wp-content/uploads/2020/11/ENTRON-40-uai-516x516.jpg").into(im3);
        Glide.with(this).load("https://dva.com/wp-content/uploads/2020/11/LUFKEN-nt-uai-516x516.jpg").into(im4);
        Glide.with(this).load("https://dva.com/wp-content/uploads/2020/11/NANTLI-EC-uai-516x516.jpg").into(im5);
        Glide.with(this).load("https://dva.com/wp-content/uploads/2020/11/SANIYA-480-SL-uai-516x516.jpg").into(im6);



        return view;

    }


}