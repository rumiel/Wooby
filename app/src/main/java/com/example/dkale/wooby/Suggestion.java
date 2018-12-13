package com.example.dkale.wooby;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Suggestion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Suggestion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Suggestion extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button writer;
    private TextView titleName;
    private ImageView imageView;

    private OnFragmentInteractionListener mListener;

    public Suggestion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Suggestion.
     */
    // TODO: Rename and change types and number of parameters
    public static Suggestion newInstance(String param1, String param2) {
        Suggestion fragment = new Suggestion();
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
        return inflater.inflate(R.layout.fragment_suggestion, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSuggestionFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        buttonToWatch();
        buttonWatched();
//        imageView = (ImageView) getView().findViewById(R.id.suggestionImage);
//        Picasso.get().load("https://pm1.narvii.com/6561/78c92e781ab8f833b61fd85d0e8e82dc2a17076d_hq.jpg").into(imageView);
//        initCard();
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
        void onSuggestionFragmentInteraction(Uri uri);
    }

    public void buttonToWatch(){
        writer = (Button) getView().findViewById(R.id.toWatchButton);
        titleName = (TextView) getView().findViewById(R.id.titleName);
        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Added to 'To Watch' list", Toast.LENGTH_SHORT).show();
                if(getActivity() != null){
                    Log.e("If you can see this",titleName.getText().toString());
//                    This is the suggestion activity. This is where the button listener is for the Add to "Watch Later" list. Uncomment the line below and add the proper parameters
                    ((MainActivity) getActivity()).writeToWatchDatabase("Sailor Moon","Its about a magical girl...","https://upload.wikimedia.org/wikipedia/en/e/e5/SMVolume1.jpg","https://en.wikipedia.org/wiki/Sailor_Moon");
                }
            }
        });
    }

    public void buttonWatched(){
        writer = (Button) getView().findViewById(R.id.watchedButton);
        titleName = (TextView) getView().findViewById(R.id.titleName);
        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Added to 'Watched' list", Toast.LENGTH_SHORT).show();
                if(getActivity() != null){
                    Log.e("If you can see this",titleName.getText().toString());
//                    This is the suggestion activity. This is where the button listener is for the Add to "Watch" list. Uncomment the line below and add the proper parameters
                    ((MainActivity) getActivity()).writeWatchedDatabase("Sailor Moon","Its about a magical girl...","https://upload.wikimedia.org/wikipedia/en/e/e5/SMVolume1.jpg","https://en.wikipedia.org/wiki/Sailor_Moon");
                }
            }
        });
    }

//    public void initCard(){
//        imageView = (ImageView) getView().findViewById(R.id.suggestionImage);
//        Picasso.get().load("put link here").into(imageView);
//    }

}
