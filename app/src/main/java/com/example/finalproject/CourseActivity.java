package com.example.finalproject;

import android.os.Bundle;

public class CourseActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
    /** dept of course, ex: MATH, CS, ECE. */
    private String courseDept;
    /** course number, ex: 101, 470 */
    private int courseNum;
    /** name of course, ex: Introduction to Computer Science.(might be able to omit this field). */
    private String courseName;
}
