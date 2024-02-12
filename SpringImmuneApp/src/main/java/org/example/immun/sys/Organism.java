package org.example.immun.sys;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Organism {
    private final Immunity rabiesImmunity;
    private final Immunity coronaImmunity;
    private final Immunity flueImmunity;

    public Organism(@Qualifier("immunityRabies") Immunity rabiesImmunity,
                    @Qualifier("immunityCorona") Immunity coronaImmunity,
                    @Qualifier("immunityFlue") Immunity flueImmunity) {
        this.rabiesImmunity = rabiesImmunity;
        this.coronaImmunity = coronaImmunity;
        this.flueImmunity = flueImmunity;
    }

    @Override
    public String toString() {
        return "Organism{" +
                "rabiesImmunity=" + rabiesImmunity +
                ", coronaImmunity=" + coronaImmunity +
                ", flueImmunity=" + flueImmunity +
                '}';
    }
}