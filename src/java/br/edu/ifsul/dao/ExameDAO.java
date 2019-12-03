package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Exame;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class ExameDAO extends DAOGenerico<Exame> implements Serializable {
    
    public ExameDAO() {
        super();
        classePersistente = Exame.class;
    }
}
