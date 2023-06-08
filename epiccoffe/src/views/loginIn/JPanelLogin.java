package views.loginIn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import controllers.PersonController;
import views.text.TextPrompt;

import views.text.RoundedBorder;

public class JPanelLogin extends JPanel {
	//private JPanel login;
	private ListenerLoginIn listenerLoginIn;
	private BackgroundImage backgroundImage;
	private JLabel labelNameApp;
	private JTextField JNameUser;
	private JPasswordField jNamePassword;
	private JButton jButtonLogin;
	private JLabel labelWelcome;
	private JLabel jLabel;
	private ImageIcon icono;
	private ImageIcon iconod;
	private  Dimension dimension;
	
	private String url = "./resources/imagenes/fondoa.jpg";

   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         dimension= this.getSize();
        ImageIcon ImageIcon = new ImageIcon(url);
        g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
        System.out.println("hola + " +dimension.width+"   "+dimension.height);
        setOpaque(false);
    }
	
	public JPanelLogin(PersonController personController) {
		this.setLayout(null);
		jLabel = new JLabel();
		jLabel.setBounds(500, 40, 420, 450);
		jLabel.setBackground(new Color(255, 193, 53));
		jLabel.setOpaque(true);
		icono = new ImageIcon("./resources/imagenes/fondo.png");
		this.add(jLabel);
		listenerLoginIn = new ListenerLoginIn(this, personController);
		init();
	}

	public void init() {	
		
		labelNameApp = new JLabel("EpicCoffe");
		Font fuente = new Font("Calibri", 3, 36);
		labelNameApp.setBounds((int) 140, 40, 150, 60);
		labelNameApp.setFont(new Font("Serif", Font.PLAIN, 14));
		labelNameApp.setFont(fuente);
		labelNameApp.setForeground(new Color(110, 81, 40));
		jLabel.add(labelNameApp);

		labelWelcome = new JLabel("Bienvenido");
		Font fuenteWelcome = new Font("Calibri", 3, 18);
		labelWelcome.setBounds((int) 165, 160, 150, 60);
		labelWelcome.setFont(new Font("Serif", Font.PLAIN, 14));
		labelWelcome.setFont(fuenteWelcome);
		labelWelcome.setForeground(new Color(110, 81, 40));
		jLabel.add(labelWelcome);

		JNameUser = new JTextField();
		JNameUser.setBounds(115, 240, 180, 30);
		TextPrompt use = new TextPrompt("Usuario",  JNameUser);
		jLabel.add(JNameUser);

		jNamePassword = new JPasswordField();
		jNamePassword.setBounds(115, 300, 180, 30);
		jNamePassword.setEchoChar('*');
		jNamePassword.setToolTipText("Ingrese Contraseña");
        TextPrompt password = new TextPrompt("Contraseña",  jNamePassword);
        jLabel.add(jNamePassword);

		jButtonLogin = new JButton("Ingresar");
		jButtonLogin.setBounds(165, 360, 80, 30);
		jButtonLogin.addActionListener(listenerLoginIn);
		jButtonLogin.setActionCommand ( OptionLoginIn . ENTER . toString ());
		jButtonLogin.setBorder(new RoundedBorder(10));
		jButtonLogin.setBackground(new Color(242, 152, 27));
		
	
		jLabel.add(jButtonLogin);
		
		
	}

	public JTextField getJNameUse() {
		return JNameUser;
	}
	public JPasswordField getJNamePassword() {
		return jNamePassword;
	}
	
	
	
}
