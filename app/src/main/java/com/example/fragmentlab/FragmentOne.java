package com.example.fragmentlab;  // Changé

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btnHello;

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        btnHello.setOnClickListener(v -> {
            tv.setText(R.string.hello_message);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("FragmentOne", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("FragmentOne", "onPause()");
    }
}