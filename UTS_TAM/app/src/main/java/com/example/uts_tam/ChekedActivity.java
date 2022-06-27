package com.example.uts_tam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ChekedActivity extends AppCompatActivity {

    // deklarasi tombol
    private Button mBtn_home,mBtn_notes;

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] subjects = {
            "Surat pengantar nikah dari desa/kelurahan tempat tinggal calon ",
            "Fotokopi akta kelahiran atau surat keterangan kelahiran yang dikeluarkan desa atau kelurahan setempat.",
            "Fotokopi KTP atau resi surat keterangan telah melakukan perekaman E-KTP bagi yang sudah berusia 17 tahun atau sudah pernah melangsungkan nikah.",
            "Fotokopi kartu keluarga.",
            "Surat rekomendasi nikah dari KUA kecamatan setempat bagi calon pengantin  yang melangsungkan nikah di luar wilayah kecamatan tempat tinggalnya.  ",
            "Persetujuan kedua calon pengantin.",
            "Izin tertulis orangtua atau wali bagi calon pengantin yang belum mencapai 21 tahun.",
            "Izin dari wali yang mengasuh yang mempunyai hubungan darah, dalam hal kedua orangtua telah meninggal dunia atau dalam keadaan tidak mampu menyatakan kehendaknya.",
            "Izin dari pengadilan dalam hal orangtua wali, dan pengampu tidak ada.",
            "Dispensasi dari pengadilan bagi calon suami yang belum mencapai usia dengan ketentuan Undang-Undang Nomor 1 Tahun 1974 tentang Perkawinan.",
            "Surat izin dari atasan atu kesatuan jika calon pengantin berstatus anggota TNI atau Polri.",
            "Penetapan izin poligami dari Pengadilan Agama bagi suami yang hendak beristri lebih dari seorang.",
            "Akta cerai atu kutipan buku pendaftaran talak atau buku pendaftaran cerai bagi mereka yang perceraiannya terjadi sebelum berlakunya Undang-Undang Nomor 7 Tahun 1989 tentang Peradilan Agama.",
            "Akta kematian atau surat keterangan kematian suami atau istri dibuat oleh lurah atau kepala desa atau pejabat singkat bagi janda atau duda ditinggal mati.",
            "Pas foto ukuran 2x3 dengan latar belakang biru berjumlah 4 lembar berserta softcopynya.",
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheked);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recycler_view);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(context, subjects);
        recyclerView.setAdapter(recyclerViewAdapter);


//inisial tombol
        mBtn_home = (Button)findViewById(R.id.btn_home);
        mBtn_notes = (Button)findViewById(R.id.btn_notes);

        // function tombol
        mBtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogin = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(iLogin);
            }
        });


        mBtn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNotes = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(iNotes);
            }
        });
    }
}