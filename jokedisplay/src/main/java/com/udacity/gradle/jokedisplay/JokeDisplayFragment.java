package com.udacity.gradle.jokedisplay;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokeDisplayFragment extends Fragment {

    public static final String JOKEDISPLAYFRAGMENT_JOKE_STRING_BUNDLE =
            "com.udacity.gradle.jokedisplay.joke_string_bndle";

    private TextView mJokeText;
    public static final JokeDisplayFragment newInstance(String joke){
        Bundle bundle = new Bundle();
        bundle.putString(JOKEDISPLAYFRAGMENT_JOKE_STRING_BUNDLE, joke);
        JokeDisplayFragment fragment = new JokeDisplayFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public JokeDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_joke_display, container, false);

        mJokeText =(TextView) view.findViewById(R.id.joke_textview);
        mJokeText.setText(getArguments().getString(JOKEDISPLAYFRAGMENT_JOKE_STRING_BUNDLE));
        return view;
    }

}
