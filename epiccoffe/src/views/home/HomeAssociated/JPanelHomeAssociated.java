package views.home.HomeAssociated;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.BorderFactory;
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
import models.Person;
import models.Product;
import views.home.homeAdministrator.BackgroundFondo;
import views.home.homeAdministrator.BackgroundUser;
import views.text.RoundedBorder;
import views.home.homeAdministrator.BackgroundButtonMenu;

public class JPanelHomeAssociated extends JPanel {
	
	private ListenerHomeAssociated listenerHomeAssociated;
	private JLabel jLabelUser;
	private JLabel jLabelContac;
	private JLabel jLabelLocation;
	private JLabel jLabelPrice;
	private JPanel Jpannel;
	private JLabel jLabeName;
	private JLabel jLabeDespriction;
	private JButton jButtonAssociates;
	private JPanel jPanelTable;
	private JScrollPane jScrollPaneList;
	private JLabel jLabelNameUser;
	private JLabel menu1;
	private JButton button;
	private JLabel JlabelUserClose;
	private JLabel JlabelUserCloseTwo;
	private JLabel jPanelIcon;
	private JLabel menu;
	private ProductController productController;
	private PersonController personController;
	private JLabel jLabel;
	private JLabel  jLabelFirstUser;
	
	public JPanelHomeAssociated(PersonController personController, ProductController productController ) {
		this.setLayout(null);
		this.productController = productController;
		this.personController = personController;
		jLabel = new JLabel();
		jLabel.setBounds(0, 0, 1366, 768);
		listenerHomeAssociated = new ListenerHomeAssociated(this, personController);
		this.add(jLabel);
		//this.setTitle("EpicCoffe");
		//this.setBounds(0, 0, 810, 470);
		//this.setLocationRelativeTo(null);
		init();
		
		//this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GraphicsDevice grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//grafica.setFullScreenWindow(this);
		
		setEnabled(true);
		//setResizable(false);
		setVisible(true);
	}
	
	private void init() {
		jLabelUser = new JLabel("Asociado");
		jLabelUser.setBounds(10, 15, 150, 50);
		Font fuente = new Font("Calibri", 3, 18);
		jLabelUser.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelUser.setFont(fuente);
		jLabelUser.setForeground(new Color(255,255,255));
		jLabel.add(jLabelUser);
		
		jLabelContac = new JLabel("(+52) 3209266940");
		jLabelContac.setBounds(1180, 15, 150, 50);
		//Font fuente = new Font("Calibri", 3, 18);
		jLabelContac.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelContac.setFont(fuente);
		jLabelContac.setForeground(new Color(255,255,255));
		jLabel.add(jLabelContac);
		
		jLabelLocation = new JLabel("Ubicacion");
		jLabelLocation.setBounds(920, 15, 150, 50);
		jLabelLocation.setToolTipText("Tunja / Boyaca");
		//Font fuente = new Font("Calibri", 3, 18);
		jLabelLocation.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelLocation.setFont(fuente);
		jLabelLocation.setForeground(new Color(255,255,255));
		jLabel.add(jLabelLocation);
		
		jLabelPrice = new JLabel("Valor Asociacion");
		jLabelPrice.setBounds(1020, 15, 150, 50);
		//Font fuente = new Font("Calibri", 3, 18);
		jLabelPrice.setToolTipText("$$$$$$$");
		jLabelPrice.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabelPrice.setFont(fuente);
		jLabelPrice.setForeground(new Color(255,255,255));
		jLabel.add(jLabelPrice);
		
		
		jLabeName = new JLabel("EpicCoffe");
		jLabeName.setBounds(920, 380, 1000, 120);
		Font fuente2 = new Font("Calibri", 3, 80);
		jLabeName.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabeName.setFont(fuente2);
		jLabeName.setForeground(new Color(255, 255, 255));
		jLabel.add(jLabeName);

		jLabeDespriction = new JLabel("Cooperativa Cafetera de Colombia");
		jLabeDespriction.setBounds(880, 450, 1000, 120);
		Font fuente3 = new Font("Calibri", 3, 28);
		jLabeDespriction.setFont(new Font("Serif", Font.PLAIN, 14));
		jLabeDespriction.setFont(fuente3);
		jLabeDespriction.setForeground(new Color(255, 255, 255));
		jLabel.add(jLabeDespriction);

		Jpannel = new JPanel();
		Jpannel.setBounds(0, 0, 1620, 80);
		Jpannel.setBackground(new Color(110, 81, 40));
		jLabel.add(Jpannel);

		jButtonAssociates = new JButton("Registrar Producto");
		jButtonAssociates.setBounds(870, 85, 130, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeAssociated);
		jButtonAssociates.setActionCommand(ActionsHomeAssociated.REGISRTY.toString());
		jLabel.add(jButtonAssociates);

		jButtonAssociates = new JButton("Actualizar Producto");
		jButtonAssociates.setBounds(1010, 85, 140, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeAssociated);
		jButtonAssociates.setActionCommand(ActionsHomeAssociated.UPDATE.toString());
		jLabel.add(jButtonAssociates);

		jButtonAssociates = new JButton("Eliminar Producto");
		jButtonAssociates.setBounds(1160, 85, 130, 30);
		jButtonAssociates.setBorder(new RoundedBorder(10));
		jButtonAssociates.setBackground(new Color(242, 152, 27));
		jButtonAssociates.addActionListener(listenerHomeAssociated);
		jButtonAssociates.setActionCommand(ActionsHomeAssociated.DELETE.toString());
		jLabel.add(jButtonAssociates);
		
		menu = new JLabel();
		menu.setBounds(6,85,40,30);
		BackgroundButtonMenu backgroundButtonMenu = new BackgroundButtonMenu();
		menu.add(backgroundButtonMenu);
		menu.addMouseListener(listenerHomeAssociated);
		jLabel.add(menu);
	
		menu1 = new JLabel();
		menu1.setBounds(0,80,200,305);
		menu1.setBackground(new Color(171,217,250,98));
		menu1.setBorder(new RoundedBorder(2));
		jLabel.add(menu1);
	
		
		button = new JButton("Salir");
		button.setBounds(50,250,80, 30);
		button.setBackground(new Color(242, 152, 27));
		button.addActionListener(listenerHomeAssociated);
		button.setActionCommand(ActionsHomeAssociated.EXIT.toString());
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
		
		/////tabla
		
		jPanelTable= new JPanel();
		jPanelTable.setBounds(0, 0, 0, 0);
		jPanelTable.setBackground(new Color(171,217,250,98));
		jLabel.add(jPanelTable);
		
		 
		Product [] personList = null;
		
		String[] header= {"  cod  ", "Nombre del Producto", "Us disponibles", "Us vendidas", "precio por unidad", "precio total"};
		try {
			personList = productController.showProduct();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String[][] body= new String[personList.length][6];
		for (int i = 0; i < body.length; i++) {
			body[i][0]=personList[i].getId()+"";
			body[i][1]=personList[i].getName();
			body[i][2]=personList[i].getUnitsAvailable()+"";
			body[i][3]=personList[i].getSoldUnits()+"";
			body[i][4]=personList[i].getUnitPrice() + "";
			body[i][5]=personList[i].getTotalSalesValue()+"";
		}
		
		DefaultTableModel model = new DefaultTableModel(body, header);
		
		JTable table = new JTable(model);
		table.setBorder(new RoundedBorder(2));
		table.setGridColor(Color.BLACK);
		
	
		table.setEnabled(false);
		table.setOpaque(true);
		table.setShowGrid(true);
		
		jScrollPaneList = new JScrollPane();
		jScrollPaneList.setBounds ( 200 , 150,660, 200 );
		jScrollPaneList.setViewportView(table);
		//jScrollPaneList.setBackground(new Color(0,0,0,0));
		jScrollPaneList.setBorder(new RoundedBorder(2));
		jScrollPaneList.setOpaque(false);
		jScrollPaneList.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneList.getViewport().setOpaque(false);
		jPanelTable.setLayout(null);
		jLabel.add(jScrollPaneList);
		BackgroundFondo backgroundFondo = new BackgroundFondo();
		jLabel.add(backgroundFondo);
		backgroundFondo.addMouseListener(new ListenerMouseAssociated(this));

	}
	
	public void lateral() {
		menu.setVisible(false);
		menu1.setVisible(true);				
	}
	
	public void e() {
		menu1.setVisible(false);
		menu.setVisible(true);
	}
}
