package com.example.admin.beer.tabs;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Switch;
import android.content.pm.PackageManager;
import android.widget.TextView;

import com.example.admin.beer.R;

/**
 * Created by ADMIN on 3/1/2017.
 */
public class Tab4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_4, container, false);

        String url = "https://www.brewbound.com/";

        final WebView wv = (WebView)v.findViewById(R.id.webView);
        final Button switch1=(Button) v.findViewById(R.id.switch1);
        final TextView book=(TextView) v.findViewById(R.id.book);

        Button button = (Button) v.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                wv.setVisibility(v.INVISIBLE);
                switch1.setVisibility(v.VISIBLE);
                book.setVisibility(v.VISIBLE);


            }
        });


        Button button1 = (Button) v.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               wv.setVisibility(v.VISIBLE);
               switch1.setVisibility(v.INVISIBLE);
                book.setVisibility(v.INVISIBLE);
            }
        });

        switch1.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {
                PackageManager pm = getActivity().getPackageManager();
                try {
                    pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
                    String uri = "uber://?action=setPickup&pickup=my_location";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));
                    }
                }
            }
        });





        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        return v;
    }


}
