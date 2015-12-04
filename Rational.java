// Team ? -- Jiawei Chen, Sean Bourke
// APCS1 pd9
// HW #41: In America, the Driver Sits on the Left
// 2015-11-24

public class Rational implements Comparable{
    public int numerator;
    public int denominator;
    
    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("STOP DIVIDING BY 0!!!!!!!");
            this.denominator = 1;
            this.numerator = 0;
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public float floatValue(){
        return this.numerator / this.denominator;
    }
    
    
    public void multiply(Rational other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
    }
    
    public void divide(Rational other) {
        this.numerator *= other.denominator;
        this.denominator *= other.numerator;
    }
    
    public void add(Rational other){
        int thisOriginal = this.denominator;
        if (this.denominator != other.denominator){
            this.numerator *= other.denominator;
            this.denominator *= other.denominator;
            other.numerator *= thisOriginal;
        }
        this.numerator += other.numerator;
    }
    
    public void subtract(Rational other){
        int thisOriginal = this.denominator;
        if (this.denominator != other.denominator){
            this.numerator *= other.denominator;
            this.denominator *= other.denominator;
	}
        this.numerator -= other.numerator * thisOriginal;
    }
    
    public int gcdEW(){
        int gcd = 0;
        int a = this.numerator;
        int b = this.denominator;
        if (a == 0){
            return b;
        }
        while (a != 0 || b != 0){
            if (a > b) {
                if (a % b == 0){
		    gcd = b;
		}
                a = a % b;
            }
            else {
                if ( b % a == 0){
		    gcd = a;
		}
                b = b % a;
            }
        }
        return gcd;
    }
    
    public void reduce(){
        int gcd = gcdER(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }
    /*=====================PHASE 3=====================*/
    public static int gcdER (int a, int b){
        if ((a == b) || (b == 0)){
            return a;} //returns the GCD.
        else if (a < b){
            return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
        else{
            return gcdER (b , (a-b));
        }
    }

    public int compareTo(Object r) {
	Rational g=(Rational)r;
        double calling = floatValue();
        double parameter = g.floatValue();

        if ( calling == parameter ) {
	    return 0;
        } else if ( calling > parameter ) {
            return 1;
        }
        return -1;
    }

    public boolean equals(Object other){
        boolean retVal = this == other;//checks if the Object is a Rational
	if (!retVal) {
	    retVal = other instanceof Rational;
	    if (retVal){
		this.numerator *= ((Rational)other).denominator;//no need to use gcd as you could just cross multiply
		((Rational)other).numerator *= this.denominator;//the numerators by the opposite denominator and compare
	        return (this.numerator == ((Rational)other).numerator);
	    }
	}
	return false;
    }
    public static void main (String [] args) { 
	Rational r = new Rational (2,4); 
	Rational s = new Rational (1,2);  
	Rational t = new Rational (2,5); 
	Rational u = new Rational (1,3);  
	System.out.println (r); 
	System.out.println (s);
	System.out.println (r.compareTo (s)); 
	System.out.println (t.compareTo (u));
    }
}
