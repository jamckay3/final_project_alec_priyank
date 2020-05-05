package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    private String songNameBaby;
    private int ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_music);

        //boolean thrown = false;
        q3Wrong1RadioButton = findViewById(R.id.musicQ3Wrong1);
        q3Wrong2RadioButton = findViewById(R.id.musicQ3Wrong2);
        q3Wrong3RadioButton = findViewById(R.id.musicQ3Wrong3);
        q3CorrectRadioButton = findViewById(R.id.musicQ3Correct);

        q4Wrong1RadioButton = findViewById(R.id.musicQ4Wrong1);
        q4Wrong2RadioButton = findViewById(R.id.musicQ4Wrong2);
        q4Wrong3RadioButton = findViewById(R.id.musicQ4Wrong3);
        q4CorrectRadioButton = findViewById(R.id.musicQ4Correct);

        MusicQuiz tmp = new MusicQuiz();

        //get ranked songs from Billboard
            q3Wrong1RadioButton.setText(tmp.getSong(3));
            q3Wrong2RadioButton.setText(tmp.getSong(6));
            q3Wrong3RadioButton.setText(tmp.getSong(7));
            q3CorrectRadioButton.setText(tmp.getSong(0));
            System.out.println("HENOESHOE" + tmp.getSong(0));
            q4Wrong1RadioButton.setText(tmp.getSong(4));
            q4Wrong2RadioButton.setText(tmp.getSong(5));
            q4Wrong3RadioButton.setText(tmp.getSong(8));
            q4CorrectRadioButton.setText(tmp.getSong(1));


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
                QuizScore.setCurrentQuiz("Music Quiz!");
                // now i set the quizScore var to the current score
                Intent intent = new Intent(MusicQuiz.this, QuizScore.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // gets song ranking form billboard charts
    public String getSong(final int setRanking) {
        ranking = setRanking;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // getting html from billboard
                    Document doc = Jsoup.connect("https://www.billboard.com/charts/billboard-200").get();

                    // getting the ordered list that is for the top 200 songs
                    Element orderedList = doc.select("ol.chart-list__elements").first();

                    // getting each list items from that ordered list
                    Elements listItems = orderedList.children();

                    // getting the list item at the ranking specified
                    Element listItem = listItems.get(setRanking);

                    // these next two steps are b/c the html is structured weirdly
                    // getting child from list item (only child is <button>)
                    Element button = listItem.children().first();

                    // getting children from button
                    Elements buttonChildren = button.children();

                    // getting second element in button children which contains song name inside another nested span
                    Element spanInfo = buttonChildren.get(1);

                    // getting (only) child from spanInfo || note "child(0)" is equivalent to "children().first()"
                    Element spanNested = spanInfo.child(0);

                    // extracting content from spanNested element
                    String songName = spanNested.ownText();

                    songNameBaby = songName;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("yoyoyoy i wrote a rap");

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }).start();
        System.out.println("Song name baby " + songNameBaby);
        return songNameBaby;
    }
}
