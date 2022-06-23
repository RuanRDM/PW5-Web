/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Voo;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author ruan_
 */
@Stateful
public class VooDAO<TIPO> extends DAOGenerico<Voo> implements Serializable {
    
    public VooDAO(){
        super();
        classePersistente = Voo.class;
        //lista ordenações possiveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        //ordemAtual
        ordemAtual = listaOrdem.get(1);
        // inicicalizar o conversor de ordem com a lista de ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
