import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Merge {
	public static JFrame frame;
	
	public static String[] names;
	public static int[] ages;
//	public static String[] names = {"Nate Fuller","Yang Gao", "Matt Farich", "Kevin Freeman", "Michael Huhns", "Justin Tunnell" };
//	public static int[] ages = {1,2,3,4,5,6};
	public static JLabel nameLabel;
	public static JLabel ageLabel;

	public static void main(String[] args) {
		frame = new JFrame("Merge");
		names = new String[5];
		ages = new int[5];
		for (int i = 0; i<names.length; i++)
		{
		names[i] = JOptionPane.showInputDialog("Please enter a name.");
		}
		for(int i = 0; i < ages.length; i++)
		{
			String age= JOptionPane.showInputDialog("Please enter their age.");
			ages[i] = Integer.parseInt(age);
		}
		
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(2, 2));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		nameLabel = new JLabel();
		ageLabel = new JLabel();
		JButton nameButton = new JButton("name");
		Sorting name = new Sorting(0);
		nameButton.setSize(10, 10);
		nameButton.addMouseListener(name);
		JButton ageButton = new JButton("age");
		Sorting age = new Sorting(1);
		ageButton.setSize(10, 10);
		ageButton.addMouseListener(age);
		frame.getContentPane().add(panel1);
		panel1.add(nameLabel);
		panel1.add(ageLabel);
		frame.getContentPane().add(panel2);
		panel2.add(nameButton);
		panel2.add(ageButton);
		nameLabel.setText("<html>");
		for (int i = 0; i < names.length; i++) {
			nameLabel.setText(nameLabel.getText() + names[i] + "</br>");
		}
		nameLabel.setText("<html>");
		for (int i = 0; i < ages.length; i++) {
			ageLabel.setText(ageLabel.getText() + names[i] + "</br>");
		}

		ageLabel.setText(ageLabel.getText() + "</br>");
	}

	private static class Sorting implements MouseListener {
		public int which;

		public Sorting(int which) {
			this.which = which;
		}

		public void mouseClicked(MouseEvent e) {
			if (which == 0) {
				sort1(names, ages);
			} else if (which == 1) {
				sort2(ages, names);
			}
			String out = "<html>";
			for (int i = 0; i < names.length; i++) {
				out += names[i] + "<br/>";
			}
			out += "<html>";
			nameLabel.setText(out);
			out = "<html>";
			for (int i = 0; i < ages.length; i++) {
				out += ages[i] + "<br/>";
			}
			out += "</html>";
			ageLabel.setText(out);
		}

		//sort by name
		public void sort1(String[] a, int[] b) {
			for (int i = 0; i < a.length; i++) {
				int min = i;
				for (int j = i + 1; j < a.length; j++) {
					if (a[j].compareTo(a[min]) < 0) {
						min = j;
					}
				}
				swap1(a, i, min);
				swap2(b, i, min);
			}
		}

		public void swap1(String[] a, int i, int j) {
			String temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

		public void swap2(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

		//sort by age
		public void sort2(int[] a, String[] b) {
			for (int i = 0; i < a.length; i++) {
				int min = i;
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] < a[min]) {
						min = j;
					}
					swap2(a, i, min);
					swap1(b, i, min);
				}
			}
		}
	}
	// public void mousePressed(MouseEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	// public void mouseReleased(MouseEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	// public void mouseEntered(MouseEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void mouseExited(MouseEvent e) {
	// // TODO Auto-generated method stub
	//
	// }

}
