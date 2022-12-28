package Task2;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.Write;

public class RandomMelody {
    private Score score;
    private Part snare; // Snare drum part
    private Phrase phrase;
    private Note[] notesArray = new Note[24];
    private double[] rhythmValuesRandom = new double[24];


    RandomMelody(String scoreTitle){

        this.score = new Score(scoreTitle);
        this.snare = new Part("Snare",0,9);
        this.phrase = new Phrase(0.0);

        this.score.add(this.snare);// Adding part object to score object
        this.snare.add(this.phrase);// Adding phrase object to part object
    }

    // Lab Task 2 : Play a Song with Random Rhythm
    // addASong method
    // Part Object example
    // part Snare = new Part("Snare",0,9);
    public void addASong (int instrument, int[] pitchlist){
        Part localPart = new Part(instrument); // new part
        Phrase localPhrase = new Phrase(0.0); // new phrase
        //localPart.add(localPhrase); // Add the phrase to our new part
        // Add 24 notes to our new phrase using this method
        localPhrase.addNoteList(pitchlist,this.rhythmValuesRandom);
        localPart.add(localPhrase); // Add the phrase to our new part
        this.score.add(localPart);// Add the part to our score attribute


    }

    public void generateRandomNotes(int maxInterval){

        //Note[] notes = new Note[24];
        //double[] randomValues = new double[24];

        for(int i = 0; i < 24; i++){
            double rhythm = maxInterval * Math.random();
            Note myNote = new Note(38, rhythm);
            this.notesArray[i] = myNote;
            //randomValues[i] = rhythm;
            this.rhythmValuesRandom[i] = rhythm;
        }
        /* Not required
        Phrase phrase = new Phrase(this.notesArray);
        Play playPhrase = new Play();
        playPhrase.midi(phrase);*/
    }
    // Create a play method
    public void play(){
        Play.midi(this.score); // pass on score attribute
    }
    // Create a save method
    public void save(){
        Write.midi(this.score,this.score.getTitle() + ".mid");
    }
    // Add a clear Method
    public void clear(){
        this.score = new Score();// reset the score
        this.snare = new Part("Snare",0,9);// reset the part
        this.phrase = new Phrase(0.0);
        this.rhythmValuesRandom = new double[24];

    }

}