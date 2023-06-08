package views.registryPerson;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.PersonController;
import models.Util;
import views.text.*;
import views.updateAndDeletePerson.ActionsUpDelete;
import views.loginIn.JPanelLogin;

public class JPanelRegistry extends JPanel {
	private ListenerRegistry listenerRegistry;
	private JLabel labelInI;
	private JLabel labelLastName;
	private JLabel labelTypeId;
	private JLabel labelId;
	private JLabel labelMail;
	private JLabel labelPassword;
	private JLabel labelTypePerson;
	private JLabel labelDateOfBirth;
	private JComboBox jComboBoxTypeId;
	private JTextField jNameText;
	private JTextField jLastNameText;
	private JTextField jLastId;
	private JTextField jMail;
	private JTextField jPassword;
	private JComboBox jComboBoxTypePerson;
	private JComboBox jComboBoxYear;
	private JLabel labelYear;
	private JLabel labelDay;
	private Component labelMount;
	private JComboBox jComboBoxMounth;
	private JComboBox jComboBoxDay;
	private JButton jButtonSave;
	private JLabel jLabel;
	private JButton jButtonClose;
	
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
	
	public JPanelRegistry(PersonController personController) {
		listenerRegistry = new ListenerRegistry(this, personController);
		setLayout ( null );
		jLabel = new JLabel();
		jLabel.setBounds ( 500 , 150 , 530 , 370 );
		jLabel.setOpaque(true);
		this.add(jLabel);
        //this.setBounds ( 0 , 0 , 530 , 370 );
        //this.setTitle("EpicCoffe");
        //this.setResizable ( false);
        //this.setLocationRelativeTo ( null );
       // JFrameRegistry.setup(); //setting the look and feel
    	//JFrame.setDefaultLookAndFeelDecorated(true);
    	JRootPane jRootPane = new JRootPane();
		//jRootPane.putClientProperty("JRootPane.titleBarBackground", new Color(110, 81, 40));
    	//rootPane.putClientProperty("JRootPane.titleBarForeground", Color.yellow);
        init();
        
      //  this.setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );
	}

	private void init() {
		  labelInI = new JLabel("Nombres");
		  Font fuenteWelcome = new Font("Serif", 3, 14);
		  labelInI.setFont(new Font("Serif", Font.PLAIN, 14));
		  labelInI.setFont(fuenteWelcome);
		  labelInI.setForeground(new Color(110, 81, 40));
	      labelInI.setBounds(15, 30, 60,25);
	      jLabel.add(labelInI);
	        
	      labelLastName = new JLabel("Apellidos");
	      labelLastName.setBounds(15, 60, 60,15);
	      labelLastName.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelLastName.setFont(fuenteWelcome);
	      labelLastName.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelLastName);
	       
	      labelTypeId= new JLabel("Tipo de documento");
	      labelTypeId.setBounds(15, 80, 150,30);
	      labelTypeId.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelTypeId.setFont(fuenteWelcome);
	      labelTypeId.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelTypeId);
	        
	      labelId = new JLabel("Numero de documento");
	      labelId.setBounds(15, 110, 150,30);
	      labelId.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelId.setFont(fuenteWelcome);
	      labelId.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelId);
	        
	      labelMail = new JLabel("Usuario");
	      labelMail.setBounds(15, 140,60,30 );
	      labelMail.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelMail.setFont(fuenteWelcome);
	      labelMail.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelMail);
	        
	      labelPassword= new JLabel("Contraseña");
	      labelPassword.setBounds(15, 170, 100,30 );
	      labelInI.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelPassword.setFont(fuenteWelcome);
	      labelPassword.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelPassword);
	        
	      labelTypePerson = new JLabel("Tipo de Persona");
	      labelTypePerson.setBounds(15, 200, 120,30 );
	      labelTypePerson.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelTypePerson.setFont(fuenteWelcome);
	      labelTypePerson.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelTypePerson);
	        
	      labelDateOfBirth = new JLabel("Fecha de nacimineto");
	      labelDateOfBirth.setBounds(15, 240,140,30 );
	      labelDateOfBirth.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelDateOfBirth.setFont(fuenteWelcome);
	      labelDateOfBirth.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelDateOfBirth);
	        
	      labelMount = new JLabel("Mes");
	      labelMount.setBounds(270, 240,120,30 );
	      labelMount.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelMount.setFont(fuenteWelcome);
	      labelMount.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelMount);
	        
	      labelDay= new JLabel("Dia");
	      labelDay.setBounds(380, 240,120,30 );
	      labelDay.setFont(new Font("Serif", Font.PLAIN, 14));
	      labelDay.setFont(fuenteWelcome);
	      labelDay.setForeground(new Color(110, 81, 40));
	      jLabel.add(labelDay);
	        
	      jNameText =  new  JTextField ();
	      if(jNameText.getText().length()>=1){
	    	  jNameText.setText(jNameText.getText().substring(0, 30));
	      }
	      jNameText . setBounds ( 160 , 30 , 340 , 20 );
	      jLabel.add(jNameText);
	        
	      jLastNameText =  new  JTextField ();
	      jLastNameText . setBounds ( 160 , 60 , 340 , 20 );
	      jLabel.add(jLastNameText);
	        
	      jLastId =  new  JTextField ();
	      jLastId . setBounds ( 160 , 120 , 340 , 20 );
	      jLabel.add(jLastId);
	        
	      jMail =  new  JTextField ();
	      jMail . setBounds ( 160 , 150 , 340 , 20 );
	      jLabel.add(jMail);
	        
	      jPassword =  new  JTextField ();
	      jPassword . setBounds ( 160 , 180 , 340 , 20 );
	      jLabel.add(jPassword);
		    
	       
	      jComboBoxTypeId = new JComboBox();
		  jComboBoxTypeId.addItem("CC - Cédula de ciudadanía");
		  jComboBoxTypeId.addItem("CE - Cédula de extranjería");
		  jComboBoxTypeId.addItem("PA -  Pasaporte");
		  jComboBoxTypeId.setFont(new Font("Serif", Font.PLAIN, 14));
		  jComboBoxTypeId.setFont(fuenteWelcome);
		  jComboBoxTypeId.setForeground(new Color(110, 81, 40));
		  jComboBoxTypeId.setBounds(160 , 90 , 340 , 20);
		  jComboBoxTypeId.setSelectedIndex(0);
		   //JComboBoxTypeId.addActionListener(registryListener);
		  jLabel.add(jComboBoxTypeId);
		    
		  jComboBoxTypePerson = new JComboBox();
		  jComboBoxTypePerson.addItem("AD - Administrador");
		  jComboBoxTypePerson.addItem("AS - Asociado");
		  jComboBoxTypePerson.addItem("CL -  Cliente");
		  jComboBoxTypePerson.setBounds(160 ,210  , 340 , 20);
		  jComboBoxTypePerson.setFont(new Font("Serif", Font.PLAIN, 14));
		  jComboBoxTypePerson.setFont(fuenteWelcome);
		  jComboBoxTypePerson.setForeground(new Color(110, 81, 40));
		  jComboBoxTypePerson.setSelectedIndex(1);
		  jLabel.add(jComboBoxTypePerson);
		    
		  jComboBoxYear = new JComboBox();
		  for (int i = 1901; i <= 2022; i++) {
			   jComboBoxYear.addItem(i+"");
		  }
		  jComboBoxYear.setBounds(190 , 240 , 70 , 30);
		  jComboBoxYear.setFont(new Font("Serif", Font.PLAIN, 14));
		  jComboBoxYear.setFont(fuenteWelcome);
		  jComboBoxYear.setForeground(new Color(110, 81, 40));
		  jComboBoxYear.addActionListener (listenerRegistry);
		  jComboBoxYear. setActionCommand ( ActionsRegistry. YEAR_AND_MOUNTH . toString ());
		  jComboBoxYear.setSelectedItem("2000");
		  jLabel.add(jComboBoxYear);
		   
		    
		  jComboBoxMounth = new JComboBox();
		  for (int i = 1; i <= 12; i++) {
			  jComboBoxMounth.addItem(i+"");
		  }
		  jComboBoxMounth.setBounds(300 , 240 , 70 , 30);
		  jComboBoxMounth.setFont(new Font("Serif", Font.PLAIN, 14));
		  jComboBoxMounth.setFont(fuenteWelcome);
		  jComboBoxMounth.setForeground(new Color(110, 81, 40));
		  jComboBoxMounth.addActionListener (listenerRegistry);
		  jComboBoxMounth. setActionCommand ( ActionsRegistry. YEAR_AND_MOUNTH . toString ());
		  jComboBoxMounth.setSelectedItem("3");
		  jLabel.add(jComboBoxMounth);
		    
		  jComboBoxDay = new JComboBox();
		  for (int i = 1; i <= 31; i++) {
			  jComboBoxDay.addItem(i+"");
		  }
		  jComboBoxDay.setBounds(410 , 240 , 70 , 30);
		  jComboBoxDay.setFont(new Font("Serif", Font.PLAIN, 14));
		  jComboBoxDay.setFont(fuenteWelcome);
		  jComboBoxDay.setForeground(new Color(110, 81, 40));
		  jComboBoxDay.setSelectedItem("12");
		  // jComboBoxDay.addActionListener (listenerRegistry);
		    //jComboBoxDay. setActionCommand ( ActionsRegistry. YEAR_AND_MOUNTH . toString ());
		    //JComboBoxDay .setBackground(new Color(242, 152, 27));
		  jLabel.add(jComboBoxDay);
		    
		  jButtonSave =  new  JButton ( "Guardar" );
	      jButtonSave . setBounds ( 310 , 290 , 110 , 40 );
	      jButtonSave.setFont(new Font("Serif", Font.PLAIN, 14));
	      jButtonSave.setFont(fuenteWelcome);
	      jButtonSave.setForeground(new Color(110, 81, 40));
	      jButtonSave . addActionListener (listenerRegistry);
	      jButtonSave.setBorder(new RoundedBorder(10));
	      jButtonSave . setActionCommand ( ActionsRegistry.ADD. toString ());
	      jLabel.add (jButtonSave);
	      jButtonSave .setBackground(new Color(242, 152, 27));
	      
	      jButtonClose =  new  JButton ( "Cerrar" );
	      jButtonClose.setBounds ( 170 , 290 , 110 , 40 );
	      jButtonClose.setFont(new Font("Serif", Font.PLAIN, 14));
	      jButtonClose.setFont(fuenteWelcome);
	      jButtonClose.setForeground(new Color(110, 81, 40));
	      jButtonClose.addActionListener (listenerRegistry);
	      jButtonClose.setBorder(new RoundedBorder(10));
	      jButtonClose.setActionCommand ( ActionsRegistry.CLOSE . toString ());
	      jButtonClose.setBackground(new Color(114, 247, 167));
	      jLabel.add (jButtonClose);
	      
		   
	}
	/*public static void main(String[] args) {
		JFrameRegistry JFrameRegistry = new JFrameRegistry();
		JFrameRegistry.setVisible(true);
	}*/
	
	public void setDays() {
		if(jComboBoxDay!=null) {
		jComboBoxDay.removeAllItems();
		int days = Util.getDay(jComboBoxYear. getSelectedItem().toString(),
				jComboBoxMounth.getSelectedItem().toString());
		for (int i = 1; i <= days; i++) {
			jComboBoxDay.addItem(i+"");
		}
		jComboBoxMounth.setSelectedItem(jComboBoxMounth. getSelectedItem().toString());
		jComboBoxDay.setSelectedItem("12");
		}
	}

	public JComboBox getjComboBoxTypeId() {
		return jComboBoxTypeId;
	}

	public JTextField getjNameText() {
		return jNameText;
	}

	public JTextField getjLastNameText() {
		return jLastNameText;
	}

	public JTextField getjLastId() {
		return jLastId;
	}

	public JTextField getjMail() {
		return jMail;
	}

	public JTextField getjPassword() {
		return jPassword;
	}

	public JComboBox getjComboBoxTypePerson() {
		return jComboBoxTypePerson;
	}

	public JComboBox getjComboBoxYear() {
		return jComboBoxYear;
	}

	public JComboBox getjComboBoxMounth() {
		return jComboBoxMounth;
	}

	public JComboBox getjComboBoxDay() {
		return jComboBoxDay;
	}
	
	
}
