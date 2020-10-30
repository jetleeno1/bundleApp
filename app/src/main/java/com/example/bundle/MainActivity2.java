package com.example.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {

    private Button button2;
    private EditText ed_name;
    private RadioGroup radioGroup,radioGroup2;

    private String sugar = "無糖";
    private String ice = "去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rb_no_sugar:
                        sugar = "無糖";
                        break;
                    case R.id.rb_less_sugar:
                        sugar = "少糖";
                        break;
                    case R.id.rb_half_sugar:
                        sugar = "半糖";
                        break;
                    case R.id.rb_full_sugar:
                        sugar = "全糖";
                        break;
                }
            }
        });

        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_no_ice:
                        ice = "微冰";
                        break;
                    case R.id.rb_less_ice:
                        ice = "少冰";
                        break;
                    case R.id.rb_normal_ice:
                        ice = "正常冰";
                        break;
                }
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_name = findViewById(R.id.ed_name);
                String drink = ed_name.getText().toString();
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("sugar",sugar);
                b.putString("drink",drink);
                b.putString("ice",ice);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });
    }
}