package com.example.uts_tam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    // deklarasi tombol
    private Button mBtn_cheked,mBtn_notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisial tombol
        mBtn_cheked = (Button)findViewById(R.id.btn_cheked);
        mBtn_notes = (Button)findViewById(R.id.btn_notes);

        // function tombol

        mBtn_cheked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCheked = new Intent(getApplicationContext(), ChekedActivity.class);
                startActivity(iCheked);
            }
        });

        mBtn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNotes = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(iNotes);
            }
        });
    }
}