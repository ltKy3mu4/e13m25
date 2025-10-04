package ru.mpei.lec5;

import jade.core.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mpei.lec5.behs.AwakeBehaviour;
import ru.mpei.lec5.behs.GreetingsBehaviour;
import ru.mpei.lec5.behs.HelloSpammerBehaviour;
import ru.mpei.lec5.behs.ReceiverMsgBeh;


public class MyFirstAgent extends Agent {

    private static Logger log = LoggerFactory.getLogger(MyFirstAgent.class);

    @Override
    protected void setup() {
        this.addBehaviour(new GreetingsBehaviour());
        this.addBehaviour(new HelloSpammerBehaviour(this, 3000));
        this.addBehaviour(new AwakeBehaviour(this, 1000L));
        this.addBehaviour(new ReceiverMsgBeh());
    }
}
