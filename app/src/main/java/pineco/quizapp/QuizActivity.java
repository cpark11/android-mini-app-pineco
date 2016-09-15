package pineco.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    MyersBriggsQuiz mb;
    QuizQuestion currQuestion;
    TextView question;
    Button b1;
    Button b2;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mb = new MyersBriggsQuiz();
        i=0;
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
                if(i==mb.getQuestions().size()-1){
                    System.out.println(i);
                    question.setText(mb.getResult());
                    endQuiz();

                }
                currQuestion = mb.getQuestions().get(i);
                question.setText(currQuestion.getText());
                b1.setText(currQuestion.getAnswers()[0].getText());
                b2.setText(currQuestion.getAnswers()[1].getText());

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.recordResponse(currQuestion, currQuestion.getAnswers()[1]);
                i++;
                if(i==mb.getQuestions().size()-1)
                    endQuiz();
                currQuestion = mb.getQuestions().get(i);
                question.setText(currQuestion.getText());
                b1.setText(currQuestion.getAnswers()[0].getText());
                b2.setText(currQuestion.getAnswers()[1].getText());
            }
        });
    }
    public void endQuiz(){
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        //question.setVisibility(View.INVISIBLE);
        System.out.println(mb.getResult());
        TextView question = (TextView) findViewById(R.id.quiz_question);
        question.setText(mb.getResult());
    }
}
