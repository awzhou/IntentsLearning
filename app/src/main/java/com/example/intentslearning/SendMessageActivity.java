package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private Button buttonSendMessage;

    public static final String EXTRA_SENT_MESSAGE ="the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the text from the edittext
                String message = editTextMessage.getText().toString();
                // create an intent
                // the arguments are where you are coming from (this)
                // and where you are going (TargetActivity.class)
                Intent intentSendMessage = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                // package the text into the intent
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE, message);
                // start the new activity
                startActivity(intentSendMessage);
            }
        });
    }

    private void wireWidgets() {
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
    }
}
