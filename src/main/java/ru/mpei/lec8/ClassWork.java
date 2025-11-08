package ru.mpei.lec8;

import java.util.List;

public class ClassWork {

    public static void main(String[] args) {
        List<Equipment> equipmentList = List.of(
                new Equipment(1L, EqType.Transformer, "Tr1", "Substation1", 10),
                new Equipment(2L, EqType.CircuitBreaker, "CB2", "Substation2", 5),
                new Equipment(3L, EqType.Disconnector, "D1", "Substation1", 15),
                new Equipment(4L, EqType.EarthSwitch, "ES1", "Substation3", 7),
                new Equipment(5L, EqType.Transformer, "Tr2", "Substation2", 20),
                new Equipment(6L, EqType.CircuitBreaker, "CB1", "Substation1", 3),
                new Equipment(7L, EqType.Disconnector, "D2", "Substation3", 12),
                new Equipment(8L, EqType.EarthSwitch, "ES2", "Substation2", 8),
                new Equipment(9L, EqType.Transformer, "Tr3", "Substation3", 25),
                new Equipment(10L, EqType.CircuitBreaker, "CB3", "Substation1", 4),
                new Equipment(11L, EqType.Disconnector, "D3", "Substation2", 18)
        );
    }

}
