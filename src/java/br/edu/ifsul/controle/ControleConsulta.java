package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ExameDAO;
import br.edu.ifsul.dao.ReceituarioDAO;
import br.edu.ifsul.dao.ConsultaDAO;
import br.edu.ifsul.dao.MedicamentoDAO;
import br.edu.ifsul.dao.MedicoDAO;
import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Receituario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named(value = "controleConsulta")
public class ControleConsulta implements Serializable {
    
    @EJB
    private ConsultaDAO dao;
    private Consulta objeto;
    
    @EJB
    private ExameDAO daoExame;
    private Exame exame;
    private Boolean novoExame;
    
    @EJB
    private ReceituarioDAO daoReceituario;
    private Receituario receituario;
    private Boolean novoReceituario;
    
    @EJB
    private MedicoDAO daoMedico;
    
    @EJB
    private PacienteDAO daoPaciente;
    
    @EJB
    private MedicamentoDAO daoMedicamento;

    public ControleConsulta() {
    
    }
    
    public String listar() {
        return "/privado/consulta/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Consulta();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void remover(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public ConsultaDAO getDao() {
        return dao;
    }

    public void setDao(ConsultaDAO dao) {
        this.dao = dao;
    }

    public Consulta getObjeto() {
        return objeto;
    }

    public void setObjeto(Consulta objeto) {
        this.objeto = objeto;
    }

    public ExameDAO getDaoExame() {
        return daoExame;
    }

    public void setDaoExame(ExameDAO daoExame) {
        this.daoExame = daoExame;
    }

    public ReceituarioDAO getDaoReceituario() {
        return daoReceituario;
    }

    public void setDaoReceituario(ReceituarioDAO daoReceituario) {
        this.daoReceituario = daoReceituario;
    }

    public MedicoDAO getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(MedicoDAO daoMedico) {
        this.daoMedico = daoMedico;
    }

    public PacienteDAO getDaoPaciente() {
        return daoPaciente;
    }

    public void setDaoPaciente(PacienteDAO daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public MedicamentoDAO getDaoMedicamento() {
        return daoMedicamento;
    }

    public void setDaoMedicamento(MedicamentoDAO daoMedicamento) {
        this.daoMedicamento = daoMedicamento;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Receituario getReceituario() {
        return receituario;
    }

    public void setReceituario(Receituario receituario) {
        this.receituario = receituario;
    }
    
    public void novoExame(){
        exame = new Exame();
        novoExame = true;
    }
    
    public void alterarExame(int index){
        exame = objeto.getExames().get(index);
        novoExame = false;
    }
    
    public void salvarExame(){
        if (novoExame){
            objeto.setExames(exame);
        }
        Util.mensagemInformacao("Exame adicionado com sucesso!");
    }
    
    public void removerExame(int index){
        objeto.removerExames(index);
        Util.mensagemInformacao("Exame removido com sucesso!");
    }
    
    public void novoReceituario(){
        receituario = new Receituario();
        novoReceituario = true;
    }
    
    public void alterarReceituario(int index){
        receituario = objeto.getReceituarios().get(index);
        novoReceituario = false;
    }
    
    public void salvarReceituario(){
        if (novoReceituario){
            objeto.setReceituarios(receituario);
        }
        Util.mensagemInformacao("Receituário adicionado com sucesso!");
    }
    
    public void removerReceituario(int index){
        objeto.removerReceituarios(index);
        Util.mensagemInformacao("Receituário removido com sucesso!");
    }
    
}
