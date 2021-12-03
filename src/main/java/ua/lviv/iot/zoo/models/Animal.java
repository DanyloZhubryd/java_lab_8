package ua.lviv.iot.zoo.models;

import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Data
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
@NoArgsConstructor
public abstract class Animal {
    String name;
    Integer mass;
    Integer age;
    Integer price;
}
