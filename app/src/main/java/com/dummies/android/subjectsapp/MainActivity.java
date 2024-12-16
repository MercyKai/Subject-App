package com.dummies.android.subjectsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText math = findViewById(R.id.math);
        EditText eng = findViewById(R.id.eng);
        EditText sci = findViewById(R.id.sci);
        EditText swa = findViewById(R.id.swa);
        EditText comp = findViewById(R.id.comp);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView totalView = findViewById(R.id.totalView);
        TextView avgView = findViewById(R.id.avgView);
        TextView gradeView = findViewById(R.id.gradeView);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String marksMath = math.getText().toString();
                String marksEng = eng.getText().toString();
                String marksSci = sci.getText().toString();
                String marksSwa = swa.getText().toString();
                String marksComp = comp.getText().toString();

                if (marksMath.isEmpty() || marksEng.isEmpty() || marksSci.isEmpty() || marksSwa.isEmpty() || marksComp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int mathMarks = Integer.parseInt(marksMath);
                int engMarks = Integer.parseInt(marksEng);
                int sciMarks = Integer.parseInt(marksSci);
                int swaMarks = Integer.parseInt(marksSwa);
                int compMarks = Integer.parseInt(marksComp);

                if (mathMarks < 0 || mathMarks > 100 ||
                        engMarks < 0 || engMarks > 100 ||
                        sciMarks < 0 || sciMarks > 100 ||
                        swaMarks < 0 || swaMarks > 100 ||
                        compMarks < 0 || compMarks > 100) {
                    Toast.makeText(MainActivity.this, "Marks must be between 0 and 100", Toast.LENGTH_SHORT).show();
                    return;
                }

                int total = mathMarks + engMarks + sciMarks + swaMarks + compMarks;
                double average = total / 5.0;
                String grade = calculateGrade(average);

                totalView.setText("Total: " + total);
                avgView.setText("Average: " + String.format("%.2f", average));
                gradeView.setText("Grade: " + grade);
            }
        });
    }

    private String calculateGrade(double average) {
        if (average >= 80 && average <= 100) {
            return "A";
        }
        else if (average >= 69 && average < 80) {
            return "B";
        }
        else if (average >= 50 && average < 69) {
            return "C";
        }
        else if (average >= 40 && average < 50) {
            return "D";
        }
        else {
            return "F";
        }
    }
}