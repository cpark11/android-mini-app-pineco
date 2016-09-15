package pineco.quizapp;
import java.util.List;

public interface Quiz
{
    String getName();
    String getResult();
    void recordResponse(QuizQuestion q, QuizEntity a);
    void resetResults();
    List<QuizQuestion> getQuestions();
}
