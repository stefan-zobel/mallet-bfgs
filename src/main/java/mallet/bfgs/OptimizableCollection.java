/*
 * Copyright (C) 2002 Univ. of Massachusetts Amherst, Computer Science Dept.
 * This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 * http://mallet.cs.umass.edu/
 * This software is licensed under the terms of the Apache License, Version 2.0
 * or (at your option) any subsequent version.
 */
package mallet.bfgs;

import java.util.ArrayList;


public class OptimizableCollection {

    public class ByGradientValue implements Optimizable.ByGradientValue {
        ArrayList<Optimizable.ByGradientValue> optimizables;

        public ByGradientValue(Optimizable.ByGradientValue... ops) {
            optimizables = new ArrayList<Optimizable.ByGradientValue>(
                    ops.length);
            for (Optimizable.ByGradientValue o : ops)
                optimizables.add(o);
        }

        public void getValueGradient(double[] buffer) {
            double[] b2 = new double[buffer.length];
            for (Optimizable.ByGradientValue o : optimizables) {
                MatrixOps.setAll(b2, 0);
                o.getValueGradient(b2);
                MatrixOps.plusEquals(buffer, b2);
            }
        }

        public double getValue() {
            double ret = 0;
            for (Optimizable.ByGradientValue o : optimizables)
                ret += o.getValue();
            return ret;
        }

        // Here we rely on all optimizables pointing to the same set of
        // parameters!

        public int getNumParameters() {
            return optimizables.get(0).getNumParameters();
        }

        public double getParameter(int index) {
            return optimizables.get(0).getParameter(index);
        }

        public void getParameters(double[] buffer) {
            optimizables.get(0).getParameters(buffer);
        }

        public void setParameter(int index, double value) {
            optimizables.get(0).setParameter(index, value);
        }

        public void setParameters(double[] params) {
            optimizables.get(0).setParameters(params);
        }
    }
}
