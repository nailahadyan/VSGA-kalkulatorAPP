package dev.nailah.vsga;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText angkaPertama, angkaKedua;
    private Button tambah, kurang, kali, bagi, bersihkan;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setClickListeners();
    }

    private void initUI() {
        angkaPertama = findViewById(R.id.angka_pertama);
        angkaKedua = findViewById(R.id.angka_kedua);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        kali = findViewById(R.id.kali);
        bagi = findViewById(R.id.bagi);
        bersihkan = findViewById(R.id.bersihkan);
        hasil = findViewById(R.id.hasil); // This should be a TextView, not a Button
    }

    private void setClickListeners() {
        tambah.setOnClickListener(v -> performCalculation("+"));
        kurang.setOnClickListener(v -> performCalculation("-"));
        kali.setOnClickListener(v -> performCalculation("X"));
        bagi.setOnClickListener(v -> performCalculation("/"));
        bersihkan.setOnClickListener(v -> clearFields());
    }

    private void performCalculation(String operation) {
        if (isValidInput()) {
            double angka1 = Double.parseDouble(angkaPertama.getText().toString());
            double angka2 = Double.parseDouble(angkaKedua.getText().toString());
            double result = 0;

            switch (operation) {
                case "+":
                    result = angka1 + angka2;
                    break;
                case "-":
                    result = angka1 - angka2;
                    break;
                case "X":
                    result = angka1 * angka2;
                    break;
                case "/":
                    if (angka2 != 0) {
                        result = angka1 / angka2;
                    } else {
                        Toast.makeText(this, "Pembagian dengan Nol Tidak Diizinkan", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            hasil.setText(String.valueOf(result));
        } else {
            Toast.makeText(this, "Mohon Masukkan Angka Pertama dan Kedua", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidInput() {
        return angkaPertama.getText().length() > 0 && angkaKedua.getText().length() > 0;
    }

    private void clearFields() {
        angkaPertama.setText("");
        angkaKedua.setText("");
        hasil.setText("0");
        angkaPertama.requestFocus();
    }
}
