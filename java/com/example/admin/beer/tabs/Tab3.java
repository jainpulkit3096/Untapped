package com.example.admin.beer.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.admin.beer.CustomListAdaptor;

import com.example.admin.beer.MapsActivity;
import com.example.admin.beer.MapsActivity2;
import com.example.admin.beer.MapsActivity3;
import com.example.admin.beer.MapsActivity4;
import com.example.admin.beer.R;

/**
 * Created by ADMIN on 3/1/2017.
 */
public class Tab3 extends Fragment {




    private ListView listView;
    ListAdapter adapter;

    ArrayAdapter<String> listadapter;

    Integer[] imgid = {
            R.drawable.image1,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image2,

    };

    String headings[] = {
            "Nearby Verified Venues",
            "Nearby Bars",
            "Nearby Liquor store",
            "Nearby night club",
            "Nearby Events",

    };



    String about[] = {
            "All the exotic venues nearby",
            "Bars are always fun, find few",
            "Who doesn't like a cheap chilled beer.Search a liquor store nearby",
            "Every night is saturday night.Find super clubs near you",
            "Super-fun events near you.",

    };

    String urls[] = {
            "http://blog.myfitnesspal.com/health-benefits-of-avocado/",
            "http://blog.myfitnesspal.com/12-healthy-foods-fill-best/",
            "http://blog.myfitnesspal.com/intense-25-minute-workout-get-harder/",
            "http://blog.myfitnesspal.com/mashed-avocado-egg-salad/",
            "http://blog.myfitnesspal.com/12-ways-to-turn-a-rotisserie-chicken-into-a-weeks-worth-of-meals/",

    };


    public Tab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rowView = inflater.inflate(R.layout.tab_3, container, false);

        listView = (ListView) rowView.findViewById(R.id.mainlistview);

        adapter = new CustomListAdaptor(getActivity(), headings, about, imgid);
        //Assign Above Array Adapter to ListView
        listView.setAdapter(adapter);
        //Create ListView Item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              if(position==0) {

                  Intent viewIntent = new Intent(getActivity(),MapsActivity.class);
                  startActivity(viewIntent);
              }

                if(position ==1)
                {
                    Intent viewIntent = new Intent(getActivity(),MapsActivity2.class);
                    startActivity(viewIntent);
                }

                if(position ==2)
                {
                    Intent viewIntent = new Intent(getActivity(),MapsActivity3.class);
                    startActivity(viewIntent);
                }

                if(position ==3)
                {
                    Intent viewIntent = new Intent(getActivity(),MapsActivity4.class);
                    startActivity(viewIntent);
                }
            }
        });
        return rowView;


    }

}
