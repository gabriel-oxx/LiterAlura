# LiterAlura: Um Projeto de Pesquisa e Exibição de Informações sobre Livros
## Sobre o Projeto
Esse projeto foi desenvolvido como um desafio da [Alura](https://cursos.alura.com.br/course/spring-boot-challenge-literalura/). O projeto integra-se com um banco de dados PostgreSQL para armazenamento e recuperação eficiente de dados e com a API [Gutendex](https://github.com/garethbjohnson/gutendex) para a pesquisa de livros.
## Tecnologias Utilizadas
- Linguagem: Java
- Framework: Spring Boot
- Banco de Dados: PostgreSQL
- Dependências Principais:
- Spring Boot Starter Data JPA
- Spring Boot Starter Test
- Jackson Databind
- Jackson Core
- PostgreSQL
## Estrutura do Projeto
O projeto está organizado da seguinte forma:
- Código Fonte
- Localizado sob src/main/java/com/books/read/LiterAlura, contendo classes principais, modelos (Autor, Livro, Resultados), repositórios (AuthorRepository, BookRepository) e serviços (ApiConsumption, DataConverterI, DataConverterIImpl).
- Recursos
- Arquivos de configuração como application.properties estão armazenados sob src/main/resources.
- Compilação
- Classes compiladas são armazenadas sob target/classes, enquanto as classes de teste residem em target/test-classes.
## Como Executar o Projeto
Para executar o projeto, siga estas etapas:
1. Clone o repositório Git para sua máquina local.
2. Abra o projeto no IntelliJ IDEA ou qualquer IDE suportado pelo Spring Boot.
3. Certifique-se de que você tem o JDK 8 ou superior instalado.
4. Execute o comando mvn spring-boot:run no terminal para iniciar a aplicação.
## Licença
Este projeto é distribuído sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.