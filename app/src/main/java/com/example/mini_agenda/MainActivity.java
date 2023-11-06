package com.example.mini_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNom, editTextCognoms, editTextTelefon, editTextEmail;
    private Button buttonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNom = findViewById(R.id.editTextNom);
        editTextCognoms = findViewById(R.id.editTextCognoms);
        editTextTelefon = findViewById(R.id.editTextTelefon);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonGuardar = findViewById(R.id.buttonGuardar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarContacte();
            }
        });
    }

    private void guardarContacte() {
        String nom = editTextNom.getText().toString();
        String cognoms = editTextCognoms.getText().toString();
        String telefon = editTextTelefon.getText().toString();
        String email = editTextEmail.getText().toString();

        String contacte = nom + ";" + cognoms + ";" + telefon + ";" + email;

        try {
            FileOutputStream fileOutputStream = openFileOutput("contactes.txt", MODE_APPEND);
            fileOutputStream.write(contacte.getBytes());
            fileOutputStream.write("\n".getBytes()); // Nueva línea para los siguientes contactos
            fileOutputStream.close();

            Toast.makeText(this, "Contacte guardat amb èxit.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar el contacto.", Toast.LENGTH_SHORT).show();
        }
    }
}
