package com.example.sachinrajput.restretrofit_withrecyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sachinrajput.restretrofit_withrecyclerview.R;
import com.example.sachinrajput.restretrofit_withrecyclerview.pojo.Data;
import com.example.sachinrajput.restretrofit_withrecyclerview.pojo.DataItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by SachinRajput on 4/26/2020.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
      ArrayList<DataItems>dataArrayList;
    public RecyclerViewAdapter(ArrayList<DataItems> dataArrayList) {
        this.dataArrayList=dataArrayList;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.indiview,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
           DataItems dataitems=dataArrayList.get(position);
          holder.lastName.setText(dataitems.getLast_name());
          holder.firstname.setText(dataitems.getFirst_name());
          holder.id.setText(dataitems.getId());
          holder.email.setText(dataitems.getEmail());
         //use picasso liabrary to retrive the image
        Picasso.with(holder.avatar_img.getContext()).load(dataitems.getAvatar()).into(holder.avatar_img);



    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView id,email,firstname,lastName;
        ImageView avatar_img;

        public MyHolder(View itemView) {
            super(itemView);

            id=(TextView)itemView.findViewById(R.id.ids);
            email=(TextView)itemView.findViewById(R.id.mailids);
            firstname=(TextView)itemView.findViewById(R.id.firstname);
            lastName=(TextView)itemView.findViewById(R.id.lastname);
            avatar_img=(ImageView)itemView.findViewById(R.id.avtar_image);



        }


}

}
