package views.product.productUpdateandDelete;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.JTextComponent;

import controllers.PersonController;
import controllers.ProductController;
import models.Product;
import views.text.*;

public class JPanelProductUpdate extends JPanel {
	private ListenerProductUpdate listeneer;
	private JLabel labelName;
	private JLabel labelNameProduct;
	private JTextField jName;
	private JTextField jSearch;
	private JLabel labelDescription;
	private JTextField jDescription;
	private JLabel labelPrice;
	private JTextField jPrice;
	private JTextField jUnits;
	private JButton jButtonDelet;
	private JButton jButtonClose;
	private JButton jButtonUpdate;
	private JButton jButtonSearch;
	private JLabel jLabel;
	
	private String url = "./resources/imagenes/fondoa.jpg";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension dimension = this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		System.out.println(dimension.width + "  " + dimension.height);
	}

	public JPanelProductUpdate(PersonController personController, ProductController productController) {
		listeneer = new ListenerProductUpdate(this, personController, productController);
		setLayout(null);
		jLabel = new JLabel();
		jLabel.setBounds(500, 100, 410, 480);
		jLabel.setBackground(Color.green);
		jLabel.setOpaque(true);
		this.add(jLabel);
		init();
		/*this.setBounds(0, 0, 410, 480);
		this.setTitle("EpicCoffe");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);*/
	}

	private void init() {
		
		jSearch = new JTextField();
		jSearch.setBounds(120, 70, 144, 30);
		jSearch.setToolTipText("Ingrese Codido");
		jSearch.setBackground(new Color(255, 230, 204));
		jLabel.add(jSearch);
		
		jButtonSearch = new JButton();
		BackgroundImageSearch searchIcon = new BackgroundImageSearch();
		jButtonSearch.add(searchIcon);
		jButtonSearch.setBounds(275, 70, 30, 30);
		jButtonSearch.setBackground(Color.white);
		jButtonSearch.addActionListener(listeneer);
		jButtonSearch.setActionCommand(ActionsProductUpdate.SEARCH.toString());
		jButtonSearch.setBorder(new RoundedBorder(5));
		jLabel.add(jButtonSearch);
		
		jButtonClose = new JButton("Cerrar");
		jButtonClose.setBounds(145, 400, 90, 30);
		jButtonClose.addActionListener(listeneer);
		jButtonClose.setBackground(new Color(114, 247, 167));
		jButtonClose.setActionCommand(ActionsProductUpdate.EXIT.toString());
		jButtonClose.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonClose);
	}
	
	public void createComponents() {

		labelName = new JLabel("Actualizar Producto");
		Font fuente = new Font("Calibri", 3, 18);
		Font fuente2 = new Font("Calibri", 3, 12);
		labelName.setBounds(125, 35, 160, 30);
		labelName.setFont(new Font("Serif", Font.PLAIN, 14));
		labelName.setFont(fuente);
		labelName.setForeground(new Color(110, 81, 40));
		jLabel.add(labelName);

		labelNameProduct = new JLabel("Nombre");
		labelNameProduct.setBounds(165, 100, 100, 30);
		labelNameProduct.setFont(new Font("Serif", Font.PLAIN, 14));
		labelNameProduct.setFont(fuente2);
		labelNameProduct.setForeground(new Color(110, 81, 40));
		jLabel.add(labelNameProduct);

		labelDescription = new JLabel("Descripcion");
		labelDescription.setBounds(160, 160, 100, 30);
		labelDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		labelDescription.setFont(fuente2);
		labelDescription.setForeground(new Color(110, 81, 40));
		jLabel.add(labelDescription);

		labelPrice = new JLabel("Valor Unitario");
		labelPrice.setBounds(80, 270, 80, 30);
		labelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPrice.setFont(fuente2);
		labelPrice.setForeground(new Color(110, 81, 40));
		jLabel.add(labelPrice);

		labelPrice = new JLabel("Unidades ");
		labelPrice.setBounds(230, 270, 80, 30);
		labelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		labelPrice.setFont(fuente2);
		labelPrice.setForeground(new Color(110, 81, 40));
		jLabel.add(labelPrice);

		jName = new JTextField();
		jName.setBounds(102, 130, 180, 30);
		jName.setToolTipText("Ingrese Nombre");
		jName.setBackground(new Color(255, 230, 204));
		// JName.setToolTipText("Ingrese Nombre");
		jLabel.add(jName);

		jDescription = new JTextField();
		jDescription.setBounds(61, 200, 260, 60);
		jDescription.setToolTipText("Ingrese Descripcion");
		jDescription.setBackground(new Color(255, 230, 204));
		// JName.setToolTipText("Ingrese Nombre");
		jLabel.add(jDescription);

		jPrice = new JTextField();
		jPrice.setBounds(62, 310, 90, 30);
		jPrice.setToolTipText("Precio");
		jPrice.setBackground(new Color(255, 230, 204));
		TextPrompt price = new TextPrompt("$$$$",  jPrice);
		jLabel.add(jPrice);

		jUnits = new JTextField();
		jUnits.setBounds(230, 310, 90, 30);
		jUnits.setToolTipText("Unidades");
		jUnits.setBackground(new Color(255, 230, 204));
		TextPrompt Units = new TextPrompt("####", (JTextComponent) jUnits);
		jLabel.add(jUnits);

		jButtonDelet = new JButton("Eliminar");
		jButtonDelet.setBounds(62, 350, 90, 30);

		jButtonDelet.addActionListener(listeneer);
		jButtonDelet.setActionCommand(ActionsProductUpdate.DELETE.toString());
		jButtonDelet.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonDelet);
		jButtonDelet.setBackground(Color.RED);


		jButtonUpdate = new JButton("Actualizar");
		jButtonUpdate.setBounds(230, 350, 90, 30);
		jButtonUpdate.setBackground(new Color(242, 152, 27));
		jButtonUpdate.addActionListener(listeneer);
		jButtonUpdate.setActionCommand(ActionsProductUpdate.UP.toString());
		jButtonUpdate.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonUpdate);
		
		jLabel.repaint();
	}
	
	public void setProduct(Product product) {
		jUnits.setText(product.getStockNumber()+"");
		jPrice.setText(product.getUnitPrice()+"");
		jName.setText(product.getName());
		jDescription.setText(product.getDescription());
	}

	public JTextField getjSearch() {
		return jSearch;
	}

	public JTextField getjName() {
		return jName;
	}

	public JTextField getjDescription() {
		return jDescription;
	}

	public JTextField getjPrice() {
		return jPrice;
	}

	public JTextField getjUnits() {
		return jUnits;
	}
}
