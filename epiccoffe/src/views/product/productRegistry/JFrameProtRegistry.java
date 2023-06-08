package views.product.productRegistry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.JTextComponent;

import controllers.PersonController;
import controllers.ProductController;
import views.text.*;

public class JFrameProtRegistry extends JPanel {
	private ListenerProtRegistry listeneer;
	private JLabel labelName;
	private JLabel labelNameProduct;
	private JTextField JName;
	private JTextField JSearch;
	private JLabel labelDescription;
	private JTextField JDescription;
	private JLabel labelPrice;
	private JTextField JPrice;
	private JTextField JUnits;
	private JButton jButtonUpdate;
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

	public JFrameProtRegistry(PersonController personController, ProductController productController) {
		listeneer = new ListenerProtRegistry(this, productController, personController);
		this.setLayout(null);
		jLabel = new JLabel();
		jLabel.setBackground(new Color(245, 240, 229));
		jLabel.setOpaque(true);
		jLabel.setBounds(500, 100, 410, 480); 
		
		//this.setBounds(0, 0, 410, 480);
		//this.setTitle("EpicCoffe");
		//this.setResizable(false);
		//this.setLocationRelativeTo(null);
		this.add(jLabel);
		init();
		//this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void init() {

		labelName = new JLabel("Registro Producto");
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

		JName = new JTextField();
		JName.setBounds(102, 130, 180, 30);
		JName.setToolTipText("Ingrese Nombre");
		JName.setBackground(new Color(255, 230, 204));
		// JName.setToolTipText("Ingrese Nombre");
		jLabel.add(JName);

		JDescription = new JTextField();
		JDescription.setBounds(61, 200, 260, 60);
		JDescription.setToolTipText("Ingrese Descripcion");
		JDescription.setBackground(new Color(255, 230, 204));
		// JName.setToolTipText("Ingrese Nombre");
		jLabel.add(JDescription);

		

		JPrice = new JTextField();
		JPrice.setBounds(62, 310, 90, 30);
		JPrice.setToolTipText("Precio");
		JPrice.setBackground(new Color(255, 230, 204));
		TextPrompt price = new TextPrompt("$$$$", (JTextComponent) JPrice);
		jLabel.add(JPrice);

		JUnits = new JTextField();
		JUnits.setBounds(230, 310, 90, 30);
		JUnits.setToolTipText("Unidades");
		JUnits.setBackground(new Color(255, 230, 204));
		TextPrompt Units = new TextPrompt("####", (JTextComponent) JUnits);
		jLabel.add(JUnits);


		jButtonUpdate = new JButton("Registar");
		jButtonUpdate.setBounds(145, 360, 90, 30);
		jButtonUpdate.setBackground(new Color(242, 152, 27));
		jButtonUpdate.addActionListener(listeneer);
		jButtonUpdate.setActionCommand(ActionsRegistryProduct.REGISTER.toString());
		jButtonUpdate.setBorder(new RoundedBorder(10));
		jLabel.add(jButtonUpdate);
		
		
	}

	public JTextField getJName() {
		return JName;
	}

	public JTextField getJDescription() {
		return JDescription;
	}

	public JTextField getJPrice() {
		return JPrice;
	}

	public JTextField getJUnits() {
		return JUnits;
	}
	
	

}
