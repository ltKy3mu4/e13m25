package ru.mpei.lec5.behs;

import jade.core.behaviours.OneShotBehaviour;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GreetingsBehaviour extends OneShotBehaviour {

    @Override
    public void onStart() {
        log.info("{} started behaviour GreetingsBehaviour", myAgent.getLocalName());
    }

    @Override
    public void action() {
        log.info("Lol i was born {}", this.myAgent.getLocalName());
    }

    @Override
    public int onEnd() {
        log.info("{} stopped behaviour GreetingsBehaviour", myAgent.getLocalName());
        return 0;
    }
}
