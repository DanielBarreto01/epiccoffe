package views.facture.trolley;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controllers.PersonController;
import controllers.ProductController;
import controllers.StoreController;
import models.Store;
import views.text.RoundedBorder;


public class JPanelTrolley extends JPanel {
	private ListenerTrolley listenerTrolley;
	private JPanel jPanelHeader;
	private JLabel jLabelName;
	private JLabel jPanelTable;
	private JScrollPane jScrollPaneList;
	private JButton jButtonBuy;
	private JButton jButtonCancel;
	private JLabel jLabel;
	private StoreController storeController;
	
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
	
	public JPanelTrolley(ProductController productController, PersonController personController, StoreController storeController) {
		this.storeController = storeController;
		listenerTrolley = new ListenerTrolley(this, personController, storeController, productController);
		setLayout ( null );
		jLabel = new JLabel();
		jLabel.setBounds ( 500 , 100 , 410, 480 );
		jLabel.setOpaque(true);
		this.add(jLabel);
		init();
        /*this.setBounds ( 0 , 0 , 410, 480 );
        this.setTitle("EpicCoffe");
        this.setResizable ( false);
        this.setLocationRelativeTo ( null );
        init();
        this.setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );*/

		
	}

	private void init() {
		
		jPanelHeader = new JPanel();
		jPanelHeader.setBounds(0, 0, 410, 30);
		jPanelHeader.setBackground(new Color(110,81,40));
		jLabel.add(jPanelHeader);
		
		
		jLabelName= new JLabel("Carrito");
		jLabelName.setBounds(5,5 , 60, 30);
		jLabelName.setForeground(new Color(255,255,255));
		
		jPanelHeader.add(jLabelName);
		
	/////tabla
		
			jPanelTable= new JLabel();
			jPanelTable.setBounds(0, 0, 0, 0);
			jPanelTable.setBackground(new Color(171,217,250,98));
			jLabel.add(jPanelTable);
			
			 
			
			Store storeList[] = storeController.getStore();
			String[] header= {"Nombre ","Unidades","Valor Tortal"};
			String[][] body= new String[storeList.length+2][3];
			double price = 0;
			int unitsTotal = 0;
			for (int i = 0; i < body.length; i++) {
					if(i < storeList.length) {
					body[i][0]=storeList[i].getProductName();
					body[i][1]=storeList[i].getUnitsNumber() + "";
					body[i][2] = (storeList[i].getUnitPrice() * storeList[i].getUnitsNumber())+"";
					price += (storeList[i].getUnitPrice() * storeList[i].getUnitsNumber());
					unitsTotal += storeList[i].getUnitsNumber();
					}
			}
			
			body[body.length -1][0] = "total";
			body[body.length -1][1] = unitsTotal + "";
			body[body.length -1][2] = price + "";
			// agregar objeto de tipo porducto  en body
			
			DefaultTableModel model = new DefaultTableModel(body, header);
			
			JTable table = new JTable(model);
			//table.setBackground(new Color(0,0,0,0));
			table.setBorder(new RoundedBorder(2));
			table.setGridColor(Color.BLACK);
			
		
			table.setEnabled(false);
			table.setOpaque(true);
			table.setShowGrid(true);
			
			jScrollPaneList = new JScrollPane();
			jScrollPaneList.setBounds ( 85 , 30,240, 280 );
			jScrollPaneList.setViewportView(table);
			//jScrollPaneList.setBackground(new Color(0,0,0,0));
			jScrollPaneList.setBorder(new RoundedBorder(2));
			jScrollPaneList.setOpaque(false);
			jScrollPaneList.getViewport().setOpaque(false);
			jPanelTable.setLayout(null);
			jLabel.add(jScrollPaneList);
			
			jButtonBuy = new JButton("Comprar");
			jButtonBuy.setBounds(85, 340, 90, 30);
			jButtonBuy.setBorder(new RoundedBorder(5));
			jButtonBuy.setBackground(new Color(242, 152, 27));
			jButtonBuy.addActionListener(listenerTrolley);
			jButtonBuy.setActionCommand(ActionsTrolley.BUY.toString());
			jLabel.add(jButtonBuy);
			
			jButtonCancel = new JButton("Cancelar");
			jButtonCancel.setBounds(235, 340, 90, 30);
			jButtonCancel.setBorder(new RoundedBorder(5));
			jButtonCancel.setBackground(new Color(218, 247, 249));
			jButtonCancel.addActionListener(listenerTrolley);
			jButtonCancel.setActionCommand(ActionsTrolley.CANCEL.toString());
			jLabel.add(jButtonCancel);
		
	}
}
