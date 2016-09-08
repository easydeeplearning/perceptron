package br.eti.francisco.perceptron;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

	private List<Sample> sample = new ArrayList<Sample>();
	
	private Perceptron perceptron;
	
	public Trainer() {

	}
	
	public Trainer(double initWeight[], double bias) {
		if(perceptron == null){
			this.perceptron = new Perceptron(initWeight.length);
		}
		for (int i = 0; i < initWeight.length; i++) {
			this.perceptron.getWeight()[i] = initWeight[i];
		}
		this.perceptron.setBias(bias);
	}
	
	public void addSample(double [] input, double output){
		if(perceptron == null){
			this.perceptron = new Perceptron(input.length);
		}
		Sample s = new Sample();
		s.input = input;
		s.output = output;
		sample.add(s);
	}
	
	public int train(double rate, int max){
		for (int i = 0; i < max; i++) {
			double e = 0;
			for(Sample s : sample){
				e += Math.abs(perceptron.train(s.input, s.output, rate));
			}
			if(e < 0.01){
				return i + 1;
			}
		}
		return max;
	}

	public Perceptron getPerceptron() {
		return perceptron;
	}

	private class Sample{
		private double [] input;
		private double output;
	}
}
