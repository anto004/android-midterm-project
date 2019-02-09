package com.anto004.midtermapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView nameTV = getActivity().findViewById(R.id.name_textview);
        Button getInfoButton = getActivity().findViewById(R.id.get_info_button);
        ImageView tabletIV = getActivity().findViewById(R.id.tablet_imageView);
        ImageView heartIV = getActivity().findViewById(R.id.heart_image_view);

        tabletIV.setImageResource(R.drawable.xperia_z_main_image);

        getInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivityFragment.DETAIL_NAME, "XPERIA-Z");
                intent.putExtra(DetailActivityFragment.OS, "Windows");
                intent.putExtra(DetailActivityFragment.WIDTH, "1920");
                intent.putExtra(DetailActivityFragment.HEIGHT, "1200");
                intent.putExtra(DetailActivityFragment.DETAIL_IMAGE, R.drawable.xperia_z_detail_image_copy);
                startActivity(intent);
            }
        });
    }
}
