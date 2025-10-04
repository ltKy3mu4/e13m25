package ru.mpei.lec6;

import jade.core.Agent;
import ru.mpei.lec6.behs.PeriodicPingSenderBeh;
import ru.mpei.lec6.behs.PingReceiverBeh;
import ru.mpei.lec6.behs.PongReceiverBeh;
import ru.mpei.lec6.utils.DfUtils;

public class PingPongAgent extends Agent {

    @Override
    protected void setup() {
        DfUtils.register(this, "PingPong");
        this.addBehaviour(new PeriodicPingSenderBeh(this, 2500));
        this.addBehaviour(new PingReceiverBeh());
        this.addBehaviour(new PongReceiverBeh());
    }
}
