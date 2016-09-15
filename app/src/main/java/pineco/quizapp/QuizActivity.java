package pineco.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        MyersBriggsQuiz mb = new MyersBriggsQuiz();
        QuizQuestion q = mb.getQuestions().get(0);
        TextView question = (TextView) findViewById(R.id.quiz_question);
        question.setText(q.getText());
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setText(q.getAnswers());
    }
}
