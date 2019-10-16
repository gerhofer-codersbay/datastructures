package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {
	
	private Integer numerator;
	private Integer denominator;

    public Fractional(Integer numerator, Integer denominator) {
    	/*numerator can be zero but not null*/
    	if(numerator == null) {
    		throw new IllegalArgumentException("You shall not pass null!");
    	} else {
    		this.numerator = numerator;
    	}
    	
    	/*denominator can not be zero or null*/
    	if(denominator == null) {
    		throw new IllegalArgumentException("You shall not pass null!");
    	} else if (denominator == 0){
    		throw new IllegalArgumentException("You shall not pass zero!");
    	}
    	else {
    		this.denominator = denominator;
    	}
        
    }
    
    public Fractional invertedFractional(Fractional fractional) {
    	Fractional fractionalObject = new Fractional(
    		fractional.getDenominator(), fractional.getNumerator());
    	return fractionalObject;	
    }

    public Integer getNumerator() {
        return this.numerator;
    }

    public Integer getDenominator() {
        return this.denominator;
    }

    public Float asFloat() {
        return  ((float)this.numerator/(float) this.denominator);
    }

	@Override
	public boolean equals(Object obj) {
		isValidFractional(obj); 
		return numAndDenomMatch((Fractional) obj) || bothNumAreZero((Fractional) obj)
				|| expandedNumsMatch((Fractional) obj);
	}

	private Boolean expandedNumsMatch(Fractional fractionalObject) {
		return (this.getNumerator() * fractionalObject.getDenominator() == fractionalObject.getNumerator()
				* this.getDenominator());

	}

	private Boolean bothNumAreZero(Fractional fractionalObject) {
		return (fractionalObject.getNumerator() == 0 && this.getNumerator() == 0);

	}

	private Boolean numAndDenomMatch(Fractional fractionalObject) {
		return (fractionalObject.getNumerator() == this.getNumerator()
				&& fractionalObject.getDenominator() == this.getDenominator());
	}

	private Boolean isValidFractional(Object obj) {
		if (!obj.getClass().equals(this.getClass()) || obj == null) {
			throw new IllegalArgumentException("Object is not a fractional or is null");
		}
		Fractional fractionalObject = (Fractional) obj;
		if (fractionalObject.getDenominator() == 0 || fractionalObject.getDenominator() == null
				|| fractionalObject.getNumerator() == null) {
			throw new IllegalArgumentException("You shall not pass null!");
		}
		return true;
	}

    public Fractional multiply(Fractional other) {
    	Integer newDenom = this.getDenominator()*other.getDenominator();;
    	Integer newNum = this.getNumerator()*other.getNumerator();
        return new Fractional(newNum, newDenom);
    }

    public Fractional multiply(Integer other) {
        return this.multiply(new Fractional(other,1));
    }

    public Fractional divide(Fractional other) {
    	/*division by multiplication with the invers*/ 
    	return this.multiply(this.invertedFractional(other));
    }

    public Fractional divide(Integer other) {
    	if (other == null || other == 0) {
    		throw new IllegalArgumentException();
    	} 
    	return this.divide(new Fractional(other,1));
    }

    public Fractional add(Fractional other) {
    	Integer newNum = this.getNumerator()*other.getDenominator()+
    			other.getNumerator()*this.getDenominator();
    	Integer newDenom = this.getDenominator()*other.getDenominator();
        return new Fractional(newNum,newDenom);
    }

    public Fractional add(Integer other) {
    	if (other == null) {
    		throw new IllegalArgumentException();
    	}
        return this.add(new Fractional(other, 1));
    }

    public Fractional subtract(Fractional other) {
    	Integer newNum = this.getNumerator()*other.getDenominator()-
    			other.getNumerator()*this.getDenominator();
    	Integer newDenom = this.getDenominator()*other.getDenominator();
        return new Fractional(newNum,newDenom);
    }

    public Fractional subtract(Integer other) {
    	if (other == null) {
    		throw new IllegalArgumentException();
    	}
        return this.subtract(new Fractional(other,1));
    }

}