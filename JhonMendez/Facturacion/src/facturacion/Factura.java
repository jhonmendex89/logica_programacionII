/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacion;

/**
 *
 * @author jmendez
 */
public class Factura {
    private int codigo;
    private String fecha;
    private Cliente cliente;
    private Empleado empleado;
    private Tienda tienda;
    private DetalleFactura[] detalleFactura;
    
    
    Factura(int codigo, String fecha, Cliente cliente, Tienda tienda, Empleado empleado, DetalleFactura[] items){
     this.cliente = cliente;
     this.codigo=codigo;
     this.tienda = tienda;
     this.empleado = empleado;
     this.detalleFactura = items;
    }
    
    public void imprimirFactura(){
        System.out.println("-----SISTEMA DE GESTION DE FACTURAS-----");
        System.out.println("FACTURA N: "+this.codigo);
        System.out.println(this.tienda.mostrarDatos());
        System.out.println("------");
        System.out.println(this.cliente);
        System.out.println("Empleado: "+this.empleado.getNombre());
        System.out.println("----------");
        for (DetalleFactura item : detalleFactura) {
            item.imprimirItem();
        }
        
    }
}
