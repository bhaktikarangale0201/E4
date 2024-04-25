package com.example.exp_4;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText username = findViewById(R.id.editTextText);
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        Button reg = findViewById(R.id.button);
        Intent intent = new Intent(MainActivity.this, activity_show.class);
        RadioGroup radioGroup = findViewById(R.id.radio1);
        Spinner spinner = findViewById(R.id.spinner);
        CheckBox ch1 = findViewById(R.id.checkbox1);
        CheckBox ch2 = findViewById(R.id.checkbox2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int sel_id = group.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(sel_id);
                intent.putExtra("gen", radioButton.getText());
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                intent.putExtra("uname", name);
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("sub_name", spinner.getSelectedItem().toString());

                boolean isChecked1 = ch1.isChecked();
                boolean isChecked2 = ch2.isChecked();

                if (isChecked1) {
                    intent.putExtra("checkbox1", ch1.getText().toString());
                }

                if (isChecked2) {
                    intent.putExtra("checkbox2", ch2.getText().toString());
                }
                startActivity(intent);
            }
        });
    }}