package Task1;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class RandomRhythm {

    // Constructor
    RandomRhythm(){

    }

    public  void generateRandomNotes(int maxInterval){

        Note[] notes = new Note[24];
        for(int i = 0; i < 24; i++){
            Note myNote = new Note(38, maxInterval * Math.random());
            notes[i] = myNote;
        }
        Phrase phrase = new Phrase(notes);
        Play playPhrase = new Play();
        playPhrase.midi(phrase);
    }
}
