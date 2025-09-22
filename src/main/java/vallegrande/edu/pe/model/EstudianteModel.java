package vallegrande.edu.pe.model;

public class EstudianteModel {
    private final String nombre;
    private final String correo;
    private final String fechaNacimiento;
    private final String ubigeo;
    private final String celular;
    private final String grado;
    private final String institucion;
    private final String tipoDocumento;
    private final String numeroDocumento;

    public EstudianteModel(String nombre, String correo, String fechaNacimiento, String ubigeo,
                           String celular, String grado, String institucion,
                           String tipoDocumento, String numeroDocumento) {
        this.nombre = nombre;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.ubigeo = ubigeo;
        this.celular = celular;
        this.grado = grado;
        this.institucion = institucion;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getUbigeo() { return ubigeo; }
    public String getCelular() { return celular; }
    public String getGrado() { return grado; }
    public String getInstitucion() { return institucion; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
}
