package views.updateAndDeletePerson;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.PersonController;
import models.Person;
import models.Util;
import views.registryPerson.ActionsRegistry;
import views.registryPerson.JPanelRegistry;
import views.registryPerson.ListenerRegistry;
import views.text.RoundedBorder;
import views.text.TextPrompt;

public class JPanelUpDelete extends JPanel {
	private ListenerUpDelete listenerUpDelete;
	private Person actualPerson;
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
	private JButton jButtonUp;
	private JButton jButtonClose;
	private JButton jButtonDelete;
	private JLabel labelName;
	private JLabel labelAge;
	private JTextField jTextAge;
	private JButton jButtonSearch;
	private JLabel labelSearch;
	private JTextField jTextSearch;
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
	
	public JPanelUpDelete(PersonController personController) {
		listenerUpDelete = new ListenerUpDelete(this, personController);
		setLayout ( null );
		jLabel = new JLabel();
		jLabel.setBounds (500, 100, 530, 440);
		jLabel.setOpaque(true);
		this.add(jLabel);
       // this.setBounds ( 60 , 80 , 530 , 400 );
        //this.setTitle("EpicCoffe");
      //  this.setResizable ( false);
       // this.setLocationRelativeTo ( null );
        init();
       // this.setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );
        
		
	}
	

	private void init() {
		Font fuenteWelcome = new Font("Serif", 3, 14);
		
			labelSearch = new JLabel("Buscar");
			labelSearch.setBounds(15, 25, 60, 25);
			labelSearch.setFont(new Font("Serif", Font.PLAIN, 14));
			labelSearch.setFont(fuenteWelcome);
			labelSearch.setForeground(new Color(110, 81, 40));
			jLabel.add(labelSearch);
	        
		  	jButtonSearch =  new  JButton ();
		  	jButtonSearch.setLayout(null);
	        jButtonSearch.setBounds (477, 23, 20, 20);
	        BackgroundImageSearch backgroundImageSearch = new BackgroundImageSearch();
	        jButtonSearch.add(backgroundImageSearch);
	        jButtonSearch.setFont(new Font("Serif", Font.PLAIN, 14));
	        jButtonSearch.setFont(fuenteWelcome);
	        jButtonSearch.setForeground(new Color(110, 81, 40));
	        jButtonSearch.addActionListener (listenerUpDelete);
	        jButtonSearch.setBorder(new RoundedBorder(10));
	        jButtonSearch.setActionCommand ( ActionsUpDelete.SEARCH. toString ());
	        jButtonSearch .setBackground(new Color(211, 38, 38));
	        jLabel.add (jButtonSearch);
	      
	        
	        jTextSearch =  new  JTextField ();
	        TextPrompt password = new TextPrompt("Ingrese numero de documento",  jTextSearch);
	        jTextSearch . setBounds (160 , 25 , 310 , 20 );
	        jLabel.add(jTextSearch);
		
		
	        labelInI = new JLabel("");
	        labelInI.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelInI.setFont(fuenteWelcome);
	        labelInI.setForeground(new Color(110, 81, 40));
	        labelInI.setBounds(15, 50, 60,25);
	        jLabel.add(labelInI);
	      
	        labelName = new JLabel("Nombres");
	        labelName.setBounds(15, 50, 60,25);
	        labelName.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelName.setFont(fuenteWelcome);
	        labelName.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelName);
	        
	        labelLastName = new JLabel("Apellidos");
	        labelLastName.setBounds(15, 80, 60,15);
	        labelLastName.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelLastName.setFont(fuenteWelcome);
	        labelLastName.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelLastName);
	       
	        labelTypeId= new JLabel("Tipo de documento");
	        labelTypeId.setBounds(15, 100, 150,30);
	        labelTypeId.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelTypeId.setFont(fuenteWelcome);
	        labelTypeId.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelTypeId);
	        
	        labelId = new JLabel("Numero de documento");
	        labelId.setBounds(15, 130, 150,30);
	        labelId.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelId.setFont(fuenteWelcome);
	        labelId.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelId);
	        
	        labelMail = new JLabel("Correo");
	        labelMail.setBounds(15, 160,60,30 );
	        labelMail.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelMail.setFont(fuenteWelcome);
	        labelMail.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelMail);
	        
	        labelPassword= new JLabel("Contraseña");
	        labelPassword.setBounds(15, 190, 100,30 );
	        labelInI.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelPassword.setFont(fuenteWelcome);
	        labelPassword.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelPassword);
	        
	        labelTypePerson = new JLabel("Tipo de Persona");
	        labelTypePerson.setBounds(15, 220, 120,30 );
	        labelTypePerson.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelTypePerson.setFont(fuenteWelcome);
	        labelTypePerson.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelTypePerson);
	        
	        labelDateOfBirth = new JLabel("Fecha de nacimineto");
	        labelDateOfBirth.setBounds(15, 290,150,30 );
	        labelDateOfBirth.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelDateOfBirth.setFont(fuenteWelcome);
	        labelDateOfBirth.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelDateOfBirth);
	        
	        labelAge= new JLabel("Edad");	
	        labelAge.setBounds(15, 254,150,30 );
	        labelAge.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelAge.setFont(fuenteWelcome);
	        labelAge.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelAge);
	        
	        jTextAge =  new  JTextField ();
	        jTextAge . setBounds ( 160 , 260 , 340 , 20 );
	        jTextAge.setEditable(false);
	        jLabel.add(jTextAge);
	               
	        labelYear = new JLabel("Año");
	        labelYear.setBounds(160, 290,120,30 );
	        labelYear.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelYear.setFont(fuenteWelcome);
	        labelYear.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelYear);
	        
	        labelMount = new JLabel("Mes");
	        labelMount.setBounds(270, 290,120,30 );
	        labelMount.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelMount.setFont(fuenteWelcome);
	        labelMount.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelMount);
	        
	        labelDay= new JLabel("Dia");
	        labelDay.setBounds(380, 290,120,30 );
	        labelDay.setFont(new Font("Serif", Font.PLAIN, 14));
	        labelDay.setFont(fuenteWelcome);
	        labelDay.setForeground(new Color(110, 81, 40));
	        jLabel.add(labelDay);
	        
	        jNameText =  new  JTextField ();
	    	if(jNameText.getText().length()>=1) {
	    		jNameText.setText(jNameText.getText().substring(0, 30));
	        }
	    	jNameText.setBounds(160, 50, 340, 20);
	    	jLabel.add(jNameText);
	        
	        jLastNameText =  new  JTextField ();
	        jLastNameText.setBounds(160, 80, 340, 20);
	        jLabel.add(jLastNameText);
	        
	        jLastId =  new  JTextField ();
	        jLastId.setBounds(160, 140, 340, 20);
	        jLabel.add(jLastId);
	        
	        jMail =  new  JTextField ();
	        jMail.setBounds(160, 170, 340, 20);
	        jLabel.add(jMail);
	        
	        jPassword =  new  JTextField ();
	        jPassword.setBounds(160, 200, 340, 20);
	        jLabel.add(jPassword);
		    
	       
	        jComboBoxTypeId = new JComboBox();
		    jComboBoxTypeId.addItem("CC - Cédula de ciudadanía");
		    jComboBoxTypeId.addItem("CE - Cédula de extranjería");
		    jComboBoxTypeId.addItem("PA -  Pasaporte");
		    jComboBoxTypeId.setFont(new Font("Serif", Font.PLAIN, 14));
		    jComboBoxTypeId.setFont(fuenteWelcome);
		    jComboBoxTypeId.setForeground(new Color(110, 81, 40));
		    jComboBoxTypeId.setBounds(160, 110, 340, 20);
		    jComboBoxTypeId.setSelectedIndex(0);
		   //JComboBoxTypeId.addActionListener(registryListener);
		    jLabel.add(jComboBoxTypeId);
		    
		    jComboBoxTypePerson = new JComboBox();
		    jComboBoxTypePerson.addItem("AD - Administrador");
		    jComboBoxTypePerson.addItem("AS - Asociado");
		    jComboBoxTypePerson.addItem("CL -  Cliente");
		    jComboBoxTypePerson.setBounds(160, 230 , 340, 20);
		    jComboBoxTypePerson.setFont(new Font("Serif", Font.PLAIN, 14));
		    jComboBoxTypePerson.setFont(fuenteWelcome);
		    jComboBoxTypePerson.setForeground(new Color(110, 81, 40));
		    jComboBoxTypePerson.setSelectedIndex(1);
		    jLabel.add(jComboBoxTypePerson);
		    
		    jComboBoxYear = new JComboBox();
		    for (int i = 1871; i <= 2022; i++) {
			   jComboBoxYear.addItem(i+"");
		    }
		    jComboBoxYear.setBounds(190, 290, 70, 30);
		    jComboBoxYear.setFont(new Font("Serif", Font.PLAIN, 14));
		    jComboBoxYear.setFont(fuenteWelcome);
		    jComboBoxYear.setForeground(new Color(110, 81, 40));
		    jComboBoxYear.setSelectedItem("2000");
		    jComboBoxYear.addActionListener (listenerUpDelete);
		    jComboBoxYear. setActionCommand ( ActionsUpDelete.DAYS.toString ());
		    jLabel.add(jComboBoxYear);
		    
		    jComboBoxMounth = new JComboBox();
		    for (int i = 1; i <= 12; i++) {
		    	jComboBoxMounth.addItem(i+"");
			}
		   	jComboBoxMounth.setBounds(300, 290, 70, 30);
		   	jComboBoxMounth.setFont(new Font("Serif", Font.PLAIN, 14));
		   	jComboBoxMounth.setFont(fuenteWelcome);
		   	jComboBoxMounth.setForeground(new Color(110, 81, 40));
		    jComboBoxMounth.setSelectedItem("3");
		    jComboBoxMounth.addActionListener (listenerUpDelete);
		    jComboBoxMounth. setActionCommand ( ActionsUpDelete.DAYS.toString ());
		    jLabel.add(jComboBoxMounth);
		    
 
		    jComboBoxDay = new JComboBox();
		    for (int i = 1; i <= 31; i++) {
		    	jComboBoxDay.addItem(i+"");
			}
		    jComboBoxDay.setBounds(410, 290, 70, 30);
		    jComboBoxDay.setFont(new Font("Serif", Font.PLAIN, 14));
		    jComboBoxDay.setFont(fuenteWelcome);
		    jComboBoxDay.setForeground(new Color(110, 81, 40));
		    jComboBoxDay.setSelectedItem("12");
		    //JComboBoxDay .setBackground(new Color(242, 152, 27));
		    jLabel.add(jComboBoxDay);
	        
	        jButtonClose =  new  JButton ( "Cerrar" );
	        jButtonClose.setBounds (390, 335, 90, 40);
	        jButtonClose.setFont(new Font("Serif", Font.PLAIN, 14));
	        jButtonClose.setFont(fuenteWelcome);
	        jButtonClose.setForeground(new Color(110, 81, 40));
	        jButtonClose.addActionListener (listenerUpDelete);
	        jButtonClose.setBorder(new RoundedBorder(10));
	        jButtonClose.setActionCommand ( ActionsUpDelete.CLOSE.toString ());
	        jLabel.add (jButtonClose);
	        jButtonClose.setBackground(new Color(114, 247, 167));
		}
	
		public void generateButtons() {
			Font fuenteWelcome = new Font("Serif", 3, 14);
			jButtonDelete = new JButton ( "Eliminar" );
	        jButtonDelete.setBounds (190, 335, 90, 40);
	        jButtonDelete.setFont(new Font("Serif", Font.PLAIN, 14));
	        jButtonDelete.setFont(fuenteWelcome);
	        jButtonDelete.setForeground(new Color(110, 81, 40));
	        jButtonDelete.addActionListener (listenerUpDelete);
	        jButtonDelete.setBorder(new RoundedBorder(10));
	        jButtonDelete.setActionCommand ( ActionsUpDelete.DELETE. toString ());
	        jButtonDelete.setBackground(new Color(211, 38, 38));
	        jLabel.add(jButtonDelete);
	        
	        jButtonUp =  new  JButton ( "Actualizar" );
	        jButtonUp.setBounds (290, 335, 90, 40);
	        jButtonUp.setFont(new Font("Serif", Font.PLAIN, 14));
	        jButtonUp.setFont(fuenteWelcome);
	        jButtonUp.setForeground(new Color(110, 81, 40));
	        jButtonUp.addActionListener (listenerUpDelete);
	        jButtonUp.setBorder(new RoundedBorder(10));
	        jButtonUp.setBackground(new Color(242, 152, 27));
	        jButtonUp.setActionCommand ( ActionsUpDelete.UPDATE.toString());
	        jLabel.add (jButtonUp);
	        
	        jLabel.repaint();
		}

		public void showPerson(Person person) {
			jNameText.setText(person.getFirstName());
			jLastNameText.setText(person.getLastName());
			jTextAge.setText(String.valueOf(person.getAge()));
			jLastId.setText(person.getDocumentNumber());
			switch (person.getTypeDocument()) {
			case "CC":
				jComboBoxTypeId.setSelectedItem("CC - Cédula de ciudadanía");
				break;
			case "CE":
				jComboBoxTypeId.setSelectedItem("CE - Cédula de extranjería");
				break;
			case "PA":
				jComboBoxTypeId.setSelectedItem("PA -  Pasaporte");
				break;
			}
			jMail.setText(person.getUser());
			jPassword.setText(person.getPassword());
			jComboBoxTypePerson.setSelectedItem(person.getTypeOfPerson());
			actualPerson = person;
			jComboBoxYear.setSelectedItem(String.valueOf(person.getDateOfBirth().get(Calendar.YEAR)));
			jComboBoxMounth.setSelectedItem(String.valueOf(person.getDateOfBirth().get(Calendar.MONTH) + 1));
			jComboBoxDay.setSelectedItem(String.valueOf(person.getDateOfBirth().get(Calendar.DAY_OF_MONTH)));
			
		}

		public void setDays() {
			if (jComboBoxDay != null) {
				jComboBoxDay.removeAllItems();
				int days = Util.getDay(jComboBoxYear.getSelectedItem().toString(),
						jComboBoxMounth.getSelectedItem().toString());
				for (int i = 1; i <= days; i++) {
					jComboBoxDay.addItem(i + "");
				}
			}
		}
		
		public JTextField getjTextSearch() {
			return jTextSearch;
		}

		public  JTextField  getjNameText () {
	        return jNameText;
	    }
	    
		public JTextField getjLastNameText() {
			return jLastNameText;
		}
	
		public JTextField getjLastId() {
			return jLastId;
		}
	
		public JComboBox getJComboBoxTypeId() {
			return jComboBoxTypeId;
		}
		
		public JComboBox getJComboBoxYear() {
			return jComboBoxYear;
		}

		public JComboBox getJComboBoxMounth() {
			return jComboBoxMounth;
		}
		
		public JComboBox getJComboBoxDay() {
			return jComboBoxDay;
		}
		
		public JTextField getjTextAge() {
			return jTextAge;
		}

		public JTextField getjPassword() {
			return jPassword;
		}
		
		public JTextField getjMail() {
			return jMail;
		}

		public JComboBox getjComboBoxTypePerson() {
			return jComboBoxTypePerson;
		}


		public Person getActualPerson() {
			return actualPerson;
		}
		

		/*public static void main(String[] args) {
			JFameUpDelete JFameUpDelete = new JFameUpDelete();
			JFameUpDelete.setVisible(true);
		}*/

	}

