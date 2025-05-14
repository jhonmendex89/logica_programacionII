/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturacion;

/**
 *
 * @author jmendez
 */
public class Facturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cliente c = new Cliente();
        c.setCedula(123);
        c.setNombre("Camilo");

        Empleado e = new Empleado();
        e.setCedula(111);
        e.setNombre("Jacobo");

        Producto p = new Producto();
        p.setCodigo(1);
        p.setNombre("Computador");
        p.setPrecio(1200000);

        Producto p2 = new Producto();
        p2.setCodigo(2);
        p2.setNombre("Pantalla");
        p2.setPrecio(800000);

        
         
        
        Tienda t = new Tienda();
        t.setNombre("D1");
        t.setDireccion("Calle falsa 123");
     
        DetalleFactura[] items = {new DetalleFactura(p, 2), new DetalleFactura(p2, 0)};

        Factura f = new Factura(1111, "2028-05-05", c, t, e, items);
        f.imprimirFactura();

    }

}
