package com.example.mobdev3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobdev3.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SharedPreferences setts;
    FragmentFirstBinding firstBinding;
    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("gg","first created");
        Toast toast = Toast.makeText(getActivity(),"first created",Toast.LENGTH_SHORT);
        toast.show();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_first, container, false);
        MainActivity mainActivity = (MainActivity)getActivity();
        setts = mainActivity.getSharedPreferences(getText(R.string.settings).toString(), Context.MODE_PRIVATE);
        firstBinding = FragmentFirstBinding.inflate(inflater);
        firstBinding.img1.setImageDrawable(AppCompatResources.getDrawable(mainActivity,R.drawable.car_1));
        firstBinding.txtView.setText(R.string.name);
        firstBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("gg","button clicked");
                setts.edit().putString(getText(R.string.msg_to).toString(), firstBinding.editTxt.getText().toString()).apply();
                FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
                SecondFragment secondFragment = SecondFragment.newInstance("","");
                fragmentTransaction.replace(R.id.fragment_placeholder,secondFragment).addToBackStack(null).commit();
            }
        });
        return firstBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("gg","first started");
        Toast toast = Toast.makeText(getActivity(),"first started",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        firstBinding.txtView.setText(setts.getString(getText(R.string.msg_from).toString(),firstBinding.txtView.getText().toString()));
        Log.i("gg","first resumed");
        Toast toast = Toast.makeText(getActivity(),"first resumed",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("gg","first stopped");
        Toast toast = Toast.makeText(getActivity(),"first stopped",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("gg","first paused");
        Toast toast = Toast.makeText(getActivity(),"first paused",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("gg","first destroyed");
        Toast toast = Toast.makeText(getActivity(),"first destroyed",Toast.LENGTH_SHORT);
        toast.show();
    }
}