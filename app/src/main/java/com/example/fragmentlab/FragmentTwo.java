package com.example.fragmentlab;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private TextView tvValue;
    private SeekBar seek;
    private static final String KEY_PROGRESS = "progress";

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvValue = view.findViewById(R.id.tvValue);
        seek = view.findViewById(R.id.seekBar);

        // Restaurer l'état si rotation
        if (savedInstanceState != null) {
            int progress = savedInstanceState.getInt(KEY_PROGRESS, 0);
            seek.setProgress(progress);
            String valueText = getString(R.string.value_prefix, progress);
            tvValue.setText(valueText);
        }

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String valueText = getString(R.string.value_prefix, progress);
                tvValue.setText(valueText);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (seek != null) {
            outState.putInt(KEY_PROGRESS, seek.getProgress());
        }
    }
}