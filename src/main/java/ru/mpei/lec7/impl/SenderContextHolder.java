package ru.mpei.lec7.impl;

import java.util.ArrayList;
import java.util.List;

public class SenderContextHolder {

//    public static List<Sender> senders = List.of(
//            new EmailSender(),
//            new SmsSender(),
//            new PushSender()
//    );

    public static List<Sender> senders = new ArrayList<>();
}
