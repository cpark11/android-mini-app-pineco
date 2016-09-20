package pineco.quizapp;

import java.util.ArrayList;

/**
 * Created by Candace on 9/15/2016.
 */
public final class QuizTransfer {
    private static ArrayList<String> unfinished = new ArrayList<String>() ;
    private static ArrayList<String> finished = new ArrayList<String>() ;
    private static String MBResults;
    private static String UVAResults;

    private QuizTransfer () { // private constructor
    }
    static {
        MyersBriggsQuiz mb = new MyersBriggsQuiz();
        UVAQuiz uva = new UVAQuiz();
        unfinished.add(mb.getName());
        unfinished.add(uva.getName());
    }
    public static ArrayList<String> getUnfinished(){
        return unfinished;
    }
    public static ArrayList<String> getFinished(){
        return finished;
    }

    public static void transferToDone(int pos){
        String toMove = unfinished.remove(pos);
        finished.add(toMove);
    }
    public static String getMBResults(){
        return MBResults;
    }
    public static void setMBResults(String mb) {
        QuizTransfer.MBResults = mb;
    }
    public static String getUVAResults() {
        return UVAResults;
    }

    public static void setUVAResults(String UVAResults) {
        QuizTransfer.UVAResults = UVAResults;
    }
}