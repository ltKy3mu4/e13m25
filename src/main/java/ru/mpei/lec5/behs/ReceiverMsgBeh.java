package ru.mpei.lec5.behs;

import jade.core.behaviours.Behaviour;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReceiverMsgBeh extends Behaviour {
    @Override
    public void action() {
        log.info("Receiving ....");
        if (true){
            this.block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
