/*
 * Copyright (C) 2002 Univ. of Massachusetts Amherst, Computer Science Dept.
 * This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 * http://mallet.cs.umass.edu/
 * This software is licensed under the terms of the Apache License, Version 2.0
 * or (at your option) any subsequent version.
 */
package mallet.bfgs;

/**
 * @author Andrew McCallum <a
 *         href="mailto:mccallum@cs.umass.edu">mccallum@cs.umass.edu</a>
 */
public interface Optimizable {

    public int getNumParameters();

    public void getParameters(double[] buffer);

    public double getParameter(int index);

    public void setParameters(double[] params);

    public void setParameter(int index, double value);

    public interface ByGradientValue extends Optimizable {
        public void getValueGradient(double[] buffer);

        public double getValue();
    }

    public interface ByGISUpdate extends Optimizable {
        public double getValue();

        public void getGISUpdate(double[] buffer);
    }

    public interface ByBatchGradient extends Optimizable {
        public void getBatchValueGradient(double[] buffer, int batchIndex,
                int[] batchAssignments);

        public double getBatchValue(int batchIndex, int[] batchAssignments);
    }
}
