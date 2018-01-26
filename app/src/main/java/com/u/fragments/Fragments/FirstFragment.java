package com.u.fragments.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.u.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    Button buttonCancel;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        buttonCancel=(Button)view.findViewById(R.id.buttonCancel) ;
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager2 = getFragmentManager();//acquire an instance of FragmentTransaction from the FragmentManager like this
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();//Each set of changes that you commit to the activity is called a transaction and you can perform one using APIs in FragmentTransaction
                MainFragment mainFragment = new MainFragment();// Create new fragment
                fragmentTransaction2.addToBackStack("xyz");// and add the transaction to the back stack
                fragmentTransaction2.hide(FirstFragment.this);//Fragment to remove
                fragmentTransaction2.add(android.R.id.content, mainFragment);// Replace whatever is in the fragment_container view with this fragment
                fragmentTransaction2.commit();// Commit the transaction
            }
        });

        return  view;
    }

}
