package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Consulta;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class ConsultaDAO extends DAOGenerico<Consulta> implements Serializable {
    
    public ConsultaDAO() {
        super();
        classePersistente = Consulta.class;
    }
}
