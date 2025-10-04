package ru.mpei.lec5.behs;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class AwakeBehaviour extends WakerBehaviour {
    public AwakeBehaviour(Agent a, Long delay) {
        super(a, delay);
    }

    @Override
    protected void onWake() {
        log.info(" I'm awake");
    }
}
