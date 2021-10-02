package empre.hoy.myapplication.entity;

public class VentasReporte {
    String idVenta;
    String fecha;
    String hora;
    String idProducto;
    String nombreProducto;
    String idCategoria;
    int cantidad;

    public VentasReporte() {
    }

    public VentasReporte(String idVenta, String fecha, String hora, String idProducto, String nombreProducto, String idCategoria, int cantidad) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.hora = hora;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idCategoria = idCategoria;
        this.cantidad = cantidad;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
