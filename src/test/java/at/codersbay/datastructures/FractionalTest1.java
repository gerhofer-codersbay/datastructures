package at.codersbay.datastructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionalTest1 {

    @Test
    // A fractional can be created if positive natural numbers are passed as numerator and denominator
    public void testFractionalCreation() {
        Fractional fractional = new Fractional(1, 2);

        assertThat(fractional.getNumerator()).isEqualTo(1);
        assertThat(fractional.getDenominator()).isEqualTo(2);
    }

    @Test
    // A fractional can be created if a negative natural numbers is passed as denominator
    public void testCreationWithNegativeNumerator() {
        Fractional fractional = new Fractional(1, -2);

        assertThat(fractional.getNumerator()).isEqualTo(1);
        assertThat(fractional.getDenominator()).isEqualTo(-2);
    }

    @Test
    // A fractional can be created if a negative natural numbers is passed as numerator
    public void testCreationWithNegativeDenominator() {
        Fractional fractional = new Fractional(-1, 2);

        assertThat(fractional.getNumerator()).isEqualTo(-1);
        assertThat(fractional.getDenominator()).isEqualTo(2);
    }

    @Test
    // An IllegalArgumentException should be thrown when a null denominator is passed
    public void testCreationWithNullDenominator() {
        assertThrows(IllegalArgumentException.class,
                () -> new Fractional(1, null));
    }

    @Test
    // An IllegalArgumentException should be thrown when a null numerator is passed
    public void testCreationWithNullNumerator() {
        assertThrows(IllegalArgumentException.class,
                () -> new Fractional(null, 2));
    }

    @Test
    // An IllegalArgumentException should be thrown when 0 is passed for the denominator
    public void testCreationWithZeroDenominator() {
        assertThrows(IllegalArgumentException.class,
                () -> new Fractional(2, 0));
    }

    @Test
    // Passing 0 for the numerator is valid
    public void testCreationWithZeroNumerator() {
        Fractional fractional = new Fractional(0, 2);

        assertThat(fractional.getNumerator()).isEqualTo(0);
        assertThat(fractional.getDenominator()).isEqualTo(2);
    }
}
