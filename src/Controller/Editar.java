package Controller;

import Model.Produtos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Editar extends JFrame {

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public Editar(Produtos prod) throws FontFormatException, IOException {

		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/Roboto-Medium.ttf"))
				.deriveFont(20f);

		JPanel contentPane = new JPanel();
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

		JLabel lblPreco = new JLabel("Preco : " + prod.getPreco());
		lblPreco.setBounds(204, 428, 164, 53);
		contentPane.add(lblPreco);
		lblPreco.setFont(font);

		JLabel lblQtd = new JLabel("Quantidade : " + prod.getQtd());
		lblQtd.setBounds(660, 296, 188, 53);
		contentPane.add(lblQtd);
		lblQtd.setFont(font);

		JTextField txtPreco = new JTextField();
		txtPreco.setBounds(471, 444, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		JTextField txtNome = new JTextField();
		txtNome.setBounds(471, 312, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
		spinner.setBounds(891, 312, 86, 20);
		contentPane.add(spinner);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(arg0 -> {
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
		});
		btnConfirmar.setBounds(429, 585, 206, 53);
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBackground(Color.white);
		contentPane.add(btnConfirmar);

	}
}
