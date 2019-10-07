package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class MedicoDAO extends DAOGenerico<Medico> implements Serializable {
    
    public MedicoDAO() {
        super();
        classePersistente = Medico.class;
    }
}
