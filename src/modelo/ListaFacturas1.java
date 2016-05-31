
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
public class ListaFacturas1 implements Serializable {
    
    private ObservableList<Factura1> lista;

    public ListaFacturas1() {
        lista = ObservableCollections.observableList(new ArrayList<Factura1>());
    }
    
    public boolean existeFactura(Factura1 fra) {
        return lista.contains(fra);
    }
    
    
    public void altaFactura(Factura1 fra) {
        lista.add(fra);
    }
    
    

    public static final String PROP_LISTA = "lista";

    public ObservableList<Factura1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Factura1> lista) {
        ObservableList<Factura1> oldLista = this.lista;
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
