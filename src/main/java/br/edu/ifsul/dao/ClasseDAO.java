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
    }
}
