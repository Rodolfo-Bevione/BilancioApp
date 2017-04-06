/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Variazione;

import com.airhacks.AbstractManager;
import static com.airhacks.Variazione.Variazione.FIND_BY_IDUTENTE;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
public class VariazioneManager extends AbstractManager {

    @PersistenceContext
    EntityManager em;
    
    public List<Variazione> findByUserId (long id)
    {
        return (em.createNamedQuery(FIND_BY_IDUTENTE, Variazione.class).setParameter("id", id).getResultList());
    }
}
