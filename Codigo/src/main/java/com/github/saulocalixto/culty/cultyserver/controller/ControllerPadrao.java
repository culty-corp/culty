package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.dto.DTOPadrao;
import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public abstract class ControllerPadrao<T extends ObjetoPadrao, T_DTO extends DTOPadrao<T>> {

    @Autowired
    protected abstract IServicoPadrao<T, T_DTO> Servico();

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public ResponseEntity consultarTodos() {
        try {
            List<T_DTO> lista = Servico().consultarTodos();
            return ResponseEntity.ok().body(ObtenhaSucesso(lista));
        } catch (Exception e) {
            Resposta<Exception> erro = ObtenhaErro(e);
            return ResponseEntity.badRequest().body(erro);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity consultarPorId(@PathVariable("id") String id) {
        try {
            T_DTO objeto = Servico().consultarDTOPorId(id);
            return ResponseEntity.ok().body(ObtenhaSucesso(objeto));
        } catch (Exception e) {
            Resposta<Exception> erro = ObtenhaErro(e);
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    public ResponseEntity criar(@RequestBody T_DTO objeto) {
        try {
            objeto = Servico().criar(objeto);
            return ResponseEntity.ok().body(ObtenhaSucesso(objeto));
        } catch (Exception e) {
            Resposta<Exception> erro = ObtenhaErro(e);
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletar(@PathVariable("id") String id) {
        try {
            Servico().deletar(id);
            return ResponseEntity.ok().body(ObtenhaSucesso());
        } catch (Exception e) {
            Resposta<Exception> erro = ObtenhaErro(e);
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizar(@PathVariable("id") String id, @RequestBody T_DTO objeto) {
        try {
            objeto.setId(id);
            Servico().atualizar(objeto);
            return ResponseEntity.ok().body(ObtenhaSucesso());
        } catch (Exception e) {
            Resposta<Exception> erro = ObtenhaErro(e);
            return ResponseEntity.badRequest().body(erro);
        }
    }

    private Resposta ObtenhaSucesso(T_DTO resposta){
        return new Resposta<T_DTO>().ObtenhaResposta(
                resposta,
                "OPERAÇÃO REALIZADA COM SUCESSO",
                true
        );
    }

    private Resposta<List<T_DTO>> ObtenhaSucesso(List<T_DTO> resposta){
        return new Resposta<List<T_DTO>> ().ObtenhaResposta(
                resposta,
                "OPERAÇÃO REALIZADA COM SUCESSO",
                true
        );
    }

    private Resposta<T_DTO> ObtenhaSucesso(){
        return new Resposta<T_DTO>().ObtenhaResposta(
                null,
                "OPERAÇÃO REALIZADA COM SUCESSO",
                true
        );
    }

    private Resposta<Exception> ObtenhaErro(Exception e){
        return new Resposta<Exception>().ObtenhaResposta(
                null,
                e.getMessage(),
                false
        );
    }
}
