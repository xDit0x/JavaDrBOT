package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements WindowListener, ActionListener {
	JPanel mainPanel = new JPanel();
	GridBagLayout mainLayout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel drBotLabel = new JLabel("DRBOT | Citas médicas");
	JButton btnLogin = new JButton("Iniciar sesión");
	JTextField txtfUser = new JTextField();
	JTextField txtfPassw = new JTextField();


	String txtUser = "";
	String txtPassw = "";
	
	

	public final void initialize() {
		this.setTitle("DrBot | Citas médicas");
		this.setSize(2550, 1600);
		this.setMinimumSize(new Dimension(640, 480));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.add(mainPanel);

		drBotLabel.setBackground(new Color(255,255,255));
		drBotLabel.setForeground(new Color(0,0,0));
	

		txtfUser.setPreferredSize(new Dimension(200,20));
		txtfPassw.setPreferredSize(new Dimension(200,20));

		txtfUser.setName("Usuario");
		txtfPassw.setName("Contraseña");

		txtfUser.setToolTipText("Introduzca su nombre de usuario.");
		txtfPassw.setToolTipText("Introduzca su contraseña.");
		
		mainPanel.setLayout(mainLayout);

		JPanel panelHeader = new JPanel();
		gbc.gridx=0; gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		mainPanel.add(panelHeader, gbc);
		panelHeader.add(drBotLabel);

		GridBagConstraints gbcLogin = new GridBagConstraints();
		gbcLogin.insets = new Insets(5,5,5,5);
		gbcLogin.fill = GridBagConstraints.HORIZONTAL;

		JPanel loginPanel = new JPanel(new GridBagLayout());
		mainPanel.add(loginPanel);

		gbcLogin.gridy = 0; gbcLogin.gridx = 0;
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 14));
		loginPanel.add(lblUser, gbcLogin);
		gbcLogin.gridx = 1;
		loginPanel.add(txtfUser, gbcLogin);

		gbcLogin.gridy = 1;gbcLogin.gridx = 0;
		JLabel lblPassw = new JLabel("Contraseña");
		lblPassw.setFont(new Font("Verdana", Font.BOLD , 14));

		loginPanel.add(lblPassw, gbcLogin);
		gbcLogin.gridx = 1;
		loginPanel.add(txtfPassw, gbcLogin);
		gbcLogin.gridwidth = 2;
		gbcLogin.gridx = 0;
		gbcLogin.gridy = 2;
		loginPanel.add(btnLogin, gbcLogin);
		JLabel inicioSesion= new JLabel();
		gbcLogin.gridx = 0;
		gbcLogin.gridy = 3; 
		loginPanel.add(inicioSesion,gbcLogin);
		gbc.gridwidth = 1;
		gbcLogin.gridx = 1;
		gbcLogin.gridy = 3; 
		JButton crearCuenta = new JButton("Crea una cuenta nueva.");
		loginPanel.add(crearCuenta, gbcLogin);
		crearCuenta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CreateAccountFrame createAccountFrame = new CreateAccountFrame();
				dispose();
			}
		});


		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				txtUser = txtfUser.getText();
				txtPassw = txtfPassw.getText();
				int logStatus = (Login.verificarLoggeo(txtUser, txtPassw));
                            switch (logStatus) {
								case 5:
									inicioSesion.setText("Inicio correcto");
									loginPanel.add(inicioSesion);
									System.out.println("Inicio correcto");
									//Crear un FRAME de admin
									dispose();
									break;	
                                case 2:
                                    inicioSesion.setText("Inicio correcto");
                                    loginPanel.add(inicioSesion);
                                    System.out.println("Inicio correcto");
									//Crear un FRAME de usuario
									dispose();
                                    break;
                                case 1:
                                    inicioSesion.setText("Usuario correcto, contraseña inválida");
                                    loginPanel.add(inicioSesion);
                                    System.out.println("Usuario correcto, contraseña inválida");
                                    break;
								case -1:
									inicioSesion.setText("Introduzca los datos para iniciar sesión");
                                    loginPanel.add(inicioSesion);
                                    System.out.println("Introduzca los datos para iniciar sesión");
                                    break;
                                default:
                                    inicioSesion.setText("Perfil no existente.");
                                    loginPanel.add(inicioSesion);
                                    System.out.println("Usuario o contraseña incorrectos.");
                                    break;
                            }

		}});
			
		this.setVisible(true);
	}
 
	
	public static void main(String[] args) {
		new LoginFrame();
	}

	public LoginFrame() {
		initialize();
	}

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	//Método abstracto para interfaz ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}