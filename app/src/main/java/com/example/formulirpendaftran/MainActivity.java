package com.example.formulirpendaftran;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nNama;
    private EditText nEmail;
    private EditText nNomor;
    private RadioGroup radioGroup;
    private CheckBox HobiMusic;
    private CheckBox HobiOlahraga;
    private CheckBox HobiMemasak;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi View
        nNama = findViewById(R.id.inputnama);
        nEmail = findViewById(R.id.inputemail);
        nNomor = findViewById(R.id.inputnomor);
        radioGroup = findViewById(R.id.radioGroupJenisKelamin);
        HobiMusic = findViewById(R.id.hobi1);
        HobiOlahraga = findViewById(R.id.hobi2);
        HobiMemasak = findViewById(R.id.hobi3);
        btnSubmit = findViewById(R.id.tombolsimpan);

        // Aksi saat tombol Kirim Data ditekan
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = nNama.getText().toString();
                String email = nEmail.getText().toString();
                String nomor = nNomor.getText().toString();

                // Ambil jenis kelamin yang dipilih
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String gender = radioButton == null ? "" : radioButton.getText().toString();

                // Ambil hobi yang dipilih
                StringBuilder hobbies = new StringBuilder();
                if (HobiMusic.isChecked()) hobbies.append("Musik ");
                if (HobiOlahraga.isChecked()) hobbies.append("Olahraga ");
                if (HobiMemasak.isChecked()) hobbies.append("Memasak ");

                // Tampilkan data dalam DialogBox
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Data Diri Anda")
                        .setMessage("Nama: " + nama + "\nEmail: " + email + "\nNomor: " + nomor +
                                "\nJenis Kelamin: " + gender + "\nHobi: " + hobbies.toString().trim())
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}