package com.ab.fragmentexampleone;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    private EditText editText;
    private Button button;
    OnMessageReadListener messageReadListener;/** callback method*/

    public MessageFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener
    {
        public void onread(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        editText= view.findViewById(R.id.txt_message);
        button= view.findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
                messageReadListener.onread(message);

            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            messageReadListener = (OnMessageReadListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"Must Override onMessage read...");
        }
    }
}



