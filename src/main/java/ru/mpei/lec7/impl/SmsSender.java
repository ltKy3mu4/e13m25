package ru.mpei.lec7.impl;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec7.SenderType;
import ru.mpei.lec7.annotations.Component;

@Component(name = "sms")
@Slf4j
public class SmsSender implements Sender {
    @Override
    public void send(String dataJson) {
        log.info("sending sms to {}", dataJson);
    }

    @Override
    public SenderType getType() {
        return SenderType.SMS;
    }
}
