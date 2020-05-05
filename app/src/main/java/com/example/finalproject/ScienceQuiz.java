package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ScienceQuiz extends AppCompatActivity {
    RadioGroup q1RadioGroup;
    RadioGroup q2RadioGroup;
    RadioGroup q3RadioGroup;
    RadioGroup q4RadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_science);

        final Button backButton = findViewById(R.id.scienceBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(ScienceQuiz.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        q1RadioGroup = findViewById(R.id.scienceQ1RadioGroup);
        q2RadioGroup = findViewById(R.id.scienceQ2RadioGroup);
        q3RadioGroup = findViewById(R.id.scienceQ3RadioGroup);
        q4RadioGroup = findViewById(R.id.scienceQ4RadioGroup);


        final Button submitButton = findViewById(R.id.scienceSubmit);
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

                if (q1Id == R.id.scienceQ1Correct) {
                    score++;
                }
                if (q2Id == R.id.scienceQ2Correct) {
                    score++;
                }
                if (q3Id == R.id.scienceQ3Correct) {
                    score++;
                }
                if (q4Id == R.id.scienceQ4Correct) {
                    score++;
                }
                QuizScore.setQuizScore(score);
                QuizScore.setCurrentQuiz("Science Quiz!");
                // now i set the quizScore var to the current score
                Intent intent = new Intent(ScienceQuiz.this, QuizScore.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
