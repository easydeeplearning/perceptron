package br.eti.francisco.perceptron;

import java.util.ArrayList;
import java.util.List;

import br.eti.francisco.plot.Function;
import br.eti.francisco.plot.Plot;

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

	public void plot(String label){
		Plot plot = new Plot();
		plot.plotFunction(10, -2, 3, -2, 2, new Function() {
			
			@Override
			public double calculateY(double x) {
				return (-x * perceptron.getWeight()[0] - perceptron.getBias()) / perceptron.getWeight()[1];
			}
		});

		for(Sample s : sample){
			plot.filledCircle(s.input[0], s.input[1], 0.05, s.output == 1 ? Plot.GREEN : Plot.RED);
		}
		
		plot.text(1, 1.5, label);
		
	}
	
	public int train(double rate, int max){
		for (int i = 0; i < max; i++) {
			double e = 0;
			plot("Time: " + i);
			for(Sample s : sample){
				e += Math.abs(perceptron.train(s.input, s.output, rate));
			}
			if(e < 0.1){
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
