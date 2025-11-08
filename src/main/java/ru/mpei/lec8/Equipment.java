package ru.mpei.lec8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    private Long id;
    private EqType type;
    private String schemeName;
    private String substationId;
    private int age;

}
