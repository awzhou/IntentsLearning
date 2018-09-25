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
    private Button buttonShare;

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

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an intent with the desired action
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                // set the data type of the stuff we're packaging away
                // can look up the type you need on the internet
                intentShare.setType("text/plain");
                // put the extra with the message
                intentShare.putExtra(EXTRA_SENT_MESSAGE, editTextMessage.getText().toString());
                // launch the activity
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        buttonShare = findViewById(R.id.button_sendmessage_share);
    }
}
