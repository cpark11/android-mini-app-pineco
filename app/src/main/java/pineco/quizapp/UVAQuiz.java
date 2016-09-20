package pineco.quizapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiexi on 9/19/2016.
 */
public class UVAQuiz implements Quiz {

    private int[] results;
    public UVAQuiz(){
        resetResults();
        questionList = new ArrayList<QuizQuestion>(Arrays.asList(
                new Question(
                        "What is the most famous building at UVA:",
                        new Answer[]{
                                new Answer("The Rotunda",1),
                                new Answer("Alderman Library",2)
                        },0
                ),
                new Question(
                        "How many dining halls does UVA have:",
                        new Answer[]{
                                new Answer("3",1),
                                new Answer("4",2)
                        },1
                ),
                new Question(
                        "Who is the President of UVA:",
                        new Answer[]{
                                new Answer("Theresa Sullivan",1),
                                new Answer("Allen Groves",2)
                        },2
                ),
                new Question(
                        "Which bus takes you downtown:",
                        new Answer[]{
                                new Answer("Trolley",1),
                                new Answer("Northline",2)
                        },3
                )
        )
        );
    }
    private List<QuizQuestion> questionList;
    public List<QuizQuestion> getQuestions() {
        return this.questionList;
    }
    private class Question implements QuizQuestion{
        String questionText;
        Answer answers[];
        int index;

        public Question(String questionText, Answer answers[], int i) {
            this.questionText = questionText;
            this.answers = answers;
            this.index=i;
        }

        public QuizEntity[] getAnswers()
        {
            return answers;
        }

        public String getText()
        {
            return questionText;
        }
    }
    private class Answer implements QuizEntity{
        String answerText;
        int index;
        public Answer(String answerText, int i) {
            this.answerText = answerText;
            this.index=i;
        }

        public String getText()
        {
            return answerText;
        }
    }
    public String getName()
    {
        return "UVA Quiz";
    }
    public String getResult(){
        int count=0;
        for(int i=0;i<results.length;i++){
            if(results[i]==1)
                count++;
        }
        return count+"/4 correct!";
    }
    public void recordResponse(QuizQuestion q, QuizEntity a)
    {
        Question question = (Question)q;
        Answer answer = (Answer)a;
        results[question.index] = answer.index;
    }
    public void resetResults()
    {
        // Reset the results to 0
        results = new int[4];
        for (int i = 0; i < results.length; i++) {
            results[i] = 0;
        }
    }
}
