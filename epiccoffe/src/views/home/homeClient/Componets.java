package views.home.homeClient;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import models.Product;
import views.text.*;

import java.awt.Color;

public class Componets {
	private JLabel price;
	private JLabel name;
	private JLabel description;
	private JLabel number;
	private JButton more;
	private JButton lees;
	private JLabel jLabel;
	private int maximed;
	private Product product;
	private int units;
	
	public Componets() {
		init();
		maximed = 0;
		units = 0;
	}
	
	private void init() {
		
		jLabel = new JLabel();
		jLabel.setBounds(155, 155, 150, 150);
		jLabel.setBackground(Color.red);
		jLabel.setOpaque(true);
		
		name = new JLabel();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(20,10, 110, 30);
		jLabel.add(name);
		
		price = new JLabel();
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(20,56, 110, 50);
		jLabel.add(price);
		
		description = new JLabel();
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setBounds(20,30, 110, 50);
		jLabel.add(description);
		
		more = new JButton("+");
		more.setBorder(new RoundedBorder(2));
		more.setBackground(new Color(242, 152, 27));
		more.setLayout(null);
		more.setBounds(101,110, 43, 30);
		jLabel.add(more);
		
	
		lees = new JButton("-");
		lees.setBorder(new RoundedBorder(2));
		lees.setBackground(new Color(242, 152, 27));
		lees.setLayout(null);
		lees.setBounds(10,110, 40, 30);
		jLabel.add(lees);
		
		number = new JLabel("0");
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setBounds(54, 110, 45, 30);
		number.setOpaque(true);
		jLabel.add(number);
		
	}

	public JLabel getName() {
		return name;
	}

	public JLabel getDescription() {
		return description;
	}

	public JLabel getNumber() {
		return number;
	}

	public JButton getMore() {
		return more;
	}

	public JButton getLees() {
		return lees;
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public int getMaximed() {
		return maximed;
	}

	public void setMaximed(int maximed) {
		this.maximed = maximed;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public JLabel getPrice() {
		return price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	
}
