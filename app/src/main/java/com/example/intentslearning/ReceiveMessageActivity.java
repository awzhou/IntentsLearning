package com.example.intentslearning;

import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReceiveMessageActivity extends AppCompatActivity {

    private TextView textViewDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        textViewDisplayMessage = findViewById(R.id.textView_receivemessage_displaymsg);

        textViewDisplayMessage.setText(getIntent().getStringExtra("the message"));
    }
}
