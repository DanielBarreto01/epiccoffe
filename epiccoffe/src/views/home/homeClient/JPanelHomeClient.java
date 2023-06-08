package views.home.homeClient;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import controllers.PersonController;
import controllers.ProductController;
import controllers.StoreController;
import models.Product;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;

import views.home.homeAdministrator.ActionsHome;
import views.home.homeAdministrator.BackgroundButtonMenu;
import views.home.homeAdministrator.BackgroundUser;
import views.home.homeClient.*;

//import loginIn.BackgroundImage;
//import productRegistry.ListenerProtRegistry;
import views.text.*;

import java.awt.GraphicsEnvironment;
import java.util.Iterator;

public class JPanelHomeClient extends JPanel{
	
	private BackgroundFondo backgroundFondo;
	private ListenerHomeClient listenerHomeClient;
	private JPanel Jpannel;
	private JLabel jLabelUser;
	private JLabel jLabeName;
	private JLabel jLabeDespriction;
	private JLabel jLabelLocation;
	private JLabel jLabelPrice;
	private JLabel jLabelContac;
	private JButton jButtonAssociates;
	private JPanel menu;
	private JLabel menu1;
	private JButton button;
	private JLabel JlabelUser;
	private JLabel JlabelUserClose;
	private JLabel JlabelUserCloseTwo;
	private JLabel jPanelIcon;
	private JLabel jLabelNameUser;
	private JPanel jPanelRecords;
	private JScrollPane jScrollPaneList;
	private JLabel jPanelTable;
	private JPanel jPanelPrueba;
	private JLabel jLabel;
	private Componets[][] body;
	private JTextArea pro;
	private JLabel jLabelFirstUser;
	private PersonController personController;
	
	
	public JPanelHomeClient(ProductController productController, PersonController personController, StoreController storeController) {
		this.personController = personController;
		listenerHomeClient = new ListenerHomeClient(this, productController, personController, storeController);
		this.setLayout(null);
		jLabel = new JLabel();
		jLabel.setBounds(0, 0, 1366, 768);
		this.add(jLabel);
		body = new Componets[1][1];
		init();
	}


	private void init() {
		
		backgroundFondo = new BackgroundFondo();
		
		jLabelUser = new JLabel("Cliente");
		jLabelUser.setBounds(10, 15, 150, 50);
		Font fuente = new Font("Calibri", 3, 18);
		jLabelUser.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelUser.setFont(fuente);
		jLabelUser.setForeground(new Color(255,255,255));
		jLabel.add(jLabelUser);
		
		jLabelContac = new JLabel("(+52) 3209266940");
		jLabelContac.setBounds(1180, 15, 150, 50);
		jLabelContac.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelContac.setFont(fuente);
		jLabelContac.setForeground(new Color(255,255,255));
		jLabel.add(jLabelContac);
		
		jLabelLocation = new JLabel("Ubicacion");
		jLabelLocation.setBounds(920, 15, 150, 50);
		jLabelLocation.setToolTipText("Tunja / Boyaca");
		jLabelLocation.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelLocation.setFont(fuente);
		jLabelLocation.setForeground(new Color(255,255,255));
		jLabel.add(jLabelLocation);
		
		jLabelPrice = new JLabel("Valor Asociacion");
		jLabelPrice.setBounds(1020, 15, 150, 50);
		jLabelPrice.setToolTipText("$$$$$$$");
		jLabelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelPrice.setFont(fuente);
		jLabelPrice.setForeground(new Color(255,255,255));
		jLabel.add(jLabelPrice);
		
		
		jLabeName = new JLabel("EpicCoffe");
		jLabeName.setBounds(600, 380, 1000, 120);
		Font fuente2 = new Font("Calibri", 3, 80);
		jLabeName.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabeName.setFont(fuente2);
		jLabeName.setForeground(new Color(255, 255, 255));
		backgroundFondo.add(jLabeName);

		jLabeDespriction = new JLabel("Cooperativa Cafetera de Colombia");
		jLabeDespriction.setBounds(340, 450, 1000, 120);
		Font fuente3 = new Font("Calibri", 3, 58);
		jLabeDespriction.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabeDespriction.setFont(fuente3);
		jLabeDespriction.setForeground(new Color(255, 255, 255));
		backgroundFondo.add(jLabeDespriction);

		Jpannel = new JPanel();
		Jpannel.setBounds(0, 0, 1620, 80);
		Jpannel.setBackground(new Color(110, 81, 40));
		jLabel.add(Jpannel);

		jButtonAssociates = new JButton("Asociados");
		jButtonAssociates.setBounds(850, 85, 90, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeClient);
		jLabel.add(jButtonAssociates);

		jButtonAssociates = new JButton("ver productos");
		jButtonAssociates.setBounds(950, 85, 90, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeClient);
		jButtonAssociates.setActionCommand(ActionsHomeCliente.SHOW.toString());
		jLabel.add(jButtonAssociates);

		jButtonAssociates = new JButton("ir al carrito ");
		jButtonAssociates.setBounds(1050, 85, 90, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeClient);
		jButtonAssociates.setActionCommand(ActionsHomeCliente.CARRITO.toString());
		jLabel.add(jButtonAssociates);

		jButtonAssociates = new JButton("Actualizar");
		jButtonAssociates.setBounds(1150, 85, 90, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeClient);
		jLabel.add(jButtonAssociates);

		jButtonAssociates = new JButton("Usuario");
		jButtonAssociates.setBounds(1250, 85, 90, 30);
		jButtonAssociates.setBorder(new RoundedBorder(5));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeClient);
		jLabel.add(jButtonAssociates);
		
		menu = new JPanel();
		menu.setLayout(null);
		menu.setBounds(10,85,45,45);
		BackgroundButtonMenu backgroundButtonMenu = new BackgroundButtonMenu();
		menu.setBackground(new Color(0, 0, 0, 0));
		menu.add(backgroundButtonMenu);
		menu.addMouseListener(listenerHomeClient);
		jLabel.add(menu);
	
		menu1 = new JLabel();
		menu1.setBounds(0,80,200,305);
		menu1.setBackground(new Color(171,217,250,98));
		menu1.setBorder(new RoundedBorder(2));
		jLabel.add(menu1);
	
		
		button = new JButton("Salir");
		button.setBounds(50,250,80, 30);
		button.setBackground(Color.PINK);
		button.setBackground(new Color(242, 152, 27));
		button.addActionListener(listenerHomeClient);
		button.setActionCommand(ActionsHomeCliente.EXIT.toString());
		button.setBorder(new RoundedBorder(5));
		menu1.add(button);
		
		JlabelUserClose = new JLabel("Cooperativa cafetera de");
		JlabelUserClose.setBounds(30, 40, 150, 50);
		Font fuenteClose = new Font("Calibri", 3, 12);
		JlabelUserClose.setFont(new Font("Serif", Font.PLAIN, 14));
		JlabelUserClose.setFont(fuenteClose);
		JlabelUserClose.setForeground(new Color(255,255,255));
		menu1.add(JlabelUserClose);	
		
		JlabelUserCloseTwo = new JLabel("Colombia");
		JlabelUserCloseTwo.setBounds(70, 60, 150, 50);
		JlabelUserCloseTwo.setFont(new Font("Serif", Font.PLAIN, 14));
		JlabelUserCloseTwo.setFont(fuenteClose);
		JlabelUserCloseTwo.setForeground(new Color(255,255,255));
		menu1.add(JlabelUserCloseTwo);	
	
		jLabelNameUser =  new  JLabel ();
		jLabelNameUser . setBounds ( 40 , 190 , 100 , 20 );
		jLabelNameUser.setText(personController.getActualPerson().getFirstName());
		jLabelNameUser.setBackground(Color.red);
	    menu1.add(jLabelNameUser);
	     
	    jLabelFirstUser = new JLabel();
		jLabelFirstUser.setBounds(40, 210, 120, 20);
		jLabelFirstUser.setText(personController.getActualPerson().getLastName());
		jLabelFirstUser.setBackground(Color.red);
		menu1.add(jLabelFirstUser);
	        
		jPanelIcon = new JLabel("");
		jPanelIcon.setBounds(50,100,80,80);
		jPanelIcon.setBackground(new Color(0,0,0,0));
		BackgroundUser nn= new BackgroundUser();
		jPanelIcon.add(nn);
		menu1.add(jPanelIcon);
		menu1.setOpaque(true);
		menu1.setVisible(false);
		
		jPanelTable= new JLabel();
		jPanelTable.setBounds(0, 0, 0, 0);
		jPanelTable.setBackground(new Color(171,217,250,98));
		jLabel.add(jPanelTable);
		

		pro = new JTextArea();
		pro.setBounds ( 200 , 150,700, 700 );
		pro.setBackground(new Color(0,0,0,0));
		pro.setOpaque(true);
		
		jScrollPaneList = new JScrollPane();
		jScrollPaneList.setBounds ( 200 , 150,660, 500 );
		jScrollPaneList.setOpaque(false);
		jScrollPaneList.getViewport().setOpaque(true);
		jScrollPaneList.setViewportView(pro);
		jLabel.add(jScrollPaneList);
		
		jLabel.add(backgroundFondo);

	}
	
	public void showProducts(Product[] productList) { //
		int count=0;
		int counTwo=0;
		String[] header= {"Nombre ProductoU", "disponiblesU vendidad"};
		body =  new Componets[productList.length][4];
		ListenerShop listenerShop = new ListenerShop(this);
		for (int i = 0; i <productList.length; i++) {
			if (count == 4) {
				count =0;
				counTwo++;
			}
			Componets com = new Componets();
			com.getjLabel().setBounds(155*count, 155*counTwo, 150, 150);
			com.getLees().addActionListener(listenerShop);
			com.getMore().addActionListener(listenerShop);
			com.getName().setText(productList[i].getName());
			com.getDescription().setText(productList[i].getDescription());
			com.setMaximed(productList[i].getUnitsAvailable());
			com.getPrice().setText(productList[i].getUnitPrice()+"");
			pro.add(com.getjLabel());
			body[counTwo][count]=com;
			jLabel.repaint();
			body[counTwo][count].setProduct(productList[i]);
			
			count++;
			
		}
		
		jScrollPaneList.setBorder(new RoundedBorder(2));
		/*for (int i = 0; i < body.length; i++) {
			for (int j = 0; j < body.length; j++) {
				if (i==0 && j < productList.length) {
					Componets com = new Componets();
					com.getjLabel().setBounds(155*i, 155*j, 150, 150);
					com.getLees().addActionListener(listenerShop);
					com.getMore().addActionListener(listenerShop);
					com.getName().setText(productList[j].getName());
					com.getDescription().setText(productList[j].getDescription());
					com.setMaximed(productList[j].getUnitsAvailable());
					com.getPrice().setText(productList[j].getUnitPrice()+"");
					//System.out.println(productList[j].getUnitsAvailable()+"                                 asi");
					pro.add(com.getjLabel());
					body[i][j]=com;
					jLabel.repaint();
					body[i][j].setProduct(productList[j]);
				}	
			}
		}
		*/
	}
	
	public Componets[][] getBody() {
		return body;
	}

	public void lateral() {
		menu1.setVisible(true);
			
		
	}
	public void e() {
		menu1.setVisible(false);
	}
	
	
	public void setBody(Componets[][] body) {
		this.body = body;
	}

}
