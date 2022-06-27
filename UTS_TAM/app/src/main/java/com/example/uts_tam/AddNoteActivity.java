package com.example.uts_tam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener   {
    private EditText title, desc;
    private Button mBtn_back,mBtn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //inisial tombol
        mBtn_back = (Button)findViewById(R.id.btn_back);

        title.setOnClickListener(this);
        desc.setOnClickListener(this);
        mBtn_save.setOnClickListener(this);



        // function tombol
        mBtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogin = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(iLogin);
            }
        });

        mBtn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Notes disimpan",Toast.LENGTH_LONG).show();            }
        });


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save){
            Intent sendData1 = new Intent(AddNoteActivity.this, NotesActivity.class);
            sendData1.putExtra("DataSaya", title.getText()).putExtra("DataSaya", desc.getText());
            startActivity(sendData1);
        }
    }


}