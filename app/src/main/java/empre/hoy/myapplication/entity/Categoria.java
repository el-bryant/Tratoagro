package empre.hoy.myapplication.entity;

public class Categoria {
    String idCategoria;
    String nombre;
    String icono;

    public Categoria() {
    }

    public Categoria(String idCategoria, String nombre, String icono) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.icono = icono;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
