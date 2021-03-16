package com.vsingh;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownHandlerPart3 extends TimerTask implements SerialPortDataListener {

    private byte n;
    private final byte timerDuration;
    private final OutputStream outputStream;

    // Constructor
    public CountdownHandlerPart3(byte timerDuration, OutputStream outputStream) {
        this.n = timerDuration;
        this.timerDuration = timerDuration;
        this.outputStream = outputStream;
    }
    // Override the run() method from TimerTask
    @Override
    public void run(){
        //System.out.println("listen: " + this.getListeningEvents());

        try{
            if(this.n > 0){
                this.outputStream.write(this.n);
                this.n -= 1;
            }else {
                this.outputStream.write(-1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // Overide the getListeningEvents() from jSerialComm.SerialPortDataListener
    @Override
    public int getListeningEvents(){
        System.out.println("rx!!");
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }
    // Override the serialEvent() from jSerialComm.SerialPortEvent
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent){
        // Check to see if the data was received from the Arduino. Doesn't matter what the
        // data was. If there was something, just reset the "duration" for the Arduino counter

        if (serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED){
            System.out.println("The Arduino is all wet");

            // Reset the countdown value. This will get sent to the Arduino
            // the next time the run() method is scheduled to execute
            this.n = timerDuration;
        }
    }
}
