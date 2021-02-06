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
public interface Optimizer {
    public boolean optimize();

    public boolean optimize(int numIterations);

    /** Returns true if it has converged */
    public boolean isConverged();

    public Optimizable getOptimizable();

    // Figure out the right interface for this. It is odd that
    // 'sampleAssignments' reaches into InstanceList indices
    public interface ByBatches {
        public boolean optimize(int numSamples, int[] sampleAssigments);

        public boolean optimize(int numIterations, int numSamples,
                int[] sampleAssignments);
    }
}
