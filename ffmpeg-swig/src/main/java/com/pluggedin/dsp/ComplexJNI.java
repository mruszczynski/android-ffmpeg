/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluggedin.dsp;

/**
 *
 * @author michu
 */
public class ComplexJNI {
    
    /**
     * create native complex
     * @return 
     */
    static native long create();
    static native long create(double re, double im);
    static native void destroy(long cptr);
    
    static native double re(long cptr);
    static native double im(long cptr);
    
    static native double abs(long cPtr);
    static native double angle(long cPtr);
    
    static native Complex  conj(long cptr, int inPlaceA);
    
    static native Complex  add(long cptrA, long cptrB, int inPlaceA);
    static native Complex  sub(long cptrA, long cptrB, int inPlaceA);
    static native Complex  mul(long cptrA, long cptrB, int inPlaceA);
    static native Complex  div(long cptrA, long cptrB, int inPlaceA);
    
    static native Complex inv(long cptr, int inPlaceA);
    static native Complex pow(long cptrA, long cptrB, int inPlaceA);
    static native Complex sqrt(long cptrA, int inPlaceA);
    
    static native Complex log(long cptr, int inPlaceA);
    static native Complex  exp(long cptr, int inPlaceA);
    
}
