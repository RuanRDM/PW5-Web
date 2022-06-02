/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Classe;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruan_
 */
public class ConverterPessoa implements Serializable, Converter{
    @PersistenceContext(unitName = "PW5-Web-PU")
    private EntityManager em;
    
    // da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Classe.class, Integer.parseInt(string));
    }

    // converte da objeto para tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Classe obj = (Classe) t;
        return obj.getId().toString();
    }
}
