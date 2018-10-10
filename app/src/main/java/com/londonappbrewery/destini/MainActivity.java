package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mStoryIndex = 1;

        updateStory(mStoryIndex);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryIndex = 3;
                    updateStory(mStoryIndex);
                }
                else if (mStoryIndex == 3) {
                    mStoryIndex = 6;
                    updateStory(mStoryIndex);
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:4
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryIndex = 2;
                    updateStory(mStoryIndex);
                }
                else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                    updateStory(mStoryIndex);
                }
                else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                    updateStory(mStoryIndex);
                }
            }
        });

    }

    private void updateStory(int storyIndex) {
        if (storyIndex == 1) {
            mStoryTextView.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonBottom.setText(R.string.T1_Ans2);
        }
        else if (storyIndex == 2) {
            mStoryTextView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
        }
        else if (storyIndex == 3) {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
        }
        else if (storyIndex == 4) {
            mStoryTextView.setText(R.string.T4_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
        else if (storyIndex == 5) {
            mStoryTextView.setText(R.string.T5_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
        else if (storyIndex == 6) {
            mStoryTextView.setText(R.string.T6_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
        else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Story resource is not found.");
            alertDialog.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialog.show();
        }
    }
}
