/*
 * Copyright (C) 2016 Univ. of Massachusetts Amherst, Computer Science Dept.
 * This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 * http://mallet.cs.umass.edu/
 * This software is licensed under the terms of the Apache License, Version 2.0
 * or (at your option) any subsequent version.
 */
package mallet.bfgs;

final class SupersedingDoubleArrayQueue {

    private int size;
    private final double[][] values;

    public SupersedingDoubleArrayQueue(int capacity) {
        values = new double[capacity][];
    }

    public int size() {
        return size;
    }

    public double[] get(int index) {
        return values[index];
    }

    public double[] removeFirst() {
        double[] fst = values[0];
        System.arraycopy(values, 1, values, 0, size - 1);
        --size;
        return fst;
    }

    public void addLast(double[] value) {
        if (size < values.length) {
            double[] copy = new double[value.length];
            System.arraycopy(value, 0, copy, 0, copy.length);
            values[size] = copy;
            ++size;
        } else {
            double[] fst = values[0];
            System.arraycopy(value, 0, fst, 0, value.length);
            System.arraycopy(values, 1, values, 0, size - 1);
            values[values.length - 1] = fst;
        }
    }

    public void addLastNoCopy(double[] value) {
        if (size < values.length) {
            values[size] = value;
            ++size;
        } else {
            System.arraycopy(values, 1, values, 0, size - 1);
            values[values.length - 1] = value;
        }
    }
}
