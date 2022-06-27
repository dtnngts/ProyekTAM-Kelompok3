package com.example.uts_tam;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class NotesActivity extends AppCompatActivity {

    // deklarasi tombol
    private Button mBtn_home,mBtn_cheked,mBtn_add;
    private TextView title,desc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

//inisial tombol
        mBtn_home = (Button)findViewById(R.id.btn_home);
        mBtn_cheked = (Button)findViewById(R.id.btn_cheked);
        mBtn_add = (Button)findViewById(R.id.btn_add);

        title = (TextView) findViewById(R.id.text_view_title3);
        desc = (TextView) findViewById(R.id.text_view_description3);


        // function tombol
        mBtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iHome = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(iHome);
            }
        });

        mBtn_cheked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCheked = new Intent(getApplicationContext(),ChekedActivity.class);
                startActivity(iCheked);
            }
        });

        mBtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAdd = new Intent(getApplicationContext(),AddNoteActivity.class);
                startActivity(iAdd);
            }
        });

        if(getIntent().getExtras() == null){
            title.setText("  "+getIntent().getStringExtra("DataSaya"));
            desc.setText("  "+getIntent().getStringExtra("DataSaya"));
        }
    }

}