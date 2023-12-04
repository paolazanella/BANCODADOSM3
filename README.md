
# Sistema de Imobiliária

## Descrição
Este projeto implementa um sistema de imobiliária em Java utilizando JDBC puro para interagir com um banco de dados MySQL. O sistema inclui CRUD para as entidades Imóvel, TipoImovel, Corretor, Proprietario e Endereco.

## Estrutura do Projeto
O projeto está organizado da seguinte forma:

- **src/...** - O código-fonte do projeto.
  - **Imovel.java** - Classe que representa a entidade Imóvel.
  - **TipoImovel.java** - Classe que representa a entidade TipoImovel.
  - **Corretor.java** - Classe que representa a entidade Corretor.
  - **Proprietario.java** - Classe que representa a entidade Proprietario.
  - **Endereco.java** - Classe que representa a entidade Endereco.
  - **ImovelRepository.java** - Classe responsável por interagir diretamente com o banco de dados para a entidade Imóvel.
  - **TipoImovelRepository.java** - Classe responsável por interagir diretamente com o banco de dados para a entidade TipoImovel.
  - **CorretorRepository.java** - Classe responsável por interagir diretamente com o banco de dados para a entidade Corretor.
  - **ProprietarioRepository.java** - Classe responsável por interagir diretamente com o banco de dados para a entidade Proprietario.
  - **EnderecoRepository.java** - Classe responsável por interagir diretamente com o banco de dados para a entidade Endereco.
  - **ImovelController.java** - Classe que atua como intermediária entre as views e os repositórios para a entidade Imóvel.
  - **TipoImovelController.java** - Classe que atua como intermediária entre as views e os repositórios para a entidade TipoImovel.
  - **CorretorController.java** - Classe que atua como intermediária entre as views e os repositórios para a entidade Corretor.
  - **ProprietarioController.java** - Classe que atua como intermediária entre as views e os repositórios para a entidade Proprietario.
  - **EnderecoController.java** - Classe que atua como intermediária entre as views e os repositórios para a entidade Endereco.
  - **ImovelView.java** - Classe para interação com o usuário para a entidade Imóvel.
  - **TipoImovelView.java** - Classe para interação com o usuário para a entidade TipoImovel.
  - **CorretorView.java** - Classe para interação com o usuário para a entidade Corretor.
  - **ProprietarioView.java** - Classe para interação com o usuário para a entidade Proprietario.
  - **EnderecoView.java** - Classe para interação com o usuário para a entidade Endereco.

Configuração do Banco de Dados
Certifique-se de ter um servidor MySQL em execução e crie um banco de dados chamado imobiliariabd_m3. As configurações de conexão com o banco de dados podem ser ajustadas no arquivo src/ConexaoJDBC.java.
Observação: Lembre-se de modificar as informações de conexão conforme o banco de dados local utilizado por você. Se estiver utilizando um banco de dados diferente ou estiver em um ambiente local, certifique-se de atualizar as configurações de host, porta, nome do banco de dados, nome de usuário e senha de acordo com suas configurações específicas.
java
Copy code
// Exemplo de configuração
String url = "jdbc:mysql://localhost:3306/imobiliariabd_m3";
String usuario = "seu_usuario";
String senha = "sua_senha";
Certifique-se de substituir "seu_usuario" e "sua_senha" pelos detalhes de autenticação específicos do seu banco de dados. Isso garantirá uma conexão adequada ao banco de dados local.
## Uso
1. Clone o repositório.
2. Configure o banco de dados conforme mencionado acima.
3. Execute o aplicativo.

## Dependências
- [Visual Studio Code](https://code.visualstudio.com/)
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [SQLTools](https://marketplace.visualstudio.com/items?itemName=mtxr.sqltools)
- [SQLTools MySQL/MariaDB/TiDB](https://marketplace.visualstudio.com/items?itemName=mtxr.sqltools-driver-mysql)




## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
