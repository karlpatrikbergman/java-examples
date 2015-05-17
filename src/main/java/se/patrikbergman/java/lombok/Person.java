package se.patrikbergman.java.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor(staticName="of")
class Person {
    private final String name;
    private final int age;

}
