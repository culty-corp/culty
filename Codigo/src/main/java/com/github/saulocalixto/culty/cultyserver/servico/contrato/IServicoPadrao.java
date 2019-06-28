package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.dto.DTOPadrao;
import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import org.bson.types.ObjectId;

import java.util.List;

public interface IServicoPadrao<T extends ObjetoPadrao, T_DTO extends DTOPadrao<T>> {
    /***
     * Consulta um objeto passando o id como elemento.
     * @param id id do objeto a ser consultado.
     * @return Objeto consultado no banco.
     */
    T consultarPorId(String id);

    /***
     * Consulta e prepara um dto de objeto passando o id como elemento.
     * @param id id do objeto a ser consultado.
     * @return DTO do objeto consultado no banco.
     */
    T_DTO consultarDTOPorId(String id);

    /***
     * Consulte todos os elementos salvos na coleção.
     * @return Lista de DTO de todos os elementos persistidos.
     */
    List<T_DTO> consultarTodos();

    /***
     * Salva no banco um objeto.
     * @param dto DTO do objeto a ser salvo.
     */
    T_DTO criar(T_DTO dto);

    /***
     * Atualiza um objeto existente no banco.
     * @param dto DTO dbjeto a ser atualizado.
     */
    T_DTO atualizar(T_DTO dto);

    /***
     * Remove do banco um objeto.
     * @param id Objeto a ser removido.
     */
    void deletar(String id);
}
