/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.AeroportoDAO;
import br.edu.ifsul.dao.VooDAO;
import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Voo;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.modelo.Cidade;


/**
 *
 * @author ruan_
 */
@Named(value = "controleVoo")
@ViewScoped
public class ControleVoo implements Serializable{
    @EJB
    private VooDAO<Voo> dao;
    private Voo objeto;
    @EJB
    private AeroportoDAO<Aeroporto> daoAeroporto;

    public ControleVoo() {

    }

    public String listar() {
        return "/privado/Voo/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Voo();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
       try {
           if (objeto.getId() == null){
               dao.persist(objeto);
           } else {
               dao.merge(objeto);
           }
           Util.mensagemInformacao("Objeto persistido com sucesso!");
       } catch (Exception e){
           Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
       }
    }

    public VooDAO<Voo> getDao() {
        return dao;
    }

    public void setDao(VooDAO<Voo> dao) {
        this.dao = dao;
    }

    public Voo getObjeto() {
        return objeto;
    }

    public void setObjeto(Voo objeto) {
        this.objeto = objeto;
    }

    public AeroportoDAO<Aeroporto> getDaoAeroporto() {
        return daoAeroporto;
    }

    public void setDaoAeroporto(AeroportoDAO<Aeroporto> daoAeroporto) {
        this.daoAeroporto = daoAeroporto;
    }


}
