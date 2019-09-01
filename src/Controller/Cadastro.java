package Controller;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;

public class Cadastro {
	public static void cadastra(Produtos i, JComboBox cbbSearch, DefaultTableModel model, JTable tblProdutos) {

		model.setColumnIdentifiers(new String[] { "ID", "Produto", "Preco", "Quantidade", "Preco Total" });

		Object row[] = new Object[5];
		
		row[0] = i.getID();
		row[1] = i.getNome();
		row[2] = ("R$ " + i.getPreco());
		row[3] = i.getQtd();
		row[4] = ("R$ " +i.getPreco() * i.getQtd());

		model.addRow(row);

		tblProdutos.setModel(model);
	}
	//machado passou por aqui
}
