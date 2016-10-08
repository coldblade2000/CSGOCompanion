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
 * Use the {@link FAMASFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAMASFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GifImageView famasSpray,famasCurve;
    public FAMASFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAMASFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FAMASFragment newInstance(String param1, String param2) {
        FAMASFragment fragment = new FAMASFragment();
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
        View view = inflater.inflate(R.layout.fragment_famas, container, false);
        //height of image divided by width, added manually and must change for each different fragment
        double ratio = 1.740740;
        famasSpray = (GifImageView) view.findViewById(R.id.famasSpray);
        famasCurve = (GifImageView) view.findViewById(R.id.famasCurve);

        //get a LayoutParams object for one of the views, and assuming both images have equal resolution, then we only need one for both
        ViewGroup.LayoutParams famasParams = (ViewGroup.LayoutParams) famasSpray.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //sets the attributes we want for height and width. The ratio
        famasParams.width= (metrics.widthPixels/2);
        famasParams.height = (int)((metrics.widthPixels/2)*ratio);

        famasSpray.setLayoutParams(famasParams);
        famasCurve.setLayoutParams(famasParams);
        return view;
    }

}
