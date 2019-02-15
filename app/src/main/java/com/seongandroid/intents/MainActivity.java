package com.seongandroid.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.seongandroid.intents.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;
    private TextView mReplyHeader;
    private TextView mReplyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.main_textinput);
        mReplyHeader = (TextView) findViewById(R.id.main_header);
        mReplyContent = (TextView) findViewById(R.id.main_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Send Button Pushed!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        Toast toast = Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT);
        toast.show();
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeader.setVisibility(View.VISIBLE);
                mReplyContent.setText(reply);
                mReplyContent.setVisibility(View.VISIBLE);
            }
        }
    }
}