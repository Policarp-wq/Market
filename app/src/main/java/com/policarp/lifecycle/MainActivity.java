package com.policarp.lifecycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.policarp.lifecycle.databinding.MarketBinding;

public class MainActivity extends AppCompatActivity {
    private MarketBinding binding;
    private void clear(){
        binding.CB1.setChecked(false);
        binding.CB2.setChecked(false);
        binding.CB3.setChecked(false);
        binding.CB4.setChecked(false);
        binding.CB5.setChecked(false);
        binding.CB6.setChecked(false);
        binding.Delivery.clearCheck();
        binding.Addition.setText("");
    }
    private boolean containsValues(){
        return binding.CB1.isChecked() || binding.CB2.isChecked()||
                binding.CB3.isChecked()|| binding.CB4.isChecked()||
                binding.CB5.isChecked()|| binding.CB6.isChecked()||
                binding.RB1.isChecked()|| binding.RB2.isChecked()||
                binding.RB3.isChecked()|| binding.Addition.getText().length() > 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MarketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        binding.Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (containsValues())
                    Toast.makeText(MainActivity.this, "Заказали", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if(containsValues())
            Toast.makeText(this, "Мдааааа, там были отмечены некоторые позиции, но мы их не сохранили тк не умеем",
                    Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}