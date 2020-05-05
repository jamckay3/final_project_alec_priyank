package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MusicQuiz extends AppCompatActivity {
    RadioGroup q1RadioGroup;
    RadioGroup q2RadioGroup;
    RadioGroup q3RadioGroup;
    RadioGroup q4RadioGroup;

    RadioButton q3Wrong1RadioButton;
    RadioButton q3Wrong2RadioButton;
    RadioButton q3Wrong3RadioButton;
    RadioButton q3CorrectRadioButton;

    RadioButton q4Wrong1RadioButton;
    RadioButton q4Wrong2RadioButton;
    RadioButton q4Wrong3RadioButton;
    RadioButton q4CorrectRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_music);

        boolean thrown = false;
        q3Wrong1RadioButton = findViewById(R.id.musicQ3Wrong1);
        q3Wrong2RadioButton = findViewById(R.id.musicQ3Wrong2);
        q3Wrong3RadioButton = findViewById(R.id.musicQ3Wrong3);
        q3CorrectRadioButton = findViewById(R.id.musicQ3Correct);

        q4Wrong1RadioButton = findViewById(R.id.musicQ4Wrong1);
        q4Wrong2RadioButton = findViewById(R.id.musicQ4Wrong2);
        q4Wrong3RadioButton = findViewById(R.id.musicQ4Wrong3);
        q4CorrectRadioButton = findViewById(R.id.musicQ4Correct);
        try {
            q3Wrong1RadioButton.setText(JsoupMusic.getSong(3));
            q3Wrong2RadioButton.setText(JsoupMusic.getSong(6));
            q3Wrong3RadioButton.setText(JsoupMusic.getSong(7));
            q3CorrectRadioButton.setText(JsoupMusic.getSong(1));

            q4Wrong1RadioButton.setText(JsoupMusic.getSong(4));
            q4Wrong2RadioButton.setText(JsoupMusic.getSong(5));
            q4Wrong3RadioButton.setText(JsoupMusic.getSong(8));
            q4CorrectRadioButton.setText(JsoupMusic.getSong(2));
        } catch (Exception e) {
            thrown = true;
            Intent intent = new Intent(MusicQuiz.this, ErrorPage.class);
            startActivity(intent);
            finish();
        }

        final Button backButton = findViewById(R.id.musicBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MusicQuiz.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        q1RadioGroup = findViewById(R.id.musicQ1RadioGroup);
        q2RadioGroup = findViewById(R.id.musicQ2RadioGroup);
        q3RadioGroup = findViewById(R.id.musicQ3RadioGroup);
        q4RadioGroup = findViewById(R.id.musicQ4RadioGroup);

        final Button submitButton = findViewById(R.id.musicSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int score = 0;
                // code here executes when submit button is pressed
                // want to check each answer's correct radiobutton
                // if the correct answer is selected, add one to tmp score var
                int q1Id = q1RadioGroup.getCheckedRadioButtonId();
                int q2Id = q2RadioGroup.getCheckedRadioButtonId();
                int q3Id = q3RadioGroup.getCheckedRadioButtonId();
                int q4Id = q4RadioGroup.getCheckedRadioButtonId();

                if (q1Id == R.id.musicQ1Correct) {
                    score++;
                }
                if (q2Id == R.id.musicQ2Correct) {
                    score++;
                }
                if (q3Id == R.id.musicQ3Correct) {
                    score++;
                }
                if (q4Id == R.id.musicQ4Correct) {
                    score++;
                }
                QuizScore.setQuizScore(score);
                QuizScore.setCurrentQuiz("Music");
                // now i set the quizScore var to the current score
                Intent intent = new Intent(MusicQuiz.this, QuizScore.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
