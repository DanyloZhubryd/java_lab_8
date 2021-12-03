package ua.lviv.iot.zoo.models;

import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
@NoArgsConstructor
public abstract class Bird extends Animal {
	String animalType;
	String image;
	public Bird(final String name, final Integer mass, final Integer age,
				final Integer price, final String animalType, final String image) {
        super(name, mass, age, price);
        this.animalType = animalType;
		this.image = image;
	}
}
