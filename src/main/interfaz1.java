package main;
 
import java.awt.*;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;
 
// ===== Label personalizado con transparencia =====

class FadingLabel extends JLabel {

    private float alpha = 0f;

    public FadingLabel(String text) {

        super(text);

        setOpaque(false);

    }

    public void setAlpha(float a) {

        alpha = Math.max(0f, Math.min(1f, a));

        repaint();

    }

    public float getAlpha() { return alpha; }
 
    @Override

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        super.paintComponent(g2);

        g2.dispose();

    }

}
 
// ===== Ventana principal =====

public class interfaz1 extends JFrame {
 
    private JPanel content;

    private JPanel barraLateral;

    private boolean barraVisible;
 
    public interfaz1() {

        // Configuración básica

        setTitle("Interfaz 1");

        setUndecorated(false);

        setResizable(true);

        setPreferredSize(new Dimension(1000, 600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // --- Contenedor principal ---

        content = new JPanel(new BorderLayout(10, 10));

        content.setBackground(new Color(58, 58, 58));

        content.setBorder(new EmptyBorder(10, 10, 10, 10));

        setContentPane(content);
 
        // --- Panel superior (botón del menú) ---

        JPanel top = new JPanel(new BorderLayout());

        top.setBackground(new Color(45, 45, 45));
 
        // Botón menú ☰

        JButton botonMenu = new JButton("☰");

        botonMenu.setFont(new Font("Segoe UI", Font.BOLD, 24));

        botonMenu.setFocusPainted(false);

        botonMenu.setBackground(new Color(70, 70, 70));

        botonMenu.setForeground(Color.WHITE);

        botonMenu.setBorderPainted(false);

        botonMenu.addActionListener(e -> toggleBarra());

        top.add(botonMenu, BorderLayout.WEST);
 
        content.add(top, BorderLayout.NORTH);
 
        // --- Barra lateral (oculta inicialmente) ---

        barraLateral = new JPanel();

        barraLateral.setBackground(new Color(30, 30, 30));

        barraLateral.setPreferredSize(new Dimension(0, getHeight())); // Ancho inicial 0

        barraLateral.setLayout(new BoxLayout(barraLateral, BoxLayout.Y_AXIS));
 
        // Botones dentro de la barra

        String[] opciones = {"Perfil", "Configuración", "Historial", "Cerrar sesión"};

        for (String texto : opciones) {

            JButton b = new JButton(texto);

            b.setAlignmentX(Component.CENTER_ALIGNMENT);

            b.setMaximumSize(new Dimension(150, 40));

            b.setBackground(new Color(70, 70, 70));

            b.setForeground(Color.WHITE);

            b.setFocusPainted(false);

            b.setBorderPainted(false);

            b.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            barraLateral.add(Box.createVerticalStrut(15)); // espacio entre botones

            barraLateral.add(b);

        }
 
        content.add(barraLateral, BorderLayout.WEST);

     // --- Título centrado pero más arriba ---

        FadingLabel titulo = new FadingLabel("Bienvenido a DR.BOT");

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));

        titulo.setForeground(Color.WHITE);

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
 
        JTextArea areaTexto = new JTextArea(5,30);

        areaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        areaTexto.setBackground(new Color(255,255,255));;

        // Contenedor intermedio transparente

        JPanel centro = new JPanel(new BorderLayout());

        centro.setOpaque(false);
 
        // Pon el título ARRIBA del área central

        centro.add(titulo, BorderLayout.NORTH);
 
        // (Opcional) margen superior para ajustarlo más arriba o abajo

        centro.setBorder(new EmptyBorder(40, 0, 0, 0)); // sube/baja ajustando el 40
 
        content.add(centro, BorderLayout.CENTER);
 
 
        // --- Animación de aparición del título ---

        Timer fade = new Timer(30, null);

        fade.addActionListener(e -> {

            float a = titulo.getAlpha() + 0.02f;

            titulo.setAlpha(a);

            if (a >= 1f) ((Timer) e.getSource()).stop();

        });

        fade.start();
 
        pack();

        setLocationRelativeTo(null);

    }
 
    // --- Método para mostrar/ocultar la barra lateral ---

    private void toggleBarra() {

        int anchoFinal = barraVisible ? 0 : 200;  // ancho deseado de la barra

        int step = barraVisible ? -10 : 10;       // velocidad del movimiento
 
        Timer anim = new Timer(10, null);

        anim.addActionListener(e -> {

            int nuevoAncho = barraLateral.getWidth() + step;

            if ((step > 0 && nuevoAncho >= anchoFinal) ||

                (step < 0 && nuevoAncho <= anchoFinal)) {

                nuevoAncho = anchoFinal;

                ((Timer) e.getSource()).stop();

                barraVisible = !barraVisible;

            }

            barraLateral.setPreferredSize(new Dimension(nuevoAncho, getHeight()));

            barraLateral.revalidate(); // actualiza el layout

        });

        anim.start();

    }
 
    // --- MAIN ---

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> new interfaz1().setVisible(true));

    }

}
 