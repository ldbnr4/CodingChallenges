package com.company;

/**
 * Created by boyice on 8/31/2016.
 *
 */
public class Tuple<X, Y> {
    private final X x;
    private final Y y;
    public Tuple(X x, Y y){
        this.x = x;
        this.y = y;
    }
    int toInt(){
        return Integer.parseInt(x.toString()+y.toString());
    }

}
