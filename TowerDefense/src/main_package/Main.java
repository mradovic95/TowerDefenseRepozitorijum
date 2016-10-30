package main_package;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		GameWindow game=new ExtendenGameWindow(1700,700);
		JFrame frame=new JFrame();
		frame.setPreferredSize(new Dimension(1700,700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		game.start();
	}

}
