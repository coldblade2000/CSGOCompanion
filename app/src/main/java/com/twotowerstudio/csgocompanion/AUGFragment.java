package com.twotowerstudio.csgocompanion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AUGFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AUGFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GifImageView augSpray,augCurve;
    public AUGFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AUGFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AUGFragment newInstance(String param1, String param2) {
        AUGFragment fragment = new AUGFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aug, container, false);
        //height of image divided by width, added manually and must change for each different fragment
        double ratio = 1.573232;
        
        augCurve = (GifImageView) view.findViewById(R.id.augCurve);
        augSpray = (GifImageView) view.findViewById(R.id.augSpray);

        //get a LayoutParams object for one of the views, and assuming both images have equal resolution, then we only need one for both
        ViewGroup.LayoutParams augParams = (ViewGroup.LayoutParams) augSpray.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //sets the attributes we want for height and width. The ratio
        augParams.width= (metrics.widthPixels/2);
        augParams.height = (int)((metrics.widthPixels/2)*ratio);

        augSpray.setLayoutParams(augParams);
        augCurve.setLayoutParams(augParams);
        return view;
    }

}
