package ru.mpei.lec7.impl;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec7.SenderType;
import ru.mpei.lec7.annotations.Component;

@Component(name = "push")
@Slf4j
public class PushSender implements Sender {
    @Override
    public void send(String dataJson) {
        log.info("sending push to {}", dataJson);
    }

    @Override
    public SenderType getType() {
        return SenderType.PUSH;
    }
}
