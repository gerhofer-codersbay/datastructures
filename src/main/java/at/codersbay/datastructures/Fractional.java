package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {
	
	private Integer numerator;
	private Integer denominator;

    public Fractional(Integer numerator, Integer denominator) {
    	/*numerator can be 0 but not null*/
    	if(numerator == null) {
    		throw new IllegalArgumentException();
    	} else {
    		this.numerator = numerator;
    	}
    	
    	/*denominator cant be 0 or null*/
    	if(denominator == null || denominator == 0) {
    		throw new IllegalArgumentException();
    	} else {
    		this.denominator = denominator;
    	}
        
    }
    
    public Fractional invertedFractional(Fractional fractional) {
    	Fractional returnFractional = new Fractional(
    		fractional.getDenominator(), fractional.getNumerator());
    	return returnFractional;	
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
		Fractional fractionalObject;
		/*!Obj is not a Fractional or is null*/
		if (!obj.getClass().equals(this.getClass()) || obj == null) {
			throw new IllegalArgumentException();
		}
		fractionalObject = (Fractional) obj;
		if (fractionalObject.getDenominator() == 0
				|| fractionalObject.getDenominator() == null
				|| fractionalObject.getNumerator() == null) {
			throw new IllegalArgumentException();	
		}
		/*Denom & Num are both equal*/
		if (fractionalObject.getNumerator() == this.getNumerator()
				&& fractionalObject.getDenominator() 
				== this.getDenominator()) {
			return true;
		}
		/*Numerator is 0*/
		if(fractionalObject.getNumerator() == 0 
				&& this.getNumerator() == 0) {
			return true;
		}
		/*Numerators are equal after multiplication with other
		 * fractionals denominator*/
		if(this.getNumerator()*fractionalObject.getDenominator() 
			== fractionalObject.getNumerator()*this.getDenominator()) 
		{
			return true;
		}
		

		return false;
	}

    public Fractional multiply(Fractional other) {
    	Integer calcDenom = 0;
    	Integer calcNum = 0;
    	calcDenom = this.getDenominator()*other.getDenominator();
    	calcNum = this.getNumerator()*other.getNumerator();
    	
        return new Fractional(calcNum, calcDenom);
    }

    public Fractional multiply(Integer other) {
        return new Fractional((this.getNumerator()*other),(this.getDenominator()));
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
    	int newDenom = 0;
    	int newNum = 0;
    	newNum = this.getNumerator()*other.getDenominator()+
    			other.getNumerator()*this.getDenominator();
    	newDenom = this.getDenominator()*other.getDenominator();
        return new Fractional(newNum,newDenom);
    }

    public Fractional add(Integer other) {
    	if (other == null) {
    		throw new IllegalArgumentException();
    	}
        return this.add(new Fractional(other, 1));
    }

    public Fractional subtract(Fractional other) {
     	int newDenom = 0;
    	int newNum = 0;
    	newNum = this.getNumerator()*other.getDenominator()-
    			other.getNumerator()*this.getDenominator();
    	newDenom = this.getDenominator()*other.getDenominator();
        return new Fractional(newNum,newDenom);
    }

    public Fractional subtract(Integer other) {
        return this.subtract(new Fractional(other,1));
    }

}