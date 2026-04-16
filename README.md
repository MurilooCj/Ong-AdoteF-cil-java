#  Sistema de ONG de Adoção de Animais

Aplicação desenvolvida em Java com integração ao MySQL para gerenciamento de adoção de animais.

##  Funcionalidades

- Cadastro de doadores
- Cadastro de receptores (adotantes)
- Registro de animais para adoção
- Listagem de animais disponíveis
- Processo de adoção
- Associação entre animal, doador e receptor

## 🛠️ Tecnologias utilizadas

- Java
- Java Swing (Interface gráfica)
- MySQL
- JDBC

##  Regras de negócio

- Um doador pode cadastrar vários animais
- Um animal pode ser adotado por um receptor
- Após adoção, o animal deixa de estar disponível
- Cada animal possui um responsável (doador)

##  Estrutura do banco de dados

### Tabela Animal
- id_animal (PK)
- nome
- raça
- idade
- sexo
- tipo
- id_doador (FK)
- id_receptor (FK)
- status

### Tabela Doador
- id_doador (PK)
- nome
- email
- cpf
- endereco

### Tabela Receptor
- id_receptor (PK)
- nome
- email
- cpf
- endereco

##  Como executar o projeto

1. Clone o repositório
2. Configure o banco de dados MySQL
3. Atualize usuário e senha na classe `Conexao`
4. Execute a classe principal `ProjetoOng`

##  Melhorias futuras

- Interface mais moderna
- Sistema de login por CPF
- Filtro de animais
- Exibição em tabela (JTable)

##  Autor

Murilo Ignacio
