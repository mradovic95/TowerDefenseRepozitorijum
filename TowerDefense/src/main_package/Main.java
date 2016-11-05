package main_package;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		ExtendenGameWindow game=ExtendenGameWindow.getInstance();
		JFrame frame=new JFrame();
		frame.setPreferredSize(new Dimension(1750,1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		//frame.addMouseListener(game);
		frame.setVisible(true);
		game.start();
	}

}
