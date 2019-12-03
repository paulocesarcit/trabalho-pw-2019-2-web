package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Receituario;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class ReceituarioDAO extends DAOGenerico<Receituario> implements Serializable {
    
    public ReceituarioDAO() {
        super();
        classePersistente = Receituario.class;
    }
}
