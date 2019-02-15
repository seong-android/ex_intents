package com.seongandroid.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.seongandroid.intents.extra.REPLY";

    private TextView mMessageView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mMessageView = (TextView) findViewById(R.id.second_message);
        mEditText = (EditText) findViewById(R.id.second_editText);
        if (mMessageView != null) {
            mMessageView.setText(message);
        }
    }

    public void sendReply(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String reply = mEditText.getText().toString();
        intent.putExtra(EXTRA_REPLY, reply);
        Toast toast = Toast.makeText(this, "Reply Sent!", Toast.LENGTH_SHORT);
        toast.show();
        setResult(RESULT_OK, intent);
        finish();
    }
}
