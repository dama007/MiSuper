
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaProductos1 implements Serializable {
    
    private ObservableList<Producto1> lista;

    public ListaProductos1() {
        lista = ObservableCollections.observableList(new ArrayList<Producto1>());
    }
    
    public ListaProductos1 productosEnStock() {
        ListaProductos1 productosConStock = new ListaProductos1();
        for (Producto1 p : lista) {
            if (p.getStock() > 0) {
                productosConStock.altaProducto(p);
            }
        }
        return productosConStock;
    }
        
    
    public boolean existeProducto(Producto1 p) {
        return lista.contains(p);
    }
    
    
    public void altaProducto(Producto1 p) {
        lista.add(p);
    }
    
    
    public void bajaProducto(Producto1 p) {
        lista.remove(p);
    }
   
    

    public static final String PROP_LISTA = "lista";

    public ObservableList<Producto1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Producto1> lista) {
        ObservableList<Producto1> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
