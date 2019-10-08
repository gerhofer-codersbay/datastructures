package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {
	
	private final Integer numerator;
	private final Integer denominator;

    public Fractional(Integer numerator, Integer denominator) throws IllegalArgumentException {
    	if (numerator == null || denominator == null) {
    		throw new IllegalArgumentException("You shall not pass null!");
    	} else if (denominator == 0) {
			throw new IllegalArgumentException("You shall not divide through zero!");
		} else {
			this.numerator = numerator;
			this.denominator = denominator;
		}
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public Float asFloat() {
    	Float result = ((float) this.numerator / (float) this.denominator);
        return result;
    }

    @Override
	public boolean equals(Object obj) {
		// TODO handle cases where a non-fractional is passed as an argument
		Fractional other = (Fractional) obj;
		boolean result = false;
		int numerator1 = this.getNumerator();
		int numerator2 = other.getNumerator();
		int denominator1 = this.getDenominator();
		int denominator2 = other.getDenominator();
		if (numerator1 == 0 && numerator2 == 0) {
			result = true;
		} else if (numerator1 == numerator2 && denominator1 == denominator2) {
			result = true;
		} else {
			int commonDivisor1 = greatestCommonDivisor(numerator1, denominator1);
			int commonDivisor2 = greatestCommonDivisor(numerator2, denominator2);
			numerator1 /= commonDivisor1;
			denominator1 /= commonDivisor1;
			numerator2 /= commonDivisor2;
			denominator2 /= commonDivisor2;
			if (numerator1 == numerator2 && denominator1 == denominator2) {
				result = true;
			}
		}
		return result;
	}
    
    private int greatestCommonDivisor(int numerator, int denominator) {
    	int result = 1;
    	if (denominator == 0) {
    		result = numerator;
    	} else {
    		result = greatestCommonDivisor(denominator, (numerator % denominator));
    	}
    	return result;
    }

    public Fractional multiply(Fractional other) {
        // TODO implement to fix tests in FractionalTest4
        return new Fractional(1, 1);
    }

    public Fractional multiply(Integer other) {
        // TODO implement to fix tests in FractionalTest4
        return new Fractional(1, 1);
    }

    public Fractional divide(Fractional other) {
        // TODO implement to fix tests in FractionalTest5
        return new Fractional(1, 1);
    }

    public Fractional divide(Integer other) {
        // TODO implement to fix tests in FractionalTest5
        return new Fractional(1, 1);
    }

    public Fractional add(Fractional other) {
        // TODO implement to fix tests in FractionalTest6
        return new Fractional(1, 1);
    }

    public Fractional add(Integer other) {
        // TODO implement to fix tests in FractionalTest6
        return new Fractional(1, 1);
    }

    public Fractional subtract(Fractional other) {
        // TODO implement to fix tests in FractionalTest7
        return new Fractional(1, 1);
    }

    public Fractional subtract(Integer other) {
        // TODO implement to fix tests in FractionalTest7
        return new Fractional(1, 1);
    }

}