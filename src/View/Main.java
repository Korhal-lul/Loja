package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import Controller.Cadastro;
import Controller.Editar;
import Model.Produtos;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
 
public class Main extends JFrame{

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTable tblProdutos;
	private JTextField txtIdProd;
	private static Main frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	@SuppressWarnings("serial")
	public Main() throws FontFormatException, IOException {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);
		setTitle("Loja");

		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/Roboto-Medium.ttf"))

				.deriveFont(15f);

		JSpinner spnQTD = new JSpinner();

		JComboBox cbbSearch = new JComboBox();
		cbbSearch.setFont(font);
		cbbSearch.setEditable(true);
		cbbSearch.setSelectedItem(null);
		AutoCompleteDecorator.decorate(cbbSearch);

		JLabel lblSearch = new JLabel("Search");
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblWhite = new JLabel("");
		JLabel lblMainImg = new JLabel("");
		JLabel lblPreco = new JLabel("Preco");
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblSearch.setFont(font);
		lblNome.setFont(font);
		lblPreco.setFont(font);
		lblQuantidade.setFont(font);

		ArrayList<Produtos> produtos = new ArrayList<>();

		JButton btnClear = new JButton("Clear");
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(font);

		JMenuBar menuBar = new JMenuBar();

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(font);
		mnFile.setBackground(Color.white);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JLayeredPane layeredProdutos = new JLayeredPane();

		JLayeredPane layeredEditar = new JLayeredPane();
		JLayeredPane layeredRemover = new JLayeredPane();
		JLayeredPane layeredExcluir = new JLayeredPane();
		JLayeredPane layeredCadastrar = new JLayeredPane();
		layeredCadastrar.setOpaque(true);
		layeredCadastrar.setBackground(Color.white);
		layeredEditar.setOpaque(true);
		layeredEditar.setBackground(Color.white);
		layeredExcluir.setOpaque(true);
		layeredExcluir.setBackground(Color.white);
		layeredProdutos.setOpaque(true);
		layeredProdutos.setBackground(Color.white);
		layeredRemover.setOpaque(true);
		layeredRemover.setBackground(Color.white);

		txtNome = new JTextField();
		txtPreco = new JTextField();

		txtNome.setFont(font);
		txtPreco.setFont(font);

		setJMenuBar(menuBar);

		menuBar.add(mnFile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane.setBounds(0, 189, 1014, 481);
		contentPane.add(tabbedPane);

		tabbedPane.addTab("Produtos", null, layeredProdutos, null);

		tblProdutos = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Produto", "Preco", "Quantidade", "Preco Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Float.class, Integer.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		font = font.deriveFont(10f);
		tblProdutos.setFont(font);

		layeredProdutos.add(tblProdutos);
		tblProdutos.setBounds(0, 26, 1038, 406);
		tblProdutos.setGridColor(Color.blue);

		JScrollPane scrollPane = new JScrollPane(tblProdutos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBackground(Color.white);
		scrollPane.setBounds(0, 34, 1009, 419);
		layeredProdutos.add(scrollPane);

		lblSearch.setBounds(328, 8, 78, 16);
		layeredProdutos.add(lblSearch);

		cbbSearch.setMaximumRowCount(5);
		cbbSearch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_ENTER) {
					if (!((JTextComponent) ((JComboBox) ((Component) event.getSource()).getParent()).getEditor()
							.getEditorComponent()).getText().isEmpty()) {

						DefaultTableModel Auxmodel = new DefaultTableModel() {
							@Override
							public boolean isCellEditable(int row, int column) {
								// all cells false
								return false;
							}
						};
						String value = (String) cbbSearch.getSelectedItem();

						cbbSearch.removeAllItems();
						int count = 0;
						for (Produtos i : produtos) {
							cbbSearch.addItem(i.getNome());
							if (i.getNome().contains(value)) {
								Cadastro.cadastra(i, cbbSearch, Auxmodel, tblProdutos);
								count++;
							}
						}
						if (count == 0) {
							JOptionPane.showMessageDialog(null, "Nothing found!", "Search",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});

		cbbSearch.setBounds(416, 6, 220, 20);
		layeredProdutos.add(cbbSearch);

		btnClear.setFocusPainted(false);
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!produtos.isEmpty())
					tblProdutos.setModel(model);
			}
		});
		btnClear.setBounds(664, 5, 89, 23);
		layeredProdutos.add(btnClear);

		tabbedPane.addTab("Editar", null, layeredEditar, null);

		JLabel lblIdDoProduto = new JLabel("ID do produto: ");
		font = font.deriveFont(30f);
		lblIdDoProduto.setFont(font);
		lblIdDoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdDoProduto.setBounds(187, 96, 302, 116);
		layeredEditar.add(lblIdDoProduto);

		txtIdProd = new JTextField();
		txtIdProd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_ENTER) {
					try {
						int id = Integer.parseInt(txtIdProd.getText());
						for (Produtos i : produtos) {
							if (i.getID() == id) {
								Editar edit = null;
								try {
									edit = new Editar(i, frame);
								} catch (FontFormatException | IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								edit.setVisible(true);
							}
						}
					} catch (NumberFormatException e) {
						// TODO: handle exception
					}
				}
			}
		});
		txtIdProd.setBounds(499, 141, 225, 32);
		layeredEditar.add(txtIdProd);
		txtIdProd.setColumns(10);
		tabbedPane.addTab("Remover", null, layeredRemover, null);
		tabbedPane.addTab("Excluir", null, layeredExcluir, null);
		tabbedPane.addTab("Cadastrar", null, layeredCadastrar, null);

		txtNome.setBounds(428, 97, 86, 20);
		layeredCadastrar.add(txtNome);
		txtNome.setColumns(10);

		lblNome.setBounds(276, 87, 118, 40);
		layeredCadastrar.add(lblNome);

		txtPreco.setBounds(428, 163, 86, 20);
		layeredCadastrar.add(txtPreco);
		txtPreco.setColumns(10);

		lblPreco.setBounds(276, 153, 118, 40);
		layeredCadastrar.add(lblPreco);

		lblQuantidade.setBounds(276, 226, 118, 40);
		layeredCadastrar.add(lblQuantidade);

		spnQTD.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnQTD.setBounds(428, 236, 86, 20);
		layeredCadastrar.add(spnQTD);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = txtNome.getText();
					int qtd = (Integer) spnQTD.getValue();
					float preco = Float.parseFloat(txtPreco.getText());
					
					if (preco <= 0) {
						JOptionPane.showMessageDialog(null, "Preco Invalido", "ERRO", JOptionPane.WARNING_MESSAGE);
						return;
					}
					Produtos prod = new Produtos(nome, qtd, preco);

					cbbSearch.removeAllItems();
					for (Produtos i : produtos) {
						cbbSearch.addItem(i.getNome());
						if (i.getNome().equalsIgnoreCase(nome)) {
							JOptionPane.showMessageDialog(null, "Ja cadastrado", "ERROR 404",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					}

					produtos.add(prod);

					Cadastro.cadastra(prod, cbbSearch, model, tblProdutos);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO, bem aq");
				}
			}
		});
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setBackground(Color.white);
		btnCadastrar.setBounds(779, 163, 164, 46);
		layeredCadastrar.add(btnCadastrar);

		/*
		 * lblWhite.setIcon(new
		 * ImageIcon("C:/Users/Aluno/Desktop/CardGame/Teste/Img/branco.jpg"));
		 * lblWhite.setBounds(223, 72, 342, 315); layeredCadastrar.add(lblWhite);
		 */
		lblMainImg.setIcon(new ImageIcon("./Images/shop.png"));

		lblMainImg.setBounds(0, 0, 1060, 212);
		contentPane.add(lblMainImg);

	}
}
