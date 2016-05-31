
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
public class ListaClientes1 implements Serializable {
    
    private ObservableList<Cliente1> lista;

    public ListaClientes1() {
        lista = ObservableCollections.observableList(new ArrayList<Cliente1>());
    }
    
    public ListaClientes1 copiaClientes() {
        ListaClientes1 copia = new ListaClientes1();
        for (Cliente1 c : lista) {
            copia.altaCliente(c);
        }
        return copia;
    }
    
    public boolean existeCliente(Cliente1 c) {
        return lista.contains(c);
    }
    
    public void altaCliente(Cliente1 c) {
        lista.add(c);
    }
    
    public void bajaCliente1(Cliente1 c) {
        lista.remove(c);
    }
    
    
    

    public static final String PROP_LISTA = "lista";

    public ObservableList<Cliente1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Cliente1> lista) {
        ObservableList<Cliente1> oldLista = this.lista;
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
