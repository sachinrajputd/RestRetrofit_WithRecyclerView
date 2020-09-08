package com.example.sachinrajput.restretrofit_withrecyclerview.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by SachinRajput on 4/26/2020.
 */

public class Data {
     @SerializedName("data")
    ArrayList<DataItems>dataItemses=new ArrayList<>();

    public ArrayList<DataItems> getDataItemses() {
        return dataItemses;
    }

    public void setDataItemses(ArrayList<DataItems> dataItemses) {
        this.dataItemses = dataItemses;
    }


}
