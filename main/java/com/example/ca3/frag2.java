package com.example.ca3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag2 extends Fragment {
    TextView output;
    Button receive;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2,container,false);
        output = view.findViewById(R.id.output);
        receive = view.findViewById(R.id.recieve);
        receive.setOnClickListener(x);
        return view;
    }
    View.OnClickListener x =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle bundle = getArguments();
            if( bundle != null ) {
                String text = bundle.getString("key");
                output.setText(text);
            }
            else {
                Toast.makeText(getContext(), "Not Received", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
