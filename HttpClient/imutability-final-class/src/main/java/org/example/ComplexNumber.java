package org.example;

/**
 * This class represents a complex number, which consists of a real part and an imaginary part.
 * The implementation is immutable, meaning that any operation on a ComplexNumber object returns
 * a new ComplexNumber instance rather than modifying the original object.
 */
public final class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double realPart() {
        return real;
    }

    public double imaginaryPart() {
        return imaginary;
    }
    public ComplexNumber plus(ComplexNumber other){
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }
    public ComplexNumber minus(ComplexNumber other){
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }
    public ComplexNumber times(ComplexNumber other){
        return new ComplexNumber(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real);
    }
    public ComplexNumber dividedBy(ComplexNumber other){
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        return new ComplexNumber((real * other.real + imaginary * other.imaginary) / denominator, (imaginary * other.real - real * other.imaginary) / denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof ComplexNumber))
            return false;
        ComplexNumber other = (ComplexNumber) obj;
        return real == other.real && imaginary == other.imaginary;
    }
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
    @Override
    public int hashCode() {
        return 31 * Double.hashCode(real) + Double.hashCode(imaginary);
    }
}
