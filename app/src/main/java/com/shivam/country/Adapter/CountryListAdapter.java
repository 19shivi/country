package com.shivam.country.Adapter;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.util.Preconditions;
import java.io.File;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shivam.country.MainActivity;
import com.shivam.country.R;
import com.shivam.country.model.Country;
import com.shivam.country.model.Languages;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {
    private List<Country> countries=new ArrayList<>();
    private Context context;

  public   CountryListAdapter(Context context,List<Country> countries)
    {
        this.context=context;
        this.countries=countries;


    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.country, parent, false);
        return new CountryListAdapter.ViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.setIsRecyclable(false);
        holder.name.setText(countries.get(position).getName());
        holder.capital.setText(countries.get(position).getCapital());
        holder.region.setText(countries.get(position).getRegion());
        holder.subregion.setText(countries.get(position).getSubregion());
        holder.border.setText("Borders : "+countries.get(position).getBorders().toString());
        String l="";
        for(Languages  i :countries.get(position).getLanguages())
            l+=" "+i.getName();
        holder.languages.setText("Languages : "+l);
        holder.population.setText(Integer.toString(countries.get(position).getPopulation()));

        Utils.fetchSvg(context, countries.get(position).getFlag(), holder.flag);
    }



    @Override
    public int getItemCount() {
        return countries.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView capital;
        public TextView population;
        public TextView region;
        public TextView subregion;
        public ImageView flag;
        public TextView border;
        public TextView languages;
        public ViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.Name);
            this.capital = itemView.findViewById(R.id.capital);
            this.population = itemView.findViewById(R.id.population);
            this.region = itemView.findViewById(R.id.region);
            this.subregion = itemView.findViewById(R.id.subregion);
            this.flag=itemView.findViewById(R.id.image);
            this.border = itemView.findViewById(R.id.border);
            this.languages = itemView.findViewById(R.id.languages);
        }
    }
    public void  SetList(List<Country> l)
    {
        countries=l;
        notifyDataSetChanged();
    }
}
