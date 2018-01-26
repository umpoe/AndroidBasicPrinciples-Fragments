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
public class MainFragment extends Fragment {
    Button buttonFrame1, buttonFrame2;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_main, container, false);

        buttonFrame1=(Button)view.findViewById(R.id.buttonFrame1);
        buttonFrame2=(Button)view.findViewById(R.id.buttonFrame2);

        buttonFrame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment firstFragment = new FirstFragment(); // Create new fragment
                FragmentTransactionCustom(MainFragment.this, firstFragment);// Call Fragment custom loader method
            }
        });
        buttonFrame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();// Create new fragment
                FragmentTransactionCustom(MainFragment.this, secondFragment);// Call Fragment custom loader method
            }
        });

        return view;
    }


    public void FragmentTransactionCustom(Fragment currentFragment, Fragment passedFragment){
        FragmentManager fragmentManager = getFragmentManager();    //acquire an instance of FragmentTransaction from the FragmentManager like this
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();    //Each set of changes that you commit to the activity is called a transaction and you can perform one using APIs in FragmentTransaction
        fragmentTransaction.addToBackStack("xyz");    // and add the transaction to the back stack
        fragmentTransaction.hide(currentFragment);    //Fragment to remove
        fragmentTransaction.add(R.id.frame_content, passedFragment);    // Replace whatever is in the fragment_container view with this fragment
        fragmentTransaction.commit();    // Commit the transaction


    }

}
