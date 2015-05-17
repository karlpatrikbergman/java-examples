package se.patrikbergman.java.lombok;

import lombok.Data;

@Data(staticConstructor="of")
public class Animal {
    private final String name;
    private final int age;
}
