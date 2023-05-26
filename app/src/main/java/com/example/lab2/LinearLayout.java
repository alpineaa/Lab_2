package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class LinearLayout extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private CheckBox checkBox;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        checkBox = findViewById(R.id.checkbox);

        Button pressButton = findViewById(R.id.press_button);
        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                textView.setText(inputText);

                String toastMessage = getResources().getString(R.string.toast_message);
                Toast.makeText(LinearLayout.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String message = "The checkbox is now " + (isChecked ? "on" : "off");
                Snackbar.make(buttonView, message, Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkBox.setChecked(!isChecked);
                            }
                        })
                        .show();
            }
        });
    }
}