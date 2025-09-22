package vallegrande.edu.pe.model;

public class InstitucionModel {
    private final String nombre;
    private final String correo;
    private String tipoGestion;
    private String direccion;
    private String ubigeo;
    private String rolRegistrante;
    private String nombreRegistrante;
    private String celular;

    public InstitucionModel(String nombre, String correo, String tipoGestion,
                            String direccion, String ubigeo, String rolRegistrante,
                            String nombreRegistrante, String celular) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipoGestion = tipoGestion;
        this.direccion = direccion;
        this.ubigeo = ubigeo;
        this.rolRegistrante = rolRegistrante;
        this.nombreRegistrante = nombreRegistrante;
        this.celular = celular;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTipoGestion() { return tipoGestion; }
    public String getDireccion() { return direccion; }
    public String getUbigeo() { return ubigeo; }
    public String getRolRegistrante() { return rolRegistrante; }
    public String getNombreRegistrante() { return nombreRegistrante; }
    public String getCelular() { return celular; }
}
