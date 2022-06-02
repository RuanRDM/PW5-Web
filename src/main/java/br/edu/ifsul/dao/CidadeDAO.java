/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author ruan_
 */
@Stateful
public class CidadeDAO<TIPO> extends DAOGenerico<Cidade> implements Serializable{
    
    public CidadeDAO(){
        super();
        classePersistente = Cidade.class;
    }

    
}
