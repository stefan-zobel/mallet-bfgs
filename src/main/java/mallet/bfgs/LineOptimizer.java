/*
 * Copyright (C) 2002 Univ. of Massachusetts Amherst, Computer Science Dept.
 * This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 * http://mallet.cs.umass.edu/
 * This software is licensed under the terms of the Apache License, Version 2.0
 * or (at your option) any subsequent version.
 */
package mallet.bfgs;

/**
 * Maximize a function projected along a line. Optimize, constrained to move
 * parameters along the direction of a specified line. The Optimizable object
 * would be either Optimizable.ByValue or Optimizable.ByGradient.
 * 
 * @author Andrew McCallum <a
 *         href="mailto:mccallum@cs.umass.edu">mccallum@cs.umass.edu</a>
 */
public interface LineOptimizer {
    /** Returns the last step size used. */
    public double optimize(double[] line, double initialStep);

    public interface ByGradient {
        /** Returns the last step size used. */
        public double optimize(double[] line, double initialStep);
    }
}
