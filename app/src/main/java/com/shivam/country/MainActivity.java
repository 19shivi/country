package com.shivam.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.lifecycle.Observer;
import com.shivam.country.Adapter.CountryListAdapter;
import com.shivam.country.model.Country;
import com.shivam.country.viewModel.CountryListModelView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
       CountryListAdapter adapter;
     List<Country> list;
     CountryListModelView viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recyclerview) ;
        LinearLayoutManager linearLayoutManager=new  LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter= new CountryListAdapter(this,new ArrayList<>());
        recyclerView.setAdapter(adapter);

        viewModel= new ViewModelProvider(this).get(CountryListModelView.class);

        viewModel.DataObserver().observe(this, new Observer<List<Country>>(){
            @Override
            public void onChanged(List<Country> t) {
                if(t!=null) {
                    list = t;

                            adapter.SetList(t);
                    Log.v("size", t.toString());
                }
            }
        });
        viewModel.getAllCountries();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete:
                viewModel.delete();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}