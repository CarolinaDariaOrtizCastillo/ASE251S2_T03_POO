package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.FormularioController;

import javax.swing.*;
import java.awt.*;

public class SelectionView extends JFrame {

    public SelectionView() {
        setTitle("Seleccionar tipo de inscripción");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --------- PANEL PRINCIPAL ---------
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#FFF2F2"));

        // --------- ICONO DE LA VENTANA ---------
        setIconImage(new ImageIcon("C:\\Users\\Carolina O\\Desktop\\formularioDatos\\src\\libro.png").getImage());

        // --------- IMAGEN SUPERIOR ---------
        ImageIcon rawIcon = new ImageIcon("C:\\Users\\Carolina O\\Desktop\\formularioDatos\\src\\escuela.png");
        Image imgEscuela = rawIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(imgEscuela));
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(imgLabel);

        // --------- TEXTO ---------
        JLabel lbl = new JLabel("¿Desea inscribirse como Estudiante o Institución?", JLabel.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setForeground(Color.decode("#2D336B"));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lbl);

        // --------- BOTÓN ESTUDIANTE ---------
        JButton btnEstudiante = new JButton("Estudiante");
        btnEstudiante.setBackground(Color.decode("#A9B5DF"));
        btnEstudiante.setForeground(Color.WHITE);
        btnEstudiante.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnEstudiante.setPreferredSize(new Dimension(150, 40));
        btnEstudiante.setMaximumSize(new Dimension(150, 40));
        btnEstudiante.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --------- BOTÓN INSTITUCIÓN ---------
        JButton btnInstitucion = new JButton("Institución");
        btnInstitucion.setBackground(Color.decode("#7886C7"));
        btnInstitucion.setForeground(Color.WHITE);
        btnInstitucion.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnInstitucion.setPreferredSize(new Dimension(150, 40));
        btnInstitucion.setMaximumSize(new Dimension(150, 40));
        btnInstitucion.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(15));
        panel.add(btnEstudiante);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnInstitucion);

        add(panel);

        // --------- LISTENERS ---------
        btnEstudiante.addActionListener(e -> {
            dispose();
            FormularioView form = new FormularioView("Estudiante");
            new FormularioController(form, "Estudiante");
            form.setVisible(true);
        });

        btnInstitucion.addActionListener(e -> {
            dispose();
            FormularioView form = new FormularioView("Institución");
            new FormularioController(form, "Institución");
            form.setVisible(true);
        });
    }
}
