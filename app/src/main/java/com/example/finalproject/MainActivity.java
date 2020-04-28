package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sports = findViewById(R.id.sportsButton);
        sports.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, SportsQuiz.class);
                startActivity(intent);
            }
        });

        final Button music = findViewById(R.id.musicButton);
        music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, MusicQuiz.class);
                startActivity(intent);
            }
        });

        final Button science = findViewById(R.id.scienceButton);
        science.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, ScienceQuiz.class);
                startActivity(intent);
            }
        });

        final Button geography = findViewById(R.id.geographyButton);
        geography.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, GeographyQuiz.class);
                startActivity(intent);
            }
        });

        final Button food = findViewById(R.id.foodButton);
        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, FoodQuiz.class);
                startActivity(intent);
            }
        });

        final Button uiuc = findViewById(R.id.uiucButton);
        uiuc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, UiucQuiz.class);
                startActivity(intent);
            }
        });

        final Button movies = findViewById(R.id.moviesButton);
        movies.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, MoviesQuiz.class);
                startActivity(intent);
            }
        });

        final Button math = findViewById(R.id.mathButton);
        math.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, MathQuiz.class);
                startActivity(intent);
            }
        });
    }
}
