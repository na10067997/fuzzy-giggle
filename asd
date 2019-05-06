package helloworld;

import java.io.File;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class ImageClickExample extends JFrame implements ActionListener {

	private int count = 0;
	private JButton btn1; // stites
	private JLabel btn2;  // number count 
	private JButton btn3; // upgrade hands button
	private JLabel btn4;  // hand level
	private boolean hasHappened = false; // boolean for getting upgrades hand buttom
	private boolean hasHappened2 = false; // boxing gloves unlocked boolean
	private Container c; 
	private int price = 20;
	private int level = 1;

	public ImageClickExample() {

		c = getContentPane();

		c.setLayout(new FlowLayout());

		c.setBackground(Color.GRAY);

		btn1 = new JButton();
		btn2 = new JLabel();
		JLabel dummy = new JLabel("                                                                   ");

		btn1.addActionListener(this);

		ImageIcon test = new ImageIcon("test.jpg");

		btn1.setIcon(test);
		btn1.setText("");
		btn1.setPreferredSize(new Dimension(240, 240));

		btn2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btn2.setText("0");

		c.add(btn1);
		c.add(dummy);
		c.add(btn2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("")) {

			count += level;
			btn2.setText("" + count);

			if (count == 20 && hasHappened == false) {

				btn3 = new JButton("UPGRADE HANDS : " + price);
				btn3.addActionListener(this);
				c.add(btn3);
				hasHappened = true;

			}
		} else if (e.getActionCommand().equals("UPGRADE HANDS : " + price)) {
			if (count >= price) {
				count -= price;
				level++;
				price += 20;
				btn2.setText("" + count);
				btn3.setText("UPGRADE HANDS : " + price);
				if (hasHappened2 == false) {
					btn4 = new JLabel("Hand Level : " + level);
					c.add(btn4);
					hasHappened2 = true;
				}

				btn4.setText("Hand Level : " + level);
			}

		}

	}

	public static void main(String[] args) {
		ImageClickExample test = new ImageClickExample();
		test.setSize(1300, 700);
		test.show();
	}

}
