package com.example.ca3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class frag1 extends Fragment {
    EditText input;
    Button send;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,container,false);
        input = view.findViewById(R.id.input);
        send = view.findViewById(R.id.send);
        send.setOnClickListener(x);
        return view;
    }
    View.OnClickListener x = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = input.getText().toString();
            if(!text.isEmpty()){
                frag2 r = new frag2();
                Bundle bundle = new Bundle();
                bundle.putString("key",text);
                r.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.f1,r).commit();
            }
            else {
                input.setError("Empty Input");
            }

        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
