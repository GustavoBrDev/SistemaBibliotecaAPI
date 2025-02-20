# Sistema Biblioteca

API em Spring Web para Gerenciamento de uma Biblioteca

## Funcionalidades do sistema

O sistema consta com as seguintes funcionalidades desenvolvidas e operacionais:

> CRUD de Usuários
> CRUD de Livros
> CRUD de Autores
> CRUD de Gêneros
> CRUD de Empréstimos
> Rotas para gerenciamento de empréstimo

## Pontos de Melhoria

O projeto atendeu com oque foi solicitado, porém há alguns pontos que poderiam ser aprimorados. Os principais dele são:

> **Criação de um empréstimo:** Atualmente o livro é criado junto com o empréstimo devido ao uso inadequado de uma DTO. Isso pode resultar em alguns erros ou operações desnecessárias.
> **Métodos de Atualização:** Os métodos de atualização recebem o valor de ID de forma duplicada devido a uma DTO.
> **Otimização de DTOs:** Um dos meus objetivos foi me aperfeiçoar em relação ao uso de DTOs. Tais criaram um fluxo de validação que inicia desde o controller. Porém, algumas poderiam ser modificadas / descartadas para alterar o fluxo conforme pode ser visto acima.
> **Tratamento de Erros**: O tratamento de erros pode ser aprimorado, retornando mensagens especificas em alguns erros. Isso se deve em sua maioria pelo uso de um @ControllerAdvicer e criação de Exceptions dedicadas.

Tais melhorias poderiam sim ser implementadas, mas optei por não fazer o mesmo devido:

1. **Escopo do Projeto**: Já havia ultrapassado o escopo do projeto e tais tratamentos iriam muito além do mesmo.
2. **Tempo:** Tais alterações poderiam levar um tempo que não possuo.
3. **Documentação:** A alteração do código resultaria na necessidade de atualizar a documentação, o que, por sua vez, levaria mais tempo.


