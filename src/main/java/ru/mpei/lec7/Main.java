package ru.mpei.lec7;

import ru.mpei.lec7.annotations.ComponentAnnotationProcessor;
import ru.mpei.lec7.impl.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ComponentAnnotationProcessor.bindAllSenders();
        List<Sender> senders = SenderContextHolder.senders;
        SenderService senderService = new SenderService(senders);
        senderService.send("{\"data\":\"hello\"}", SenderType.EMAIL);
    }
}
