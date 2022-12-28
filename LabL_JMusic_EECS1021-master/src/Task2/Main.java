package Task2;

import jm.JMC;


public class Main {

    public static void main(String[] args) {
        RandomMelody rm = new RandomMelody("Vikram");
        rm.generateRandomNotes(2);
        // include 24 pitches of a song you would like to play
        int[] pitchArray = {JMC.G3, JMC.G3, JMC.A3,JMC.G3,JMC.C4,JMC.B3,
                JMC.G3, JMC.G3, JMC.A3,JMC.G3,JMC.C4,JMC.B3,
                JMC.G3, JMC.G3, JMC.A3,JMC.G3,JMC.C4,JMC.B3,};
        rm.addASong(JMC.PIANO,pitchArray);
        // Demo for play and save methods
        //rm.play();
        //rm.save();
        // Demo for clear method
        rm.clear();
        rm.play();

    }
}
