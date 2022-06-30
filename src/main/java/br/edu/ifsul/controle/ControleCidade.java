/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.ClasseDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ruan_
 */
@Named(value = "controleCidade")
@ViewScoped
public class ControleCidade implements Serializable{
    
    @EJB
    private CidadeDAO<Cidade> dao;
    private Cidade objeto;
    
    public ControleCidade(){
        
    }

    public void novo(){
        objeto = new Cidade();
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+ Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso. ");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+ Util.getMensagemErro(e));
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
    
    
    
    public String listar(){
        return "/privado/Cidade/listar?faces-redirect=true";
    }


    public CidadeDAO<Cidade> getDao() {
        return dao;
    }

    public void setDao(CidadeDAO<Cidade> dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }
    
    
}
