
# TEST DE API



## Stack utilizada

**Back-end:** Java, Spring Boot,Spring Web, Spring Data Jpa, MapStruct, Validation.

**Infra:** Maven, Docker

**Banco de dados:** PostgreSQL, Redis(Cache)

## github

Clonar o código

```bash
  git@github.com:RicardoBarrote/TEST_API_INTUITIVE_CARE.git
```

## Docker

```Build
sudo docker-compose up --build -d
```

Após realizer o build, vamos subir a o contêiner

```Docker
sudo docker-compose up -d
```
## Documentação da API



### Class OperadoraController

```http
  POST /operadoras/importar
```

| RequestParam   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `file` | `MultipartFile` | **Obrigatório**. Este endpoint será responsável por receber o arquivo.csv e persistir os dados no banco.

Status: 200 OK
##


#### Listar as operadoras

```http
  GET /operadoras
```

Retornar uma lista de Operadoras.

Status: 200 OK
##


### Listar operadoras através do cnpj

```http
  GET /operadoras/cnpj
```

Endpoint vai receber o valor do CNPJ através do RequestParam.

Exemplo:

```URL
localhost:8080/operadoras/cnpj?cnpj= xxxxxxxxxxxx
```
Status: 200 OK
##


### Listar operadoras através da razaosocial

```http
  GET /operadoras/razaoSocial
```

Endpoint vai receber o valor da razaoSocial através do RequestParam.

Exemplo:

```URL
localhost:8080/operadoras/razaoSocial?razaoSocial= xxxxxxxxxxxx
```

Status: 200 OK
##
