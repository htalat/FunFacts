package com.example.hassan.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private FactBook mfactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private String mFact = mfactBook.mfacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);
    final TextView mFactLabel = (TextView) findViewById(R.id.factTextView);
    final RelativeLayout mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    final Button mShowFactButton = (Button) findViewById(R.id.showFactButton);


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        mFactLabel.setText(mFact);
        mRelativeLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = mfactBook.getFact();
                mColor= mColorWheel.getColor();
                mFactLabel.setText(mFact);
                mRelativeLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }


}
