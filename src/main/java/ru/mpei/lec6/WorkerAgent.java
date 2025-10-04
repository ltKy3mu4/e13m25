package ru.mpei.lec6;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec6.hardBeh.RequestWeatherParallelBeh;
import ru.mpei.lec6.model.WorkerData;

@Slf4j
public class WorkerAgent extends Agent {
    @Override
    protected void setup() {
        log.info("WorkerAgent setup");
        WorkerData data = new WorkerData();
        addBehaviour(new RequestWeatherParallelBeh(data, this));
        addBehaviour(new TickerBehaviour(this, 300) {
            @Override
            protected void onTick() {
                log.info("Data : {}", data);
            }
        });
    }
}
