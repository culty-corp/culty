package com.github.saulocalixto.culty.cultyserver.repositorio;

import com.github.saulocalixto.culty.cultyserver.configuracao.SpringMongoConfig;
import com.mongodb.DBObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.*;

public class MidiaRepository {
    private ApplicationContext contexto;
    GridFsOperations operacoes;

    public MidiaRepository() {
        contexto = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        operacoes = (GridFsOperations) contexto.getBean("gridFsTemplate");
    }

    /***
     * Salva no banco uma mídia (imagem, vídeo, áudio).
     * @param midia A mídia que será persistida convertida em bytes.
     * @param metaDados Dados extras do arquivo persistido.
     * @param nomeArquivo Nome do arquivo.
     * @param tipoArquivo Tipo do arquivo.
     */
    public void salveMidia(byte[] midia, DBObject metaDados, String nomeArquivo, String tipoArquivo) {
        try (InputStream inputStream = new ByteArrayInputStream(midia)) {
            operacoes.store(inputStream, nomeArquivo, tipoArquivo, metaDados);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
