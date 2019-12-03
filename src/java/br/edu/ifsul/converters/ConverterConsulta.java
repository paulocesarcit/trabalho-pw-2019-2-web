package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Consulta;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
@Named(value = "converterConsulta")
public class ConverterConsulta implements Serializable, Converter {

    @PersistenceContext(unitName = "Trabalho-PW-2019-2-WebPU")
    private EntityManager em;
    
    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        return em.find(Consulta.class, Integer.parseInt(string));
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return null;
        }
        Consulta est = (Consulta) t;
        return est.getId().toString();
    }
}
