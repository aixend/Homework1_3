package com.example.homework1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button send;
    private EditText emailAddress,emailTheme,emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send =  findViewById(R.id.email_send_button);
        emailAddress = findViewById(R.id.email_address);
        emailTheme = findViewById(R.id.email_theme);
        emailText = findViewById(R.id.email_text);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                emailIntent.setType("plain/text");
                // Кому
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[] { emailAddress.getText().toString() });
                // Зачем
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        emailTheme.getText().toString());
                // О чём
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                        emailText.getText().toString());

                MainActivity.this.startActivity(Intent.createChooser(emailIntent,
                        "Отправка письма..."));
            }
        });
    }
}

