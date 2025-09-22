package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.EstudianteModel;
import vallegrande.edu.pe.model.InstitucionModel;
import vallegrande.edu.pe.view.FormularioView;
import vallegrande.edu.pe.view.SelectionView;

import javax.swing.*;
import java.util.Objects;

public class FormularioController {

    private final FormularioView view;
    private final String tipo;

    public FormularioController(FormularioView view, String tipo) {
        this.view = view;
        this.tipo = tipo;
        initController();
    }

    private void initController() {
        view.getBtnEnviar().addActionListener(e -> procesarFormulario());
        view.getBtnAtras().addActionListener(e -> volverMenu());
    }

    private void procesarFormulario() {
        String nombre = view.getTxtNombre().getText();
        String correo = view.getTxtCorreo().getText();

        if (tipo.equals("Estudiante")) {
            String fecha = view.getTxtFechaNacimiento().getText();
            String ubigeo = view.getTxtUbigeoEstudiante().getText();
            String celular = view.getTxtCelularEstudiante().getText();
            String grado = view.getTxtGrado().getText();
            String institucion = view.getTxtInstitucionEstudiante().getText();
            String tipoDoc = (String) view.getCbTipoDocumento().getSelectedItem();
            String numDoc = view.getTxtNumeroDocumento().getText();

            if (nombre.isEmpty() || correo.isEmpty() || fecha.isEmpty() || ubigeo.isEmpty() ||
                    celular.isEmpty() || grado.isEmpty() || institucion.isEmpty() ||
                    Objects.equals(tipoDoc, "Seleccione") || numDoc.isEmpty()) {
                JOptionPane.showMessageDialog(view,
                        "Complete todos los campos del estudiante.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            EstudianteModel est = new EstudianteModel(nombre, correo, fecha, ubigeo, celular, grado, institucion, tipoDoc, numDoc);

            JOptionPane.showMessageDialog(view,
                    "✅ REGISTRADO CON ÉXITO",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }

        if (tipo.equals("Institución")) {
            String tipoGestion = (String) view.getCbTipoGestion().getSelectedItem();
            String direccion = view.getTxtDireccion().getText();
            String ubigeoInst = view.getTxtUbigeoInstitucion().getText();
            String rol = (String) view.getCbRegistrante().getSelectedItem();
            String nombreReg = view.getTxtNombreRegistrante().getText();
            String celular = view.getTxtCelularInstitucion().getText();

            if (nombre.isEmpty() || correo.isEmpty() || tipoGestion.equals("Seleccione") ||
                    direccion.isEmpty() || ubigeoInst.isEmpty() ||
                    rol.equals("Seleccione") || nombreReg.isEmpty() || celular.isEmpty()) {
                JOptionPane.showMessageDialog(view,
                        "Complete todos los campos de la institución.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            InstitucionModel inst = new InstitucionModel(nombre, correo, tipoGestion, direccion,
                    ubigeoInst, rol, nombreReg, celular);

            JOptionPane.showMessageDialog(view,
                    "✅ REGISTRADO CON ÉXITO",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void volverMenu() {
        view.dispose();
        SelectionView seleccion = new SelectionView();
        seleccion.setVisible(true);
    }
}
