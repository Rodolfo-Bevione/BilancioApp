/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Variazione;

import com.airhacks.AbstractREST;
import com.airhacks.Categoria.CategoriaManager;
import com.airhacks.Token.TokenNeeded;
import com.airhacks.Utente.UtenteManager;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author tss
 */
public class VariazioneREST extends AbstractREST
{
    @Inject
    CategoriaManager categoriamanager;

    @Inject
    UtenteManager utentemanager;

    @Inject
    VariazioneManager variazionemanager;
    
    @GET
    @Path("{id}")
    @TokenNeeded
    public List<Variazione> getListVariazione (@PathParam("id") Long id)
    {
        return (variazionemanager.findByUserId(id));
    }
}
