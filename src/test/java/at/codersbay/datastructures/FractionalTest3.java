package at.codersbay.datastructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class FractionalTest2 {

    @Test
    public void testFractionalOneHalf() {
        Fractional fractional = new Fractional(1, 2);

        assertThat(fractional.asFloat()).isEqualTo(0.5);
    }

    @Test
    public void testFractionalZero() {
        Fractional fractional = new Fractional(0, 2);

        assertThat(fractional.asFloat()).isEqualTo(0.5);
    }

    @Test
    public void testFractionalGreaterThanOne() {
        Fractional fractional = new Fractional(7, 8);

        assertThat(fractional.asFloat()).isEqualTo(1.75);
    }

    @Test
    public void testFractionalOneThird() {
        Fractional fractional = new Fractional(1, 3);

        assertThat(fractional.asFloat()).isEqualTo(0.33333f, within(0.00001f));
    }
}
