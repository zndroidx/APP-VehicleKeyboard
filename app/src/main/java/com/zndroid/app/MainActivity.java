package com.zndroid.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.zndroid.keyboard.OnInputChangedListener;
import com.zndroid.keyboard.PopupKeyboard;
import com.zndroid.keyboard.view.InputView;

public class MainActivity extends AppCompatActivity {
    InputView inputView;
    PopupKeyboard keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = findViewById(R.id.car);

        keyboard = new PopupKeyboard(this);
        keyboard.attach(inputView, this);
        keyboard.getController().addOnInputChangedListener(new OnInputChangedListener() {
            @Override
            public void onChanged(String number, boolean isCompleted) {

            }

            @Override
            public void onCompleted(String number, boolean isAutoCompleted) {
                keyboard.dismiss(MainActivity.this);
                Log.i("log", number);
            }
        });


    }
}
