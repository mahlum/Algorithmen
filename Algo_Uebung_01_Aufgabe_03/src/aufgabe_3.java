import java.awt.*;
import java.awt.event.*;

public class aufgabe_3 extends Frame {

	private double length;

	public aufgabe_3() {
		super("Aufgabe 3, juhuuu");
		setSize(600, 600);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}

	public void run() {
//		drawEdge(this.getGraphics(), 400, 400, 50, 50, 200, 500, 50, 50);
		drawEdge(this.getGraphics(), 200, 200, 50, 50, 210, 210, 30, 30);
	}

	private static double lengthCalc(double valueOne, double valueTwo) {
		// System.out.println("-------------");
		// System.out.println("valueone: " + valueOne + ", valuetwo: " +
		// valueTwo);
		// System.out.println(Math.sqrt((valueOne * valueOne)
		// + (valueTwo * valueTwo)));
		return Math.sqrt((valueOne * valueOne) + (valueTwo * valueTwo));
	}

	private static int[] calcLine(int x1, int y1, int w1, int h1, int x2,
			int y2, int w2, int h2) {
		double[] StartPointsX = { x1, x1 + w1 };
		double[] StartPointsY = { y1, y1 + h1 };
		double[] EndPointsX = { x2, x2 + w2 };
		double[] EndPointsY = { y2, y2 + h2 };
		int[] posValues = { x1, y1, x2, y2 };
		double length;

		length = lengthCalc((EndPointsX[0] - StartPointsX[0]),
				(EndPointsY[0] - StartPointsY[0]));
		double lengthHelp = length;

		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				for (int l = 0; l < 2; ++l)
					for (int s = 0; s < 2; ++s) {
						lengthHelp = lengthCalc(
								EndPointsX[l] - StartPointsX[i],
								((j + 1 == 2) ? EndPointsY[0] : EndPointsY[s])
										- ((i + 1 == 2) ? StartPointsY[0]
												: StartPointsY[j]));
						if (lengthHelp < length) {
							posValues[0] = (int) StartPointsX[i];
							posValues[1] = (int) StartPointsY[j];
							posValues[2] = (int) EndPointsX[l];
							posValues[3] = (int) EndPointsY[s];
							length = lengthHelp;
						}
					}
			}
		}

		System.out.println(length);
		return posValues;
	}

	public static void drawEdge(Graphics g, int x1, int y1, int w1, int h1,
			int x2, int y2, int w2, int h2) {
		g.drawRect(x1, y1, w1, h1);
		g.drawRect(x2, y2, w2, h2);
		int[] StartEndPoints = calcLine(x1, y1, w1, h1, x2, y2, w2, h2);
		System.out.println("Test: " + StartEndPoints[0] + " "
				+ StartEndPoints[1] + " " + StartEndPoints[2] + " "
				+ StartEndPoints[3] + " ");

		g.drawLine((int) StartEndPoints[0], (int) StartEndPoints[1],
				(int) StartEndPoints[2], (int) StartEndPoints[3]);

		g.fillRect((int) StartEndPoints[2] - 5, (int) StartEndPoints[3] - 5,
				10, 10);
	}

	public static void main(String[] args) {
		aufgabe_3 auf3 = new aufgabe_3();
		try {
			Thread.sleep(300);
		} catch (InterruptedException x) {
		}
		auf3.run();
	}
}
