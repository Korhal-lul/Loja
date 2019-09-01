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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Editar extends JFrame {

	private JPanel contentPane;
	private JTextField txtPreco;
	private JTextField txtNome;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public Editar(Produtos prod) throws FontFormatException, IOException {

		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("../Loja[Git]/Fonts/Roboto-Medium.ttf"))
				.deriveFont(20f);

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
		lblNome.setBounds(204, 296, 164, 53);
		contentPane.add(lblNome);
		lblNome.setFont(font);

		JLabel lblId = new JLabel("ID : " + prod.getID());
		lblId.setBounds(204, 168, 179, 53);
		contentPane.add(lblId);
		lblId.setFont(font);

		JLabel lblPreco = new JLabel("Preço : " + prod.getPreco());
		lblPreco.setBounds(204, 428, 164, 53);
		contentPane.add(lblPreco);
		lblPreco.setFont(font);

		JLabel lblQtd = new JLabel("Quantidade : " + prod.getQtd());
		lblQtd.setBounds(660, 296, 188, 53);
		contentPane.add(lblQtd);
		lblQtd.setFont(font);

		txtPreco = new JTextField();
		txtPreco.setBounds(471, 444, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(471, 312, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(891, 312, 86, 20);
		contentPane.add(spinner);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int qtd = (Integer) spinner.getValue();

				try {
					float preco = Float.parseFloat(txtPreco.getText());

					if (preco <= 0) {
						JOptionPane.showMessageDialog(null, "Preco Negativo", "ERROR", JOptionPane.WARNING_MESSAGE);
						return;
					}

				} catch (NumberFormatException e) {
					// TODO: handle exception
					
					JOptionPane.showMessageDialog(null, "Invalid Value", "ERROR", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnConfirmar.setBounds(429, 585, 206, 53);
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBackground(Color.white);
		contentPane.add(btnConfirmar);

	}
}
