package classes.TickerandWaker;

import jade.core.Agent;
import jade.core.behaviours.*;

import java.util.*;

public class TickerandWakerAgent extends Agent {

    private int sec=0;
    private int secs=0;
    private int seconds=0;

    protected void setup(){
        Object[] args = getArguments();
        sec = Integer.valueOf((String) args[0]);
        secs = ((sec*1000)+100);
        seconds = sec;

        System.out.println(getAID().getLocalName() + " - Faltan :" + seconds);
        addBehaviour(new TickerBehaviour(this,1000) {
            @Override
            protected void onTick() {
                seconds--;
                if(seconds == 0){
                    stop();
                }
                System.out.println(getAID().getLocalName() + " - Faltan :" + seconds);
            }
        });

        addBehaviour(new WakerBehaviour(this,secs) {
            @Override
            protected void onWake() {
                System.out.println("OnWake - Llegó el tiempo");
                doDelete();
            }
        });
    }
    protected void takeDown(){
        System.out.println(getAID().getLocalName() + " - Terminado");
    }
}
