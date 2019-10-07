package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Medicamento;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class MedicamentoDAO extends DAOGenerico<Medicamento> implements Serializable {
    
    public MedicamentoDAO() {
        super();
        classePersistente = Medicamento.class;
    }
}
