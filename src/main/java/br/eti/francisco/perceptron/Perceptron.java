package br.eti.francisco.perceptron;

public class Perceptron {

	private double [] weight;

	private double bias;

	private double threshold;

	public Perceptron(int inputAmount) {
		this(inputAmount, 0);
	}

	public Perceptron(int numberIn, double threshold) {
		this.weight = new double[numberIn];
		this.threshold = threshold;
	}

	private double calculate(double [] input){
		double v = 0;
		for (int i = 0; i < input.length; i++) {
			v += weight[i] * input[i];
		}
		v += bias;
		return v;
	}

	public int getOutput(double[] input){
		double v = calculate(input);
		return v >= threshold ? 1 : 0;
	}

	public double train(double [] input, double output, double rate){
		double v = getOutput(input);
		double e = output - v;
		if(Math.abs(e) > 0.1){
			for (int i = 0; i < weight.length; i++) {
				weight[i] = weight[i] + e * rate * input[i];
			}
			bias = bias + e * rate;
		}
		return e;
	}

	public double[] getWeight() {
		return weight;
	}

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}
}
