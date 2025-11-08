package ru.mpei.lec7.impl;

import ru.mpei.lec7.SenderType;

public interface Sender {

    void send(String dataJson);

    SenderType getType();
}
