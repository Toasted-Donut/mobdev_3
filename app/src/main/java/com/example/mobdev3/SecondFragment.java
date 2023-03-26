package com.example.mobdev3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobdev3.databinding.FragmentSecondBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SharedPreferences setts;
    FragmentSecondBinding secondBinding;
    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("gg","second created");
        Toast toast = Toast.makeText(getActivity(),"second created",Toast.LENGTH_SHORT);
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
        secondBinding = FragmentSecondBinding.inflate(inflater);
        MainActivity mainActivity = (MainActivity)getActivity();
        setts = mainActivity.getSharedPreferences(getText(R.string.settings).toString(), Context.MODE_PRIVATE);
        secondBinding.textView.setText(setts.getString(getText(R.string.msg_to).toString(),"default"));
        secondBinding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("gg","txt changed");
                setts.edit().putString(getText(R.string.msg_from).toString(), secondBinding.editText.getText().toString()).apply();
            }
        });
        return secondBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("gg","second started");
        Toast toast = Toast.makeText(getActivity(),"second started",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("gg","second resumed");
        Toast toast = Toast.makeText(getActivity(),"second resumed",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("gg","second stopped");
        Toast toast = Toast.makeText(getActivity(),"second stopped",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("gg","second paused");
        Toast toast = Toast.makeText(getActivity(),"second paused",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("gg","second destroyed");
        Toast toast = Toast.makeText(getActivity(),"second destroyed",Toast.LENGTH_SHORT);
        toast.show();
    }
}