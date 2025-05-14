/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacion;

/**
 *
 * @author jmendez
 */
public class DetalleFactura {

    private Producto producto;
    private int cantidad;

    public DetalleFactura(Producto p, int cantidad) {
        this.producto = p;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double subTotal() {
        return this.cantidad * producto.getPrecio();
    }

    public void imprimirItem() {
        System.out.println(this.producto.getNombre() + " " + this.cantidad + this.subTotal());
    }

}
