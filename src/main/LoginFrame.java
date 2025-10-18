package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;
import java.io.IOException;

public class LoginFrame extends JFrame implements WindowListener, ActionListener {
	JPanel mainPanel = new JPanel();
	JLabel drBotLabel = new JLabel("DRBOT | Citas médicas");
	JButton btnLogin = new JButton("Iniciar sesión");
	JTextField txtfUser = new JTextField();
	JTextField txtfPassw = new JTextField();
	JButton cambioModoClO = new JButton();
	String rtArchivoCandal = "/Users/peterpunk/eclipse-workspace/drbotProgram1.8/src/main/Fonts/Candal-Regular.ttf";
	boolean modoClaro = false;

	String txtUser = "";
	String txtPassw = "";
	
	public final void initialize() {
		this.setTitle("DrBot | Citas médicas");
		this.setSize(300, 400);		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.setResizable(false);
		mainPanel.setBackground(new Color(71, 186, 178));
		getContentPane().add(mainPanel);
		drBotLabel.setBounds(30, 1, 226, 24);
		drBotLabel.setFont(cargarFuente(rtArchivoCandal,18));

		drBotLabel.setBackground(new Color(86, 229, 220));
		drBotLabel.setForeground(new Color(16, 44, 60));
		mainPanel.setLayout(null);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(71, 186, 178));
		panelHeader.setBounds(6, 5, 288, 26);
		mainPanel.add(panelHeader);
		panelHeader.setLayout(null);
		panelHeader.add(drBotLabel);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(194, 215, 218));
		loginPanel.setBounds(-303, 36, 906, 357);
		mainPanel.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel inicioSesion= new JLabel();
		inicioSesion.setBounds(7, 19, 0, 0);
		loginPanel.add(inicioSesion);
				
				JButton crearCuenta = new JButton("Crea una cuenta nueva.");
				crearCuenta.setForeground(new Color(16, 44, 60));
				crearCuenta.setFont(cargarFuente(rtArchivoCandal,14));
				crearCuenta.setBounds(323, 274, 263, 29);
				loginPanel.add(crearCuenta);
						btnLogin.setForeground(new Color(16, 44, 60));
						btnLogin.setBounds(393, 202, 128, 29);
						loginPanel.add(btnLogin);
						txtfPassw.setBounds(350, 66, 200, 20);
						loginPanel.add(txtfPassw);
						txtfPassw.setPreferredSize(new Dimension(200,20));
						txtfPassw.setName("Contraseña");
						txtfPassw.setToolTipText("Introduzca su contraseña.");
								txtfUser.setBounds(350, 142, 200, 20);
								loginPanel.add(txtfUser);
						
								txtfUser.setPreferredSize(new Dimension(200,20));
								
										txtfUser.setName("Usuario");
										
												txtfUser.setToolTipText("Introduzca su nombre de usuario.");
												
														JLabel lblUser = new JLabel("Usuario");
														lblUser.setForeground(new Color(16, 44, 60));
														lblUser.setBounds(421, 36, 60, 18);
														loginPanel.add(lblUser);
														lblUser.setFont(cargarFuente(rtArchivoCandal,14));
														
														JLabel lblPassword = new JLabel("Contraseña");
														lblPassword.setForeground(new Color(16, 44, 60));
														lblPassword.setFont(cargarFuente(rtArchivoCandal,14));
														lblPassword.setBounds(408, 100, 94, 29);
														loginPanel.add(lblPassword);
				
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
				crearCuenta.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						CreateAccountFrame createAccountFrame = new CreateAccountFrame();
						dispose();
					}
				});
			
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public static Font cargarFuente(String archivo, float size) {
    	try{ Font fuenteNueva = Font.createFont(Font.TRUETYPE_FONT, new File(archivo));
    	return fuenteNueva.deriveFont(size);}
    	catch(FontFormatException e) {
    		System.err.println("Error cargando fuente: "+e.getMessage());
    		return new Font("Arial", Font.BOLD, (int) size);

    	}
    	catch(IOException e) {
    		System.err.println("Error cargando desde archivo: "+e.getMessage());
    		return new Font("Arial", Font.BOLD, (int) size);
    		
    		
    	}
    	
    }
}