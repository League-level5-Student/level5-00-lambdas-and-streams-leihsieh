package _00_JButtons_with_Lambdas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LambdaButtons implements ActionListener {
	private JFrame window = new JFrame();
	private JButton addNumbers = new JButton("ADD 2 Numbers");
	private JButton randNumber = new JButton("RANDOM NUMBER");
	private JButton tellAJoke = new JButton("TELL A JOKE");
	private JPanel panel = new JPanel();
	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JTextField answerField = new JTextField();
	Random rand = new Random();
	private ArrayList<String> jokes = new ArrayList<String>();
	
	public LambdaButtons() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.add(addNumbers);
		window.add(randNumber);
		window.add(tellAJoke);
		field1.setColumns(4);
		field2.setColumns(4);
		answerField.setColumns(4);
		window.add(field1);
		window.add(field2);
		window.add(answerField);
		
		jokes.add("What's the best thing about Switzerland? I don't know, but the flag is a big plus.");
		jokes.add("I invented a new word: plagiarism.");
		jokes.add("A bear walks into a bar and says, “Give me a whiskey… and a cola.”\n“Why the big pause?” asks the bartender. The bear shrugged. “I’m not sure. I was born with them.”");
		
		//1. Call the addActionListener methods for each button. Use lambdas
		//   to define to functionality of the buttons.
		addNumbers.addActionListener((ActionEvent e)->{
			answerField.setText("" + (Integer.parseInt(field1.getText()) + Integer.parseInt(field2.getText()))); 
		});
		randNumber.addActionListener((ActionEvent e)->{
			answerField.setText("" + rand.nextInt(11));
		});
		tellAJoke.addActionListener((ActionEvent e)->{
			JOptionPane.showMessageDialog(null, jokes.get(rand.nextInt(jokes.size())));
		});
		window.setVisible(true);
		window.pack();
	}
	
	public static void main(String[] args) {
		new LambdaButtons();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
}
