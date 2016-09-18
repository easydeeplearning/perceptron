package br.eti.francisco.plot;


/******************************************************************************
 *  Compilation:  javac FunctionGraph.java 
 *  Execution:    java FunctionGraph n
 *  Dependencies: StdDraw.java
 *
 *  Plots the function y = sin(4x) + sin(20x) between x = 0 and x = pi
 *  by drawing n line segments.
 *
 ******************************************************************************/

public class FunctionGraph {
    public static void main(String[] args) {

        // number of line segments to plot
//        int n = Integer.parseInt(args[0]);
        int n = 1000;
        double x1 = -.5;
        double x2 = Math.PI;
        double size = (x2 - x1) / n;

        // the function y = sin(4x) + sin(20x), sampled at n+1 points
        // between x = 0 and x = pi
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        double xt = x1;
        for (int i = 0; i <= n; i++) {
            x[i] = xt;
            y[i] = Math.sin(4*x[i]) + Math.sin(20*x[i]);
            xt += size;
        }

        Plot plot = new Plot();
        
        
        // rescale the coordinate system
        plot.setXscale(x1, x2);
        plot.setYscale(-2.0, +2.0);
        

        // plot the approximation to the function
        for (int i = 0; i < n; i++) {
            plot.line(x[i], y[i], x[i+1], y[i+1]);
        }

        plot.plotAxis();

    }
}