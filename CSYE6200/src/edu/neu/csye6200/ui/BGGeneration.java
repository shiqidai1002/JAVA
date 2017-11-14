/**
 * 
 */
package edu.neu.csye6200.ui;

import java.util.ArrayList;

/**
 * @author Shiqi
 *
 */
public class BGGeneration {
	private int forkNum;
	private double angle;
	private double initialStemLength;
	ArrayList<BGStem> tree = new ArrayList<BGStem>();
	BGStem firstStem;
	private int iteration;
	private int lastRoundGeneratedNum = 1;

	public BGGeneration(int forkNum, double initialStemLength, int iteration, double angle) {
		this.forkNum = forkNum;
		this.initialStemLength = initialStemLength;
		this.iteration = iteration;
		// this.generationNum = calculateGenerationNum(iteration);
		this.angle = angle;
		firstStem = new BGStem(this.initialStemLength, 0.0, 0.0, 0.0, this.initialStemLength, this.angle);
		tree.add(firstStem);

		for (int i = 1; i <= iteration; i++) {
//			System.out.println("\nGeneration " + i + " begins!");
//			System.out.println("lastRoundGeneratedNum: " + lastRoundGeneratedNum);
//			System.out.println("Tree size when start: " + tree.size());
//			System.out.println("index from " + (tree.size() - 1) + " to " + (tree.size() - lastRoundGeneratedNum));
			for (int j = tree.size() - 1; j >= tree.size() - lastRoundGeneratedNum; j--) {
				System.out.println("Generate from: " + j);
				generate(tree.get(j));
			}
			lastRoundGeneratedNum = calculateGenerationNum(i);
			System.out.println("Tree size when end: " + tree.size());
		}

		System.out.println("All stems we have: " + tree.size());
	}

	public int calculateGenerationNum(int i) {
		return (int) Math.pow(forkNum, i);
	}

	// class Node {
	// Node nextCenter;
	// Node nextLeft;
	// Node nextRight;
	// BGStem stem;
	//
	// public Node(Node nextCenter, Node nextLeft, Node nextRight, BGStem stem)
	// {
	// this.nextCenter = nextCenter;
	// this.nextLeft = nextLeft;
	// this.nextRight = nextRight;
	// this.stem = stem;
	// }
	// }

	// System.out.println("We have the first one: " + firstStem.toString()
	// + "\nlength: " + firstStem.length
	// + "\nxstart: " + firstStem.xstart
	// + "\nystart: " + firstStem.ystart
	// + "\nxend: " + firstStem.xend
	// + "\nyend: " + firstStem.yend
	// + "\nangle: " + firstStem.angle);

	public void generate(BGStem stem) {
		BGStem center = new BGStem();
		center.calculate(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, 0);
		tree.add(center);
		System.out.println("tree++");

		BGStem left = new BGStem();
		left.calculate(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, 90);
		tree.add(left);
		System.out.println("tree++");

		BGStem right = new BGStem();
		right.calculate(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, 180);
		tree.add(right);
		System.out.println("tree++");
	}

}
