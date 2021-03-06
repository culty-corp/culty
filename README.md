# Culty

## O que é?
O **Culty** é uma rede social voltada para artistas independentes (músicos, escritores, pintores...) que muitas vezes não têm a arte como principal fonte de renda, mas que gostaria que o conteúdo artístico e cultural que produz pudesse chegar a outras pessoas. Isto sem depender do número de seguidores, por exemplo.

## Como funciona?
A ideia inicial é fomentar a **produção artística e cultural na cidade de Goiânia**. Para isso, o **Culty** tem como objetivo disponibilizar uma plataforma de para upload e compartilhamento de mídias nos formatos de **vídeo**, **áudio**, **texto** e **imagem**.

## O trabalho
O **projeto Culty** foi idealizado e produzido no contexto do curso de **Bacharelado em Engenharia de Software** do **INF-UFG** pelos alunos:

- Gustavo Henrique da Silva Batista
- Lucas Sampaio Dias
- Murillo Silva e Nunes
- Marcos Rafael Souza
- Saulo de Araújo Calixto

O projeto foi desenvolvido para três disciplinas que foram ministradas simultâneamente e possuíam grande sobreposição de escopos. As disciplinas em questão foram:

- Desenvolvimento de Software para Dispositivos Ubíquos
- Desenvolvimento de Software para Persistência
- Desenvolvimento de Software para Web

## API

Os dados do Culty podem ser acessados via REST API utilizando a seguinte URI:
```sh
http://sifo.tech/culty/
```

### Usuarios (/usuarios)
* GET /usuarios
* GET /usuarios/{id}
* GET /usuarios/consultarPorNome?text={nome}
* PUT /usuarios/{id}
* PUT /usuarios/seguir/{idseguidor}/{idseguido}
* PUT /usuarios/deixarDeSeguir/{idseguidor}/{idseguido}
* PUT /usuarios/gostar/{idUsuario}/{idObra}
* PUT /usuarios/deixarDeGostar/{idUsuario}/{idObra}
* POST /usuarios
* DELETE /usuarios/{id}


```json
"nomeUsuario": "saulocalixto",
"descricao": null,
"email": "email@teste.com.br",
"dataDeNascimento": null,
"localizacao": null,
"redesSociais": {
  "facebook": null,
  "instagram": null,
  "youtube": null
}
```

### Obras (/obras)
* GET /obras
* GET /obras/{id}
* GET /obras/consultarPorFiltro?text={param1,param2,...}
* PUT /obras/{id}
* POST /obras
* DELETE /obras/{id}

```json
"nome": "Obra de Paris",
"tipoConteudo": null,
"usuario": null,
"descricao": null,
"conteudo": null,
"quantGostei": 3,
"quantVisualizacoes": 10,
"filtros": [
  "pintura",
  "desenho",
  "paris",
  "bonita"
]
```
