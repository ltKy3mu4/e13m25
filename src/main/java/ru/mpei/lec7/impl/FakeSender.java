package ru.mpei.lec7.impl;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec7.SenderType;
import ru.mpei.lec7.annotations.Component;

@Component(name = "fake")
@Slf4j
public class FakeSender  {
    public void lol(String dataJson) {
        log.info("sending push to {}", dataJson);
    }
}
