/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.AeroportoDAO;
import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.modelo.Aeroporto;
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
@Named(value = "controleAeroporto")
@ViewScoped
public class ControleAeroporto implements Serializable{
    @EJB
    private AeroportoDAO<Aeroporto> dao;
    private Aeroporto objeto;
    @EJB
    private CidadeDAO<Cidade> daoCidade;

    public ControleAeroporto() {

    }

    public String listar() {
        return "/privado/Aeroporto/listar?faces-redirect-true";
    }

    public void novo() {
        objeto = new Aeroporto();
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

    public AeroportoDAO<Aeroporto> getDao() {
        return dao;
    }

    public void setDao(AeroportoDAO<Aeroporto> dao) {
        this.dao = dao;
    }

    public Aeroporto getObjeto() {
        return objeto;
    }

    public void setObjeto(Aeroporto objeto) {
        this.objeto = objeto;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
}
