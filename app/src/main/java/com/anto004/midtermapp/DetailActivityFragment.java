package com.anto004.midtermapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {


    public static final String LOG_TAG = "DetailFragement";
    public static final String DETAIL_NAME = "detailName";
    public static final String OS = "os";
    public static final String HEIGHT = "height";
    public static final String WIDTH = "width";
    public static final String DETAIL_IMAGE = "detailImage";
    public static final String OPINION = "opinion";


    TextView detailNameTV;
    TextView osTV;
    TextView heightTV;
    TextView widthTV;
    ImageView detailIV;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        detailNameTV = getActivity().findViewById(R.id.detail_name_textView);
        osTV = getActivity().findViewById(R.id.os_value_textView);
        heightTV = getActivity().findViewById(R.id.height_value_textView);
        widthTV = getActivity().findViewById(R.id.width_value_textView);
        detailIV = getActivity().findViewById(R.id.detail_image);
        Button doneButton = getActivity().findViewById(R.id.done_button);
        final CheckBox likeCheckBox = getActivity().findViewById(R.id.like_checkbox);


        setValuesFromIntent();

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(OPINION, likeCheckBox.isChecked());
                getActivity().setResult(RESULT_OK, data);
                getActivity().finish();
            }
        });

    }

    private void setValuesFromIntent(){
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle == null){
            return;
        }

        String detailName = bundle.getString(DETAIL_NAME);
        String os = bundle.getString(OS);
        String width = bundle.getString(WIDTH);
        String height = bundle.getString(HEIGHT);
        int imageID = bundle.getInt(DETAIL_IMAGE, -1);

        detailNameTV.setText(!TextUtils.isEmpty(detailName) ? detailName : "Unknown");
        osTV.setText(!TextUtils.isEmpty(os) ? os : "Unknown");
        heightTV.setText(!TextUtils.isEmpty(height) ? height : "Unknown");
        widthTV.setText(!TextUtils.isEmpty(width) ? width : "Unknown");
        if(imageID > - 1){
            detailIV.setImageResource(imageID);
        }

    }
}
