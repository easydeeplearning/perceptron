package br.eti.francisco.perceptron;

public class PerceptronTest {

	public static void main(String[] args) {
		Trainer trainer = new Trainer(new double[]{0.3192, 0.3129}, -0.8649);
		trainer.addSample(new double[]{1, 1}, 1);
		trainer.addSample(new double[]{1, 0}, 1);
		trainer.addSample(new double[]{0, 1}, 1);
		trainer.addSample(new double[]{0, 0}, 0);
		
		int attempts = trainer.train(0.1, 200);
		Perceptron perceptron = trainer.getPerceptron();

		System.out.printf("Attempts: %d\nw0 = %f\nw1: %f\nbias: %f\n", attempts, perceptron.getWeight()[0], perceptron.getWeight()[1], perceptron.getBias());
		
		System.out.println("\nOR truth table:");
		
		System.out.printf("%d  or  %d  = %d\n", 1, 1, perceptron.getOutput(new double[]{1, 1}));
		System.out.printf("%d  or  %d  = %d\n", 1, 0, perceptron.getOutput(new double[]{1, 0}));
		System.out.printf("%d  or  %d  = %d\n", 0, 1, perceptron.getOutput(new double[]{0, 1}));
		System.out.printf("%d  or  %d  = %d\n", 0, 0, perceptron.getOutput(new double[]{0, 0}));
	}
	
}
