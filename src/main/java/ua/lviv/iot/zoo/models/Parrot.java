package ua.lviv.iot.zoo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;


@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)

public final class Parrot extends Bird{
	public Parrot(final String name, final Integer mass, final Integer age,
				  final Integer price, final String animalType, final String image) {
		super(name, mass, age, price, animalType, image);
	}
	public void talk(final String speech) {
		System.out.printf("Parrot says:%s", speech);
	}
	
}
