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
	Node first;
	private int iteration;
	private int generationNum;
	private int counter = 0;

	public BGGeneration(int forkNum, double initialStemLength, int iteration, double angle) {
		this.forkNum = forkNum;
		this.initialStemLength = initialStemLength;
		this.iteration = iteration;
		this.generationNum = calculateGenerationNum(iteration);
		this.angle = angle;
		generate();
	}

	public int calculateGenerationNum(int iteration) {
		int temp = 0;
		for (int i = 0; i < iteration; i++) {
			temp = (int) (temp + Math.pow(forkNum, i + 1));
		}
		return temp;
	}

	class Node {
		Node nextCenter;
		Node nextLeft;
		Node nextRight;
		BGStem stem;

		public Node(Node nextCenter, Node nextLeft, Node nextRight, BGStem stem) {
			this.nextCenter = nextCenter;
			this.nextLeft = nextLeft;
			this.nextRight = nextRight;
			this.stem = stem;
		}
	}

	public void generate() {
		System.out.println("GenerationNum: " + generationNum);
		BGStem firstStem = new BGStem(this.initialStemLength, 0.0, 0.0, 0.0, this.initialStemLength, this.angle);
		// System.out.println("We have the first one: " + firstStem.toString()
		// + "\nlength: " + firstStem.length
		// + "\nxstart: " + firstStem.xstart
		// + "\nystart: " + firstStem.ystart
		// + "\nxend: " + firstStem.xend
		// + "\nyend: " + firstStem.yend
		// + "\nangle: " + firstStem.angle);
		tree.add(firstStem);
		first = new Node(null, null, null, firstStem);
		generate(first);

	}

	public void generate(Node father) {
		BGStem center = new BGStem();
		center.calculate(father.stem.length, father.stem.xstart, father.stem.ystart, father.stem.xend, father.stem.yend,
				90);
		System.out.println("I draw a center stem" + counter);
		tree.add(center);

		BGStem left = new BGStem();
		left.calculate(father.stem.length, father.stem.xstart, father.stem.ystart, father.stem.xend, father.stem.yend,
				0);
		System.out.println("I draw a left stem" + counter);
		tree.add(left);

		BGStem right = new BGStem();
		right.calculate(father.stem.length, father.stem.xstart, father.stem.ystart, father.stem.xend, father.stem.yend,
				180);
		System.out.println("I draw a right stem" + counter);
		tree.add(right);

		father.nextCenter = new Node(null, null, null, center);
		System.out.println("center Node has extended");
		father.nextLeft = new Node(null, null, null, left);
		System.out.println("left Node has extended");
		father.nextRight = new Node(null, null, null, right);
		System.out.println("right Node has extended");
		counter++;

		generate(father.nextCenter);
		generate(father.nextLeft);
		generate(father.nextRight);
		// System.out.println("counter: " + counter);

	}

}
