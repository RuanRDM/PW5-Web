package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Classe;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author ruan_
 */
@Stateful
public class ClasseDAO<TIPO> extends DAOGenerico<Classe> implements Serializable{
    
    public ClasseDAO(){
        super();
        classePersistente = Classe.class;
        //lista ordenações possiveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        //ordemAtual
        ordemAtual = listaOrdem.get(1);
        // inicicalizar o conversor de ordem com a lista de ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
