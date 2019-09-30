package at.codersbay.datastructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionalTest1 {

    @Test
    public void testFractionalCreation() {
        Fractional fractional = new Fractional(1, 2);

        assertThat(fractional.getNumerator()).isEqualTo(1);
        assertThat(fractional.getDenominator()).isEqualTo(2);
    }

    @Test
    public void testFractionalCreationFails() {
        Fractional fractional = new Fractional(1, 2);

        assertThat(fractional.getNumerator()).isEqualTo(1);
        assertThat(fractional.getDenominator()).isEqualTo(2);
    }

}