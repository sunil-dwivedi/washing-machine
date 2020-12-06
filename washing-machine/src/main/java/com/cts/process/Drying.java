package com.cts.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("drying")
public class Drying extends Process {
    public Drying() {
    }

    public Drying(Long duration, Integer temperature, Integer rotationSpeed) {
        super(duration, temperature, rotationSpeed);
    }

    @Override
    public String toString() {
        return "Drying " + super.toString();
    }
}
