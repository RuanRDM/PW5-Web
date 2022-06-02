/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ClasseDAO;
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
@Named(value = "controleClasse")
@ViewScoped
public class ControleClasse implements Serializable{
    
    @EJB
    private ClasseDAO<Classe> dao;
    private Classe objeto;
    
    public ControleClasse(){
        
    }

     public void novo(){
        objeto = new Classe();
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
        return "/privado/Classe/listar?faces-redirect-true";
    }

    public ClasseDAO<Classe> getDao() {
        return dao;
    }

    public void setDao(ClasseDAO<Classe> dao) {
        this.dao = dao;
    }

    public Classe getObjeto() {
        return objeto;
    }

    public void setObjeto(Classe objeto) {
        this.objeto = objeto;
    }
}
