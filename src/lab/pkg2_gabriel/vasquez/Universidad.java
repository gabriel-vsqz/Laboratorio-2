package lab.pkg2_gabriel.vasquez;

/**
 *
 * @author Gabriel Vasquez
 */
public class Universidad {
    
    String nombre;
    String rector;
    String sucursal;
    int año;
    int maestros;
    int estudiantes;
    double costo;
    String nivel;
    
    public Universidad(){
        
    }
    
    public Universidad(String nombre, String rector, String sucursal, int año, int maestros, int estudiantes, double costo, String nivel){
        this.nombre = nombre;
        this.rector = rector;
        this.sucursal = sucursal;
        this.año = año;
        this.maestros = maestros;
        this.estudiantes = estudiantes;
        this.costo = costo;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMaestros() {
        return maestros;
    }

    public void setMaestros(int maestros) {
        this.maestros = maestros;
    }

    public int getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(int estudiantes) {
        this.estudiantes = estudiantes;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public String toString(){
        return "Nombre de la Universidad: " + nombre + " - Sucursal: " + sucursal + " - Costo Mensual: " + costo + " - Nivel: " + nivel;
    }
    
}