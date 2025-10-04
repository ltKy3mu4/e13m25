package ru.mpei.lec5.behs;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloSpammerBehaviour extends TickerBehaviour {
    private  int counter;
    public HelloSpammerBehaviour(Agent a, long period) {
        super(a, period);
    }

    @Override
    public void onStart() {
        log.info("Spammer beh started {}", myAgent.getLocalName());
    }

    @Override
    protected void onTick() {
        log.warn("Spam spam spam {}", counter++);

        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setContent("Hello from "+myAgent.getLocalName());
        msg.addReceiver(this.chooseReceiver());

        myAgent.send(msg);

        if (counter >= 10){
            stop();
        }
    }

    @Override
    public int onEnd(){
        log.info("Spammer ended {}", myAgent.getLocalName());
       return 0;
    }

    private AID chooseReceiver(){
        if (myAgent.getLocalName().equals("AgentSmith")){
            return new AID("AgentNeo", false);
        } else {
            return new AID("AgentSmith", false);
        }
    }
}
