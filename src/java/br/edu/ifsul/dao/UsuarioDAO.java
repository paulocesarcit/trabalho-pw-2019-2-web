package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class UsuarioDAO extends DAOGenerico<Usuario> implements Serializable {
    
    public UsuarioDAO() {
        super();
        classePersistente = Usuario.class;
    }
    
    @Override
    public Usuario getObjectById(Object id){
        Usuario obj = em.find(Usuario.class, id);
        // Deve-se inicializar as coleções para não dar o erro 
        // lazyinicializationException
        obj.getPermissoes().size();
        return obj;
    }    
}
