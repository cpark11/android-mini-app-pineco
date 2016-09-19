package pineco.quizapp;

import java.util.ArrayList;

/**
 * Created by Candace on 9/15/2016.
 */
public final class QuizTransfer {
    private static ArrayList<String> unfinished = new ArrayList<String>() ;
    private static ArrayList<String> finished = new ArrayList<String>() ;
    private QuizTransfer () { // private constructor
    }
    static {
        MyersBriggsQuiz mb = new MyersBriggsQuiz();
        unfinished.add(mb.getName());
        unfinished.add("Other Quiz");
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
        // tell quiz it's moved??
    }
}