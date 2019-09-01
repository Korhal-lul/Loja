package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Editar extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Editar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);
		setTitle("Loja");
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#ffe6f1"));
	}

}
