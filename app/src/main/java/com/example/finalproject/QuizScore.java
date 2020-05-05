package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizScore extends AppCompatActivity {
    private static int quizScore;
    private static String currentQuiz;

    public static void setQuizScore(int setQuizScore) {
        quizScore = setQuizScore;
    }

    public static void setCurrentQuiz(String setCurrentQuiz) {
        currentQuiz = setCurrentQuiz;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_score);

        TextView textView = findViewById(R.id.quizTypeText);
        textView.setText(currentQuiz);
        TextView textView1 = findViewById(R.id.quizScoreText);
        textView1.setText((Integer.toString(quizScore)));

        final Button homeButton = findViewById(R.id.homePageButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(QuizScore.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
