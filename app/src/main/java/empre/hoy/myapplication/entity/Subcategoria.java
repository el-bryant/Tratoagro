package empre.hoy.myapplication.entity;

public class Subcategoria {
    String idSubcategoria;
    String nombre;
    String idCategoria;

    public Subcategoria() {
    }

    public Subcategoria(String idSubcategoria, String nombre, String idCategoria) {
        this.idSubcategoria = idSubcategoria;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
    }

    public String getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(String idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
}
