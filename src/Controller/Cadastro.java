package Controller;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;

public class Cadastro {
	public static void cadastra(Produtos i, JComboBox cbbSearch, DefaultTableModel model, JTable tblProdutos) {

		model.setColumnIdentifiers(new String[] { "Produto", "Preco", "Quantidade", "Preco Total" });

		Object row[] = new Object[4];

		row[0] = i.getNome();
		row[1] = ("R$ " + i.getPreco());
		row[2] = i.getQtd();
		row[3] = ("R$ " +i.getPreco() * i.getQtd());

		model.addRow(row);

		tblProdutos.setModel(model);
	}
	//machado passou por aqui
}
