package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SportsQuiz extends AppCompatActivity {
    // the reason im declaring these here is so it's faster to write the code for the other quizzes
    // and to increase clarity
    RadioGroup q1RadioGroup;
    RadioGroup q2RadioGroup;
    RadioGroup q3RadioGroup;
    RadioGroup q4RadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_sport);

        q1RadioGroup = findViewById(R.id.sportQ1RadioGroup);
        q2RadioGroup = findViewById(R.id.sportQ2RadioGroup);
        q3RadioGroup = findViewById(R.id.sportQ3RadioGroup);
        q4RadioGroup = findViewById(R.id.sportQ4RadioGroup);


        final Button submitButton = findViewById(R.id.sportSubmit);
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

                if (q1Id == R.id.sportQ1Correct) {
                    score++;
                }
                if (q2Id == R.id.sportQ2Correct) {
                    score++;
                }
                if (q3Id == R.id.sportQ3Correct) {
                    score++;
                }
                if (q4Id == R.id.sportQ4Correct) {
                    score++;
                }
                QuizScore.setQuizScore(score);
                QuizScore.setCurrentQuiz("Sports");
                // now i set the quizScore var to the current score
                Intent intent = new Intent(SportsQuiz.this, QuizScore.class);
                startActivity(intent);
                finish();
            }
        });

        final Button backButton = findViewById(R.id.sportBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(SportsQuiz.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
