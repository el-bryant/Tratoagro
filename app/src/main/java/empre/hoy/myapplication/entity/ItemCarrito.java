package empre.hoy.myapplication.entity;

public class ItemCarrito {
    String foto;
    String idProveedor;
    String nombreProveedor;
    String idProducto;
    String nombreProducto;
    String idStock;
    int cantidad;

    public ItemCarrito() {
    }

    public ItemCarrito(String foto, String idProveedor, String nombreProveedor, String idProducto, String nombreProducto, String idStock, int cantidad) {
        this.foto = foto;
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idStock = idStock;
        this.cantidad = cantidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
