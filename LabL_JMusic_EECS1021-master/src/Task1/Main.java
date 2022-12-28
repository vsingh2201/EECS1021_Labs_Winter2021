package Task1;


import jm.music.data.Score;
import jm.util.Play;
import jm.util.Read;
import jm.util.View;

public class Main {
    public static void main(String[] args) {

        RandomRhythm randomRhythm = new RandomRhythm();
        randomRhythm.generateRandomNotes(5);

        // Lab Report Part
        Play file = new Play();// Creating a Play Object
        file.mid("LabReport.mid"); // Playing the Midi file
        Score score = new Score("lab report score");// Creating a score object
        Read.midi(score,"LabReport.mid"); // Load the midi file to a score
        View.sketch(score);// Pass the score variable to View.sketch

    }
}
