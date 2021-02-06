/*
 * Copyright (C) 2016 Univ. of Massachusetts Amherst, Computer Science Dept.
 * This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 * http://mallet.cs.umass.edu/
 * This software is licensed under the terms of the Apache License, Version 2.0
 * or (at your option) any subsequent version.
 */
package mallet.bfgs;

final class SupersedingDoubleQueue {

    private int size;
    private final double[] values;

    public SupersedingDoubleQueue(int capacity) {
        values = new double[capacity];
    }

    public int size() {
        return size;
    }

    public double get(int index) {
        return values[index];
    }

    public void removeFirst() {
        System.arraycopy(values, 1, values, 0, size - 1);
        --size;
    }

    public void addLast(double value) {
        if (size < values.length) {
            values[size] = value;
            ++size;
        } else {
            System.arraycopy(values, 1, values, 0, size - 1);
            values[values.length - 1] = value;
        }
    }
}
