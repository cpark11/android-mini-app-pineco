package pineco.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UVAActivity extends AppCompatActivity {

    UVAQuiz mb;
    QuizQuestion currQuestion;
    TextView question;
    Button b1;
    Button b2;
    int i;
    ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uva);
        mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        mb = new UVAQuiz();
        i = 0;
        mProgress.setProgress((int) ((i + 1) / 0.04));
        currQuestion = mb.getQuestions().get(i);
        question = (TextView) findViewById(R.id.quiz_question);
        question.setText(currQuestion.getText());
        b1 = (Button) findViewById(R.id.b1);
        b1.setText(currQuestion.getAnswers()[0].getText());
        b2 = (Button) findViewById(R.id.b2);
        b2.setText(currQuestion.getAnswers()[1].getText());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.recordResponse(currQuestion, currQuestion.getAnswers()[0]);
                i++;
                if (i == mb.getQuestions().size()) {
                    System.out.println(i);
                    question.setText(mb.getResult());
                    endQuiz();

                } else {
                    mProgress.setProgress((int) ((i + 1) / 0.04));
                    currQuestion = mb.getQuestions().get(i);
                    question.setText(currQuestion.getText());
                    b1.setText(currQuestion.getAnswers()[0].getText());
                    b2.setText(currQuestion.getAnswers()[1].getText());
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.recordResponse(currQuestion, currQuestion.getAnswers()[1]);
                i++;
                if (i == mb.getQuestions().size())
                    endQuiz();
                else {
                    mProgress.setProgress((int) ((i + 1) / 0.04));
                    currQuestion = mb.getQuestions().get(i);
                    question.setText(currQuestion.getText());
                    b1.setText(currQuestion.getAnswers()[0].getText());
                    b2.setText(currQuestion.getAnswers()[1].getText());
                }
            }
        });
    }
    public void endQuiz(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnHome = new Intent(v.getContext(), MainView.class);
                v.getContext().startActivity(returnHome);
            }
        });
        b1.setText("Return to Quiz List");
        b2.setVisibility(View.INVISIBLE);
        String r = mb.getResult();
        question.setText(r);
        QuizTransfer.setUVAResults(r);
    }
}
