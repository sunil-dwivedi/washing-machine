package com.cts.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("squeaking")
public class Squeaking extends Process {
    public Squeaking() {
    }

    public Squeaking(Long duration, Integer temperature, Integer rotationSpeed) {
        super(duration, temperature, rotationSpeed);
    }

    @Override
    public String toString() {
        return "Squeaking " + super.toString();
    }
}
