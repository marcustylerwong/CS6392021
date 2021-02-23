package com.example.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        */
        view.findViewById(R.id.btn_sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment", "Button SMS clicked");
                Intent intentSMS = new Intent(Intent.ACTION_SENDTO);
                intentSMS.setData(Uri.parse("smsto: "+ Uri.encode("2123461200")));
                intentSMS.putExtra("sms_body", "Hello Friends!");
                startActivity(intentSMS);
            }
        });

        view.findViewById(R.id.btn_newact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment", "Button New Activity clicked");
                Intent intentNewActivity = new Intent(getActivity(), NewActivity.class);
                startActivity(intentNewActivity);
            }
        });

        view.findViewById(R.id.btn_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment", "Button Phone clicked");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:2123630830"));
                startActivity(intent);

            }
        });
        view.findViewById(R.id.btn_web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment", "Button Web clicked");
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(websiteIntent);
            }
        });

        view.findViewById(R.id.btn_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment", "Button Map clicked");
                String geoUri = String.format("geo:38.899533, -77.036476");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoMap);

            }
        });

        view.findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FirstFragment", "Button Share clicked");
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                intent.putExtra(Intent.EXTRA_TEXT,"Join CS 639");
                startActivity(Intent.createChooser(intent,"Share the love"));
            }
        });



    }
}
