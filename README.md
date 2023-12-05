# ✈ Sistema de Gestão de Agência de Turismo (SGAT)

## 📄 Sumário

[1. O que é o projeto?](#o-que-e-o-projeto)

[2. Quais são os requisitos de software?](#requisitos)

[3. Como executar o projeto na minha máquina?](#executar)

[4. O que mais pode ser necessário?](#notas)

<a id="o-que-e-o-projeto"></a>
## ✨ O que é o projeto?

O SGAT é um sistema para gestão de agências de turismo, desenvolvido para a disciplina de Engenharia de Software II. O grupo do projeto é composto por:

- Edeilton Oliveira
- Jonathan Pablo
- Marcelo Junior
- Túlio Jad
- Vinicius Lemos

<a id="requisitos"></a>
## ✅ Quais são os requisitos de software?

- IntelliJ IDEA 2023.2.2 (build 232.9921.47)
- Java 17.0.8
- JavaFX 17.0.8
- PostgreSQL 16.1

### Opcionais
- SceneBuilder 21
- pgAdmin 4 (recomendado para a execução deste tutorial)

### Observações

- O JavaFX é disponibilizado com a IDE IntelliJ, basta usar a opção de criar projeto com ele
- O SceneBuilder só é necessário se você quiser uma ferramenta gráfica para edição das views
- O pgAdmin 4 pode ser instalado por meio do mesmo menu de instalação do PostgreSQL

<a id="executar"></a>
## ⚡ Como executar o projeto na minha máquina?

Se você já cumpriu os requisitos de software, siga os passos abaixo:

### Parte 1: instalação do PostgreSQL

- Marque também a opção para instalar o pgAdmin 4
- Crie uma senha para o administrador do database
- Configure a porta 5432 ou modifique a porta utilizada na constante URL do arquivo `ConnectionFactory.java`

### Parte 2: criação do banco de dados

- Acesse o pgAdmin
- No menu à esquerda, acesse: `PostgreSQL 16` > `Databases` > `Create` > `Database...`
- Insira "agencia_turismo" no campo de nome do database (correspondente ao arquivo `ConnectionFactory.java`)
- Salve as alterações

### Parte 3: criação das tabelas

- Acesse: `agencia_turismo` > `menu de contexto` > `Query Tool`
- Insira os comandos abaixo para criar as tabelas:

```sql
CREATE TABLE cliente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(20),
    historicoViagens TEXT,
    preferencias TEXT
);

CREATE TABLE pacote_turistico (
    codigo_pacote INTEGER PRIMARY KEY,
    destino VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    itinerario TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    descricao TEXT,
    quantidade_vagas INTEGER NOT NULL CHECK (quantidade_vagas >= 0)
);

CREATE TABLE reserva (
    id_reserva SERIAL PRIMARY KEY,
    cpf_cliente VARCHAR(11) NOT NULL REFERENCES cliente(cpf),
    codigo_pacote INTEGER NOT NULL REFERENCES pacote_turistico(codigo_pacote),
    data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    quantidade_vagas_solicitadas INTEGER NOT NULL CHECK (quantidade_vagas_solicitadas > 0)
);
```

- Acesse: `agencia_turismo` > `Menu de contexto` > `Refresh...`
- Se desejar, confira as tabelas em `agencia_turismo` > `Schemas` > `Tables`

### Parte 4: download e eecução do projeto

- Faça o `git clone` do repositório
- Abra a IDE IntelliJ e acesse: `Arquivo` > `Open...` > `Selecionar pasta do projeto`
- Abra o arquivo `src\main\java\br\edu\univasf\agencia_turismo\Main.java`
- Execute a aplicação usando o botão de play ou `Shift + F10`

<a id="notas"></a>
## 📝 O que mais pode ser necessário?

### Como alterar a porta do PostgreSQL no Windows?
- Edite a porta em `C:\Program Files\PostgreSQL\<version>\data`
- Execute `win + R` > `services.msc` > `postgresql-x64-16` > `iniciar/reiniciar serviço`
- Certifique-se de que a porta no arquivo esteja igual à porta no servidor do pgAdmin
- Clique com o botão direito no servidor > Conectar > Digitar a senha

### Como alterar a senha do superuser do PostgreSQL?

- Abra o SQL shell (psql)
- Execute `ALTER USER postgres WITH PASSWORD 'nova_senha';`