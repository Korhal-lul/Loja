package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Produtos;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Editar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNovo;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Editar(Produtos prod) throws FontFormatException, IOException {

		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("../Loja[Git]/Fonts/Roboto-Medium.ttf"))
				.deriveFont(15f);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);
		setTitle("Loja");
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#ffe6f1"));
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome : " + prod.getNome());
		lblNome.setBounds(217, 192, 152, 31);
		contentPane.add(lblNome);
		lblNome.setFont(font);
		
		JLabel lblId = new JLabel("ID : " + prod.getID());
		lblId.setBounds(217, 64, 167, 31);
		contentPane.add(lblId);
		lblId.setFont(font);
		
		JLabel lblPreco = new JLabel("Preco : " + prod.getPreco());
		lblPreco.setBounds(217, 324, 152, 31);
		contentPane.add(lblPreco);
		lblPreco.setFont(font);
		
		JLabel lblQtd = new JLabel("Quantidade : " + prod.getQtd());
		lblQtd.setBounds(673, 192, 152, 31);
		contentPane.add(lblQtd);
		lblQtd.setFont(font);
		
		txtNovo = new JTextField();
		txtNovo.setText("novo");
		txtNovo.setBounds(406, 329, 86, 20);
		contentPane.add(txtNovo);
		txtNovo.setColumns(10);
	}
}
