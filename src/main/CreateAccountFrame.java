package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class CreateAccountFrame extends JFrame implements WindowListener, ActionListener {
    JPanel mainPanel = new JPanel();
    JLabel drBotLabel = new JLabel("DRBOT | Crear cuenta");
    JButton btnCreateAccount = new JButton("Crear cuenta");
    JTextField txtfUser = new JTextField();
    JTextField txtfPassw = new JTextField();
    JTextField txtfPasswChk = new JTextField();
    ImageIcon iconImageOriginalRes = new ImageIcon("src/main/java/Resources/LogosProIng.png");
    int imageIconWidth = 580;
    int imageIconHeight = 480;
    Image imageIcon = iconImageOriginalRes.getImage().getScaledInstance(imageIconWidth, imageIconHeight, Image.SCALE_SMOOTH);
    ImageIcon iconImageResized = new ImageIcon(imageIcon);

    
    String txtUser = "";
    String txtPassw = "";
    String txtPasswChk = "";
    private JTextField usuarioTxtf;
    private JTextField passwordTxtf;
    private JTextField repitaPasswordTxtf;

    public final void initialize() {
        this.setTitle("DrBot | Crear cuenta");
        this.setSize(1920, 1080);
        this.setMinimumSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setBackground(new Color(180, 180, 180));
        getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(134, 134, 134), new Color(134, 134, 134), new Color(134, 134, 134), new Color(134, 134, 134)));
        panel.setBackground(new Color(173, 173, 173));
        panel.setBounds(0, 0, 1920,90);
        mainPanel.add(panel);
        panel.setLayout(null);
        
        JLabel drBotLbl = new JLabel("DRBOT | Crear cuenta");
        drBotLbl.setBounds(27, 35, 349, 32);
        panel.add(drBotLbl);
        drBotLbl.setLabelFor(drBotLbl);
        drBotLbl.setBackground(new Color(219, 195, 177));
        drBotLbl.setFont(new Font("Monaco", Font.BOLD | Font.ITALIC, 24));
        
        JLabel iconLbl = new JLabel(iconImageResized);
        iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        iconLbl.setBounds(200, 180, imageIconWidth, imageIconHeight);
        mainPanel.add(iconLbl);
        
        
        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(134, 134, 134), new Color(134, 134, 134), new Color(134, 134, 134), new Color(134, 134, 134)));
        loginPanel.setBackground(new Color(173, 173, 173));
        loginPanel.setBounds(956, 205, 371, 394);
        mainPanel.add(loginPanel);
        loginPanel.setLayout(null);
        
        JButton crearCuentaBtn = new JButton("CREAR CUENTA");
        crearCuentaBtn.setBounds(93, 289, 181, 53);
        loginPanel.add(crearCuentaBtn);
        crearCuentaBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        crearCuentaBtn.setFont(new Font("Monaco", Font.PLAIN, 20));
        crearCuentaBtn.setBackground(new Color(253, 252, 255));
        
        JLabel usuarioLbl = new JLabel("Nombre de usuario");
        usuarioLbl.setBounds(84, 80, 214, 16);
        loginPanel.add(usuarioLbl);
        usuarioLbl.setFont(new Font("Monaco", Font.BOLD, 18));
        
        usuarioTxtf = new JTextField();
        usuarioTxtf.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioTxtf.setBounds(48, 108, 281, 26);
        loginPanel.add(usuarioTxtf);
        usuarioTxtf.setFont(new Font("Monaco", Font.PLAIN, 13));
        usuarioTxtf.setForeground(new Color(40, 40, 40));
        usuarioTxtf.setBackground(new Color(224, 224, 224));
        usuarioTxtf.setColumns(10);
        
        JLabel passwordLbl = new JLabel("Contraseña");
        passwordLbl.setBounds(129, 146, 189, 16);
        loginPanel.add(passwordLbl);
        passwordLbl.setFont(new Font("Monaco", Font.BOLD, 18));
        
        passwordTxtf = new JTextField();
        passwordTxtf.setHorizontalAlignment(SwingConstants.CENTER);
        passwordTxtf.setBounds(48, 174, 281, 26);
        loginPanel.add(passwordTxtf);
        passwordTxtf.setFont(new Font("Monaco", Font.PLAIN, 13));
        passwordTxtf.setForeground(new Color(40, 40, 40));
        passwordTxtf.setBackground(new Color(224, 224, 224));
        passwordTxtf.setColumns(10);
        
        JLabel repitePasswordLbl = new JLabel("Repita la contraseña");
        repitePasswordLbl.setBounds(78, 215, 290, 26);
        loginPanel.add(repitePasswordLbl);
        repitePasswordLbl.setFont(new Font("Monaco", Font.BOLD, 18));
        
        repitaPasswordTxtf = new JTextField();
        repitaPasswordTxtf.setHorizontalAlignment(SwingConstants.CENTER);
        repitaPasswordTxtf.setBounds(48, 242, 281, 26);
        loginPanel.add(repitaPasswordTxtf);
        repitaPasswordTxtf.setFont(new Font("Monaco", Font.PLAIN, 13));
        repitaPasswordTxtf.setForeground(new Color(40, 40, 40));
        repitaPasswordTxtf.setBackground(new Color(224, 224, 224));
        repitaPasswordTxtf.setColumns(10);

        txtfUser.setPreferredSize(new Dimension(200, 20));
        txtfPassw.setPreferredSize(new Dimension(200, 20));
        txtfPasswChk.setPreferredSize(new Dimension(200, 20));

        txtfUser.setName("Nombre de usuario");
        txtfPassw.setName("Nueva contraseña");
        txtfPasswChk.setName("Repita la contraseña");

        txtfUser.setToolTipText("Introduzca nuevo nombre de usuario");
        txtfPassw.setToolTipText("Introduzca nueva contraseña.");
        txtfPasswChk.setToolTipText("Repita la contraseña.");

        drBotLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
        drBotLabel.setBackground(Color.WHITE);
        drBotLabel.setForeground(new Color(0, 0, 0));

        btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUser = txtfUser.getText();
                txtPassw = txtfPassw.getText();
                txtPasswChk = txtfPasswChk.getText();
                if (!"".equals(txtUser) && !"".equals(txtPassw) && !"".equals(txtPasswChk)) {
                    if (txtPassw.equals(txtPasswChk)) {
                        JFrame dialogFrame = new JFrame();
                        JDialog dialogSure = new JDialog(dialogFrame, "Confirmar Creación", true);
                        dialogSure.getContentPane().setLayout(new FlowLayout());
                        dialogSure.setSize(500, 100);
                        dialogSure.setLocationRelativeTo(null);

                        JLabel lblDialogSure = new JLabel("¿Desea guardar las siguientes credenciales como una nueva cuenta?");
                        JLabel lblDialogSureUser = new JLabel("Usuario: " + txtUser);
                        lblDialogSureUser.setFont(new Font("Verdana", Font.BOLD, 14));
                        JLabel lblDialogSurePassw = new JLabel("Contraseña: " + txtPassw);
                        lblDialogSurePassw.setFont(new Font("Verdana", Font.BOLD, 14));
                        JButton btnOk = new JButton("Sí");
                        btnOk.setFont(new Font("Verdana", Font.BOLD, 14));
                        JButton btnCancel = new JButton("No");
                        btnCancel.setFont(new Font("Verdana", Font.BOLD, 14));

                        dialogSure.getContentPane().add(lblDialogSure);
                        dialogSure.getContentPane().add(lblDialogSureUser);
                        dialogSure.getContentPane().add(lblDialogSurePassw);
                        dialogSure.getContentPane().add(btnOk);
                        dialogSure.getContentPane().add(btnCancel);

                        btnOk.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialogSure.dispose();

                                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                                dispose();
                                Usuario newUser = new Usuario(txtfUser.getText(), txtfPassw.getText(), "usuario");
                                LoginFrame newDrBotFrame = new LoginFrame();

                            }
                        });
                        btnCancel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialogSure.dispose();
                                txtfUser.setText("");
                                txtfPassw.setText("");
                                txtfPasswChk.setText("");
                            }
                        });
                        dialogSure.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CreateAccountFrame();
    }

    public CreateAccountFrame() {
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
}