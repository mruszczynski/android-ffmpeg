/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluggedin.dsp;

/**
 *
 * @author michu
 */
public class Complex {
    private long cPtr; // ptr 2 plggdn_complex
    private boolean javaOwnMem;
    
    public Complex() {
        cPtr = ComplexJNI.create();
        this.javaOwnMem = true;
    }    
    public Complex(long cptr, boolean jOwnMem) {
        cPtr =  cptr;
        this.javaOwnMem = jOwnMem;
    }    
    public Complex(double re, double im) {
        cPtr = ComplexJNI.create(re, im);
        this.javaOwnMem = true;
    }
    public Complex(Complex c) {
        double re = c.re();
        double im = c.im();
        cPtr = ComplexJNI.create(re, im);
        javaOwnMem = true;
    }
    public Complex(Complex c, boolean jOwnMem) {
        double re = c.re();
        double im = c.im();
        cPtr = ComplexJNI.create(re, im);
        javaOwnMem = jOwnMem;
    }
    
    public double re() {
        return ComplexJNI.re(cPtr);
    }    
    public double im() {
        return ComplexJNI.im(cPtr);
    }    
    public double abs() {
        return ComplexJNI.abs(cPtr);
    }    
    public double angle() {
        return ComplexJNI.angle(cPtr);
    }
    
    public Complex conj() {
        return ComplexJNI.conj(cPtr, 1);
    }
    
    
    /**
     * operates on this class, adds b
     * @param b
     * @returns this 
     */
    public Complex add(Complex b) {
        return ComplexJNI.add(cPtr, b.cPtr, 1);
    }
    /**
     * operates on this class, subtracts b
     * @param b
     * @returns this 
     */
    public Complex sub(Complex b) {
        return ComplexJNI.sub(cPtr, b.cPtr, 1);
    }
    /**
     * operates on this class, multiplies by b
     * @param b
     * @returns this 
     */
    public Complex mul(Complex b) {
        return ComplexJNI.mul(cPtr, b.cPtr, 1);
    }
    /**
     * operates on this class, divides by b
     * @param b
     * @returns this 
     */
    public Complex div(Complex b) {
        return ComplexJNI.div(cPtr, b.cPtr, 1);
    }
    
    
    public Complex inv() {
        return ComplexJNI.inv(cPtr, 1);
    }    
    public Complex pow(Complex b) {
        return ComplexJNI.pow(cPtr, b.cPtr, 1);
    }    
    public Complex sqrt() {
        return ComplexJNI.sqrt(cPtr, 1);
    }
    
    public Complex log() {
        return ComplexJNI.log(cPtr, 1);
    }
    public Complex exp() {
        return ComplexJNI.exp(cPtr, 1);
    }
    
    public static Complex sum(Complex a, Complex b) {
        return ComplexJNI.add(a.cPtr, b.cPtr, 0);
    }
    public static Complex diff(Complex a, Complex b) {
        return ComplexJNI.sub(a.cPtr, b.cPtr, 0);
    }
    public static Complex mul(Complex a, Complex b) {
        return ComplexJNI.mul(a.cPtr, b.cPtr, 0);
    }
    public static Complex div(Complex a, Complex b) {
        return ComplexJNI.div(a.cPtr, b.cPtr, 0);
    }
    
    public static Complex inv(Complex a) {
        return ComplexJNI.inv(a.cPtr, 0);
    }    
    public static Complex pow(Complex a, Complex b) {
        return ComplexJNI.pow(a.cPtr, b.cPtr, 0);
    }    
    public static Complex sqrt(Complex b) {
        return ComplexJNI.sqrt(b.cPtr, 0);
    }
    
    public static Complex log(Complex a) {
        return ComplexJNI.log(a.cPtr, 0);
    }
    public static Complex exp(Complex a) {
        return ComplexJNI.exp(a.cPtr, 0);
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        
        if(javaOwnMem) {
            ComplexJNI.destroy(cPtr);
        }
    }    
}
