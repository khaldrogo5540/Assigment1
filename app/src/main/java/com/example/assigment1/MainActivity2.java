package com.example.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private EditText mRepeatPasswordEditText;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        mEmailEditText = findViewById(R.id.email_edit);
        mPasswordEditText = findViewById(R.id.password_edit);
        mRepeatPasswordEditText = findViewById(R.id.repeat_password_edit);
        mSubmitButton = findViewById(R.id.button_submit);

        mSubmitButton.setEnabled(false);

        EditText [] edList = {mEmailEditText, mPasswordEditText, mRepeatPasswordEditText};
        CustomTextWatcher textWatcher = new CustomTextWatcher (edList,mSubmitButton);
        for (EditText textChanged : edList) textChanged.addTextChangedListener(textWatcher);
    }


    public class CustomTextWatcher implements TextWatcher {

        View v;
        EditText[] edList;

        public CustomTextWatcher(EditText[] edList, Button v) {
            this.v = v;
            this.edList = edList;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            for (EditText editText : edList) {
                if (editText.getText().toString().trim().length() == 0) {
                    v.setEnabled(false);
                    break;
                }
                else v.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}