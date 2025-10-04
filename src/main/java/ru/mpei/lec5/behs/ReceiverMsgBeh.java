package ru.mpei.lec5.behs;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec5.model.HelloMsg;
import ru.mpei.lec5.utils.JsonUtils;

import java.util.Optional;

@Slf4j
public class ReceiverMsgBeh extends Behaviour {
//    private boolean stopped = false;
    @Override
    public void action() {
        log.info("Receiving ....");
        ACLMessage msg = myAgent.receive();
        if (msg != null){
            Optional<HelloMsg> c = JsonUtils.fromJson(msg.getContent(), HelloMsg.class);
            if (c.isPresent()) {
                log.info("Received [{}]", c.get());
            } else {
                log.error("cannot parse msg from {} to json (content: {})", msg.getSender().getLocalName(), msg.getContent());
            }
//            stopped = true;
        } else {
            this.block();
        }
    }

    @Override
    public boolean done() {
        return false;
//        return stopped;
    }
}
