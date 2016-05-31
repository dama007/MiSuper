
package supermercado;

import modelo.ListaClientes1;
import modelo.ListaFacturas1;
import modelo.ListaProductos1;
import utilidades.*;
import vista.MenuPrincipal1;

/**
 *
 * @author usu21
 */
public class Supermercado {
    
    public static Fichero ficheroClientes;
    public static Fichero ficheroProductos;
    public static Fichero ficheroFacturas;
    
    public static ListaClientes1 clientes;
    public static ListaProductos1 productos;
    public static ListaFacturas1 facturas;

    
    public static void main(String[] args) {
        
        ficheroClientes = new Fichero("clientes.xml");
        ficheroProductos = new Fichero("productos.xml");
        ficheroFacturas = new Fichero("facturas.xml");
        
        clientes = (ListaClientes1) ficheroClientes.leer();
        if (clientes == null) {
            clientes = new ListaClientes1();
        }
        productos = (ListaProductos1) ficheroProductos.leer();
        if(productos == null) {
            productos = new ListaProductos1();
        }
        facturas = (ListaFacturas1) ficheroFacturas.leer();
        if (facturas == null) {
            facturas = new ListaFacturas1();
        }
        MenuPrincipal1 menu = new MenuPrincipal1();
        menu.setVisible(true);
        
    }
    
}
