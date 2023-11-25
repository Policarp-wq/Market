package com.policarp.lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.policarp.lifecycle.databinding.MenuBinding;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private static String TAG = "MENUACTIVITY";
    private ArrayList<String> breakfast = new ArrayList<>();
    private ArrayList<String> lunch = new ArrayList<>();
    private ArrayList<String> dinner = new ArrayList<>();
    private MenuBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = MenuBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());
         binding.add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 addToMenu();
             }
         });
         binding.generate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 generateMenu();
             }
         });
    }

    private void generateMenu() {
        try {
            binding.breakfast.setText(breakfast.get(0));
            binding.lunch.setText(lunch.get(0));
            binding.dinner.setText(dinner.get(0));
        }catch (IndexOutOfBoundsException ex){
            Log.e(TAG, "generateMenu: ", ex);
        }

    }

    private void addToMenu() {
        String input = String.valueOf(binding.mealinput.getText());
        if(binding.breakfastRB.isChecked()){
            breakfast.add(input);
        }
        else if(binding.lunchRB.isChecked()){
            lunch.add(input);
        }
        else dinner.add(input);
        Toast.makeText(this, "Added meal", Toast.LENGTH_SHORT).show();
        binding.mealinput.setText("");
    }
}
