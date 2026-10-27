package com.example.lifecycleactivity1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("Lifecycle", "SecondActivity: onCreate");

        TextView tvIncoming = findViewById(R.id.tvIncoming);
        EditText etReply = findViewById(R.id.etReply);
        Button btnReturn = findViewById(R.id.btnReturn);

        // MainActivity se aya data read karo
        String incomingMessage = getIntent().getStringExtra("INPUT_KEY");
        if (incomingMessage == null) incomingMessage = "Did not recieve any message.";
        tvIncoming.setText("Recieved: " + incomingMessage);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String replyText = etReply.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("RETURN_KEY", replyText);
                setResult(RESULT_OK, resultIntent);
                finish(); // SecondActivity ko finish karke wapas pehli activity par jao
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "SecondActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "SecondActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "SecondActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "SecondActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "SecondActivity: onDestroy");
    }
}
