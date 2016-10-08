package com.twotowerstudio.csgocompanion;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AK47Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AK47Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AK47Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GifImageView ak47Spray, ak47Curve;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AK47Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AK47Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AK47Fragment newInstance(String param1, String param2) {
        AK47Fragment fragment = new AK47Fragment();
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
        /**GifImageView ak47Curve = (GifImageView) getView().findViewById(R.id.ak47Curve);
        GifImageView ak47spray = (GifImageView) getView().findViewById(R.id.ak47Spray);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ak47, container, false);
        //height of image divided by width, added manually and must change for each different fragment
        double ratio = 1.744623;
        ak47Spray = (GifImageView) view.findViewById(R.id.ak47Spray);
        ak47Curve = (GifImageView) view.findViewById(R.id.ak47Curve);

        //get a LayoutParams object for one of the views, and assuming both images have equal resolution, then we only need one for both
        ViewGroup.LayoutParams ak47Params = (ViewGroup.LayoutParams) ak47Spray.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //sets the attributes we want for height and width. The ratio
        ak47Params.width= (metrics.widthPixels/2);
        ak47Params.height = (int)((metrics.widthPixels/2)*ratio);

        ak47Spray.setLayoutParams(ak47Params);
        ak47Curve.setLayoutParams(ak47Params);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
