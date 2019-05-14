package com.example.taller_6.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taller_6.Entities.Serie;
import com.example.taller_6.R;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyViewHolder>  {

    private Context context;
    private List<Serie> seriesList;
    private FragmentManager fragmentManager;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView serieImage;
        public TextView serieName;
        private View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.serieImage = itemView.findViewById(R.id.serie_image);
            this.serieName = itemView.findViewById(R.id.serie_title);
            this.view = itemView;
        }
    }

    public SeriesAdapter(Context context) {
        this.context = context;
        this.seriesList = Serie.prepareSeries(
                context.getResources().obtainTypedArray(R.array.seriesImages),
                context.getResources().getStringArray(R.array.seriesNames)
        );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.series_item, parent, false);

        return new MyViewHolder(view);
    }

    private void loadSerieDetail(int id, FragmentManager manager, Serie newSerie){

        Bundle bundle = new Bundle();
        bundle.putSerializable("SERIE", newSerie);



    }
}
