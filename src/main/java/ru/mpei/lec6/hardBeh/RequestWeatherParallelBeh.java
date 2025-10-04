package ru.mpei.lec6.hardBeh;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec6.hardBeh.sub.WeatherRequestBeh;
import ru.mpei.lec6.model.WorkerData;

@Slf4j
public class RequestWeatherParallelBeh extends ParallelBehaviour {

    private WorkerData data;
    private Behaviour dataBeh;
    private WakerBehaviour wakerBeh;

    public RequestWeatherParallelBeh(WorkerData data, Agent a) {
        super(a, WHEN_ANY);
        this.data = data;
    }

    @Override
    public void onStart() {
        dataBeh = new WeatherRequestBeh(data);
        wakerBeh = new WakerBehaviour(myAgent, 30000) {
            @Override
            protected void onWake() {
                log.info("Time is out");
            }
        };
        this.addSubBehaviour(dataBeh);
        this.addSubBehaviour(wakerBeh);
    }

    @Override
    public int onEnd() {
        if (dataBeh.done()){
            log.info("Weather request completed");
        }
        if (wakerBeh.done()){
            log.info("Weather request failed");
        }
        return dataBeh.done() && data.getTemperature() != null  ? 1 : 2;
    }
}
