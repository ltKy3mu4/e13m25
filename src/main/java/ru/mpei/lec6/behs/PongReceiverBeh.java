package ru.mpei.lec6.behs;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec5.utils.JsonUtils;
import ru.mpei.lec6.model.Pong;

@Slf4j
public class PongReceiverBeh extends Behaviour {
    private MessageTemplate mt;

    @Override
    public void onStart() {
        mt =MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
    }

    @Override
    public void action() {
        ACLMessage m = myAgent.receive(mt);
        if (m != null) {
            log.info("Received Pong msg from {} with {}", m.getSender().getLocalName(), m.getContent());
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
