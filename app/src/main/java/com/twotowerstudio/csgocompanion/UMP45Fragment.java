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
 * Use the {@link UMP45Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UMP45Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GifImageView ump45Spray, ump45Curve;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public UMP45Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UMP45Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UMP45Fragment newInstance(String param1, String param2) {
        UMP45Fragment fragment = new UMP45Fragment();
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
        View view = inflater.inflate(R.layout.fragment_ump45, container, false);
        //height of image divided by width, added manually and must change for each different fragment
        double ratio = 1.638728;
        ump45Spray = (GifImageView) view.findViewById(R.id.ump45Spray);
        ump45Curve = (GifImageView) view.findViewById(R.id.ump45Curve);

        //get a LayoutParams object for one of the views, and assuming both images have equal resolution, then we only need one for both
        ViewGroup.LayoutParams ump45Params = (ViewGroup.LayoutParams) ump45Spray.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //sets the attributes we want for height and width. The ratio
        ump45Params.width= (metrics.widthPixels/2);
        ump45Params.height = (int)((metrics.widthPixels/2)*ratio);

        ump45Spray.setLayoutParams(ump45Params);
        ump45Curve.setLayoutParams(ump45Params);
        return view;
    }

}
