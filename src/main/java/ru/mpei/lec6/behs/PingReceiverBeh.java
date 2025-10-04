package ru.mpei.lec6.behs;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec5.utils.JsonUtils;
import ru.mpei.lec6.model.Pong;

@Slf4j
public class PingReceiverBeh extends Behaviour {
    private MessageTemplate mt;

    @Override
    public void onStart() {
        mt =MessageTemplate.MatchPerformative(ACLMessage.CFP);
    }

    @Override
    public void action() {
        ACLMessage m = myAgent.receive(mt);
        if (m != null) {
            log.info("Received Ping msg from {} with {}", m.getSender().getLocalName(), m.getContent());
            ACLMessage answer = new ACLMessage(ACLMessage.PROPOSE);
            answer.addReceiver(m.getSender());
            answer.setContent(JsonUtils.toJson(new Pong("Pong")));
            myAgent.send(answer);
            log.info("Sent pong to {}", m.getSender().getLocalName());
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
