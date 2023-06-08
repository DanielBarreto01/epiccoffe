package views.facture.invoice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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

import views.text.RoundedBorder;


public class JPanelInvoice extends JPanel {
	
	private ListenerInvoice listenerInvoice;
	private JLabel jLabelName;
	private JPanel jPanelHeader;
	private JButton jButtonCancel;
	private JLabel jPanelTable;
	private JScrollPane jScrollPaneList;
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
	
	public JPanelInvoice(PersonController personController) {
		listenerInvoice = new ListenerInvoice(this, personController);
		setLayout ( null );
		jLabel = new JLabel();
        jLabel.setBounds ( 500 , 100 , 410, 480 );
        jLabel.setOpaque(true);
        this.add(jLabel);
        init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		jPanelHeader = new JPanel();
		jPanelHeader.setBounds(0, 0, 410, 30);
		jPanelHeader.setBackground(new Color(110,81,40));
		jLabel.add(jPanelHeader);
		
		
		jLabelName= new JLabel("Factura");
		jLabelName.setBounds(5,5 , 60, 30);
		jLabelName.setForeground(new Color(255,255,255));
		
		jPanelHeader.add(jLabelName);
		
		jButtonCancel = new JButton("Finalizar");
		jButtonCancel.setBounds(160, 340, 90, 30);
		jButtonCancel.setBorder(new RoundedBorder(5));
		jButtonCancel.setBackground(new Color(218, 247, 249));
		jButtonCancel.addActionListener(listenerInvoice);
		jButtonCancel.setActionCommand(ActionsInvoice.EXIT.toString());
		jLabel.add(jButtonCancel);
		

		jPanelTable= new JLabel();
		jPanelTable.setBounds(0, 0, 0, 0);
		jPanelTable.setBackground(new Color(171,217,250,98));
		jLabel.add(jPanelTable);
		
		 
		
		
		String[] header= {"Nombre ","Precio U","Unidades"};
		
		String[][] body= new String[1][3];
		body[0][1]="hola \n jkd";
	
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
		
	}

}
