package ru.mpei.lec6.hardBeh.sub;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec6.model.WorkerData;
import ru.mpei.lec6.utils.DfUtils;

import java.util.List;

@Slf4j
public class WeatherRequestBeh extends Behaviour {
    private WorkerData data;
    private boolean done = false;

    public WeatherRequestBeh(WorkerData data) {
        this.data = data;
    }

    @Override
    public void onStart() {
        List<AID> recs= DfUtils.search(myAgent, "weather");
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.setProtocol("Weather");
        for(AID agent: recs){
            msg.addReceiver(agent);
        }
        myAgent.send(msg);
        log.info("Requested Weather");
    }

    @Override
    public void action() {
        ACLMessage m = myAgent.receive(MessageTemplate.and(
                MessageTemplate.MatchProtocol("Weather"),
                MessageTemplate.MatchPerformative(ACLMessage.INFORM))
        );
        if (m != null) {
            done = true;
            data.setTemperature(Double.parseDouble(m.getContent()));
            log.info("Weather response received {}", data.getTemperature());
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
            return done;
    }

    @Override
    public int onEnd() {
        return super.onEnd();
    }
}
