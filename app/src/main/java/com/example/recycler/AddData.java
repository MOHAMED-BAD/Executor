package com.example.recycler;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddData extends AppCompatActivity {
    private EditText addName;
    private EditText addNumber;
    Data data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        initView();
        if (getIntent().hasExtra("data")) {
             data = (Data) getIntent().getSerializableExtra("data");
             addName.setText(data.getName());
             addNumber.setText(data.getNumber());
        }
    }

    void initView() {
        addName   = findViewById(R.id.add_name);
        addNumber = findViewById(R.id.add_number);

        FloatingActionButton fab = findViewById(R.id.floatb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int id=0;
                if(data!=null){
                    id=data.getId();
                }
                Data data = creatData(addName.getText().toString(),addNumber.getText().toString(),id);
                if (data != null) {
                    Intent intent = new Intent();
                    intent.putExtra("data", data);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private Data creatData(String name, String number ,int id) {
        boolean invalid = false;
        if (name == null || name.isEmpty()) {
            invalid = true;
            addName.setError("ادخل الاسم من فضلك");
        }
        if (number == null || number.isEmpty()) {
            invalid = true;
            addNumber.setError("ادخل رقم من فضلك ");
        }
        if (invalid)
        {
            return null;}
   else
            return new Data(name,number,id);
    }
}
