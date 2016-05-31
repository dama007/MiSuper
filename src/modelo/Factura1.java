
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author usu21
 */
public class Factura1 implements Serializable {
    
    private int numero;    
    private Date fecha;    
    private Cliente1 cliente;    
    private Producto1 producto;    
    private int cantidad;

    public Factura1() {
        
        fecha = new Date();
        cliente = new Cliente1();
        producto = new Producto1();
//        es lo mismo
//        this(0, new Date(), new Cliente(), new Producto(), 0);
    }

    public double total() {
        return cantidad * producto.getPvp();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factura1 other = (Factura1) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    public Factura1(int numero, Date fecha, Cliente1 cliente, Producto1 producto, int cantidad) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    

    public static final String PROP_CANTIDAD = "cantidad";

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        int oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        propertyChangeSupport.firePropertyChange(PROP_CANTIDAD, oldCantidad, cantidad);
    }


    public static final String PROP_PRODUCTO = "producto";

    public Producto1 getProducto() {
        return producto;
    }

    public void setProducto(Producto1 producto) {
        Producto1 oldProducto = this.producto;
        this.producto = producto;
        propertyChangeSupport.firePropertyChange(PROP_PRODUCTO, oldProducto, producto);
    }


    public static final String PROP_CLIENTE = "cliente";

    public Cliente1 getCliente() {
        return cliente;
    }

    public void setCliente(Cliente1 cliente) {
        Cliente1 oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }


    public static final String PROP_FECHA = "fecha";

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        propertyChangeSupport.firePropertyChange(PROP_FECHA, oldFecha, fecha);
    }

    public static final String PROP_NUMERO = "numero";

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        int oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
