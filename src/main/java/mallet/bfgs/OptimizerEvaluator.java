/*
 * Copyright (C) 2005 Univ. of Massachusetts Amherst, Computer Science Dept.
 * This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 * http://mallet.cs.umass.edu/
 * This software is licensed under the terms of the Apache License, Version 2.0
 * or (at your option) any subsequent version.
 */
package mallet.bfgs;

/**
 * Callback interface that allows optimizer clients to perform some operation
 * after every iteration.
 * 
 * @author <a href="mailto:casutton@cs.umass.edu>casutton@cs.umass.edu</A>
 */
public interface OptimizerEvaluator {

    public interface ByGradient {
        /**
         * Performs some operation at the end of each iteration of a maximizer.
         * 
         * @param maxable
         *            Function that's being optimized.
         * @param iter
         *            Number of just-finished iteration.
         * @return true if optimization should continue.
         */
        boolean evaluate(Optimizable.ByGradientValue maxable, int iter);
    }

    public interface ByBatchGradient {
        /**
         * Performs some operation at the end of every batch.
         * 
         * @param maxable
         *            Function that's being optimized.
         * @param iter
         *            Number of just-finished iteration.
         * @param sampleId
         *            Number of just-finished sample.
         * @param numSamples
         *            Number of samples total.
         * @param sampleAssns
         *            Assignments of instances to samples
         * @return true if optimization should continue.
         */
        boolean evaluate(Optimizable.ByBatchGradient maxable, int iter,
                int sampleId, int numSamples, int[] sampleAssns);
    }
}
