package ru.mpei.lec6.behs;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec5.utils.JsonUtils;
import ru.mpei.lec6.model.Ping;
import ru.mpei.lec6.utils.DfUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PeriodicPingSenderBeh extends TickerBehaviour {
    public PeriodicPingSenderBeh(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        List<AID> aids = DfUtils.search(myAgent, "PingPong");
        log.info("Sent ping to {}", aids);
        ACLMessage msg = new ACLMessage(ACLMessage.CFP);
        for (AID r: aids){
            msg.addReceiver(r);
        }
        msg.setContent(JsonUtils.toJson(new Ping("ping")));
        myAgent.send(msg);
    }

//    private List<AID> getReceivers(){
//        List<AID> receivers = new ArrayList<>(List.of(
//                new AID("PP1", false),
//                new AID("PP2", false),
//                new AID("PP3", false)
//        ));
//        receivers.remove(new AID(myAgent.getLocalName(), false));
//        return receivers;
//    }
}
