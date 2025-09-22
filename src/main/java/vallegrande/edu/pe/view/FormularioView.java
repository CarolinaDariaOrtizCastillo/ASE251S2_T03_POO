package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class FormularioView extends JFrame {

    private final String tipo;

    // -------- Campos comunes --------
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JButton btnEnviar;
    private JButton btnAtras;

    // -------- Campos Estudiante --------
    private JTextField txtFechaNacimiento;
    private JTextField txtUbigeoEstudiante;
    private JTextField txtCelularEstudiante;
    private JTextField txtGrado;
    private JTextField txtInstitucionEstudiante;
    private JComboBox<String> cbTipoDocumento;
    private JTextField txtNumeroDocumento;

    // -------- Campos Institución --------
    private JComboBox<String> cbTipoGestion;
    private JTextField txtDireccion;
    private JTextField txtUbigeoInstitucion;
    private JComboBox<String> cbRegistrante;
    private JTextField txtNombreRegistrante;
    private JTextField txtCelularInstitucion;

    public FormularioView(String tipo) {
        this.tipo = tipo == null ? "" : tipo;
        setTitle("Formulario de " + tipo);
        setSize(480, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#FFF2F2"));
        add(panel);

        // Encabezado
        JLabel lblTitulo = new JLabel("Registro - " + tipo, JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.decode("#2D336B"));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(18, 0, 18, 0));
        panel.add(lblTitulo, BorderLayout.NORTH);

        // Form panel (columnas pareja label+input)
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 12));
        formPanel.setBorder(BorderFactory.createEmptyBorder(12, 28, 12, 28));
        formPanel.setBackground(Color.decode("#FFF2F2"));
        panel.add(formPanel, BorderLayout.CENTER);

        // Campos comunes (siempre)
        txtNombre = addTextField(formPanel, "Nombre completo:");
        txtCorreo = addTextField(formPanel, "Correo:");

        // Agregar SOLO campos de Estudiante
        if (tipo.equalsIgnoreCase("Estudiante")) {
            txtFechaNacimiento = addTextField(formPanel, "Fecha de nacimiento:");
            txtUbigeoEstudiante = addTextField(formPanel, "Código de ubigeo:");
            txtCelularEstudiante = addTextField(formPanel, "Celular:");
            txtGrado = addTextField(formPanel, "Grado:");
            txtInstitucionEstudiante = addTextField(formPanel, "Institución educativa:");

            cbTipoDocumento = new JComboBox<>(new String[]{"Seleccione", "DNI", "CNE"});
            formPanel.add(label("Tipo de documento:"));
            formPanel.add(cbTipoDocumento);

            txtNumeroDocumento = addTextField(formPanel, "Número de documento:");
        }

        // Agregar SOLO campos de Institución
        if (tipo.equalsIgnoreCase("Institución") || tipo.equalsIgnoreCase("Institucion")) {
            cbTipoGestion = new JComboBox<>(new String[]{"Seleccione", "Estatal", "Privada"});
            formPanel.add(label("Tipo de gestión:"));
            formPanel.add(cbTipoGestion);

            txtDireccion = addTextField(formPanel, "Dirección:");
            txtUbigeoInstitucion = addTextField(formPanel, "Código de ubigeo:");

            cbRegistrante = new JComboBox<>(new String[]{"Seleccione", "Director", "Administrador", "Profesor"});
            formPanel.add(label("Registrante (cargo):"));
            formPanel.add(cbRegistrante);

            txtNombreRegistrante = addTextField(formPanel, "Nombre del registrante:");
            txtCelularInstitucion = addTextField(formPanel, "Celular de comunicación:");
        }

        // Panel botones (siempre)
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 18, 12));
        botones.setBackground(Color.decode("#FFF2F2"));

        btnAtras = new JButton("⬅ Atrás");
        styleSecondaryButton(btnAtras);

        btnEnviar = new JButton("Enviar ✅");
        stylePrimaryButton(btnEnviar);

        botones.add(btnAtras);
        botones.add(btnEnviar);

        panel.add(botones, BorderLayout.SOUTH);
    }

    // Helper: crea label estilizado
    private JLabel label(String texto) {
        JLabel l = new JLabel(texto);
        l.setForeground(Color.decode("#2D336B"));
        l.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return l;
    }

    // Helper: crea textfield con label (añade ambos al panel)
    private JTextField addTextField(JPanel panel, String label) {
        panel.add(label(label));
        JTextField txt = new JTextField();
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txt.setBackground(Color.decode("#FFFFFF"));
        txt.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#7886C7"), 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        panel.add(txt);
        return txt;
    }

    // Helper: estilo botones primario/secundario
    private void stylePrimaryButton(JButton b) {
        b.setBackground(Color.decode("#2D336B"));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // hover
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { b.setBackground(Color.decode("#7886C7")); }
            public void mouseExited(java.awt.event.MouseEvent e) { b.setBackground(Color.decode("#2D336B")); }
        });
    }

    private void styleSecondaryButton(JButton b) {
        b.setBackground(Color.decode("#A9B5DF"));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // ========== Getters (misma estructura que usa tu Controller) ==========
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtCorreo() { return txtCorreo; }

    // Estudiante
    public JTextField getTxtFechaNacimiento() { return txtFechaNacimiento; }
    public JTextField getTxtUbigeoEstudiante() { return txtUbigeoEstudiante; }
    public JTextField getTxtCelularEstudiante() { return txtCelularEstudiante; }
    public JTextField getTxtGrado() { return txtGrado; }
    public JTextField getTxtInstitucionEstudiante() { return txtInstitucionEstudiante; }
    public JComboBox<String> getCbTipoDocumento() { return cbTipoDocumento; }
    public JTextField getTxtNumeroDocumento() { return txtNumeroDocumento; }

    // Institución
    public JComboBox<String> getCbTipoGestion() { return cbTipoGestion; }
    public JTextField getTxtDireccion() { return txtDireccion; }
    public JTextField getTxtUbigeoInstitucion() { return txtUbigeoInstitucion; }
    public JComboBox<String> getCbRegistrante() { return cbRegistrante; }
    public JTextField getTxtNombreRegistrante() { return txtNombreRegistrante; }
    public JTextField getTxtCelularInstitucion() { return txtCelularInstitucion; }

    public JButton getBtnEnviar() { return btnEnviar; }
    public JButton getBtnAtras() { return btnAtras; }
}
