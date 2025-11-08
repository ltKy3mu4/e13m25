package ru.mpei.lec7;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec7.impl.Sender;

import java.util.List;

@Slf4j
public class SenderService {

    private List<Sender> senders;

    public SenderService(List<Sender> senders) {
        this.senders = senders;
    }


    public void send(String dataJson, SenderType senderType) {
        for (Sender sender : senders) {
            if (sender.getType() == senderType) {
                sender.send(dataJson);
                return;
            }
        }
        log.error("incorrect sender type: {}", senderType);
        throw new IllegalArgumentException("sender type not found");
    }
}
