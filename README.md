# Gerenciador de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java para adicionar, buscar, excluir e listar livros.

## 📋 Requisitos

- **Java 25 ou superior** (o projeto utiliza recursos modernos do Java como records e unnamed classes)
- JDK instalado e configurado no PATH

## 🚀 Como Executar

### 1. Compilar o projeto

No diretório raiz do projeto, execute:

```bash
javac -d out src/Main.java src/gerenciador/model/Livro.java src/gerenciador/service/GerenciadorBibliotecaService.java
```

### 2. Executar o programa

```bash
java -cp out Main
```

## 📖 Como Usar

Ao executar o programa, você verá um menu com as seguintes opções:

```
=== Gerenciador de Biblioteca ===
1. Adicionar novo livro
2. Buscar livro por título
3. Excluir livro por título
4. Listar todos os livros
5. Sair
```

## 🧪 Como Testar Todos os Cenários

### Cenário 1: Adicionar Livros com Sucesso
1. Escolha a opção **1**
2. Digite o título: `Dom Casmurro`
3. Digite o autor: `Machado de Assis`
4. ✅ **Resultado esperado**: "Livro Dom Casmurro do autor Machado de Assis adicionado ao acervo."

### Cenário 2: Tentar Adicionar Livro com Título Vazio
1. Escolha a opção **1**
2. Digite o título: *(pressione Enter sem digitar nada)*
3. Digite o autor: `Algum Autor`
4. ❌ **Resultado esperado**: "Error: Título e autor não podem ser vazios." - volta ao menu

### Cenário 3: Tentar Adicionar Livro com Autor Vazio
1. Escolha a opção **1**
2. Digite o título: `Algum Livro`
3. Digite o autor: *(pressione Enter sem digitar nada)*
4. ❌ **Resultado esperado**: "Error: Título e autor não podem ser vazios." - volta ao menu

### Cenário 4: Tentar Adicionar Livro Duplicado
1. Primeiro adicione um livro (ex: "1984" de "George Orwell")
2. Escolha a opção **1** novamente
3. Digite o título: `1984`
4. Digite o autor: `George Orwell`
5. ❌ **Resultado esperado**: "Error: Livro 1984 já existe no acervo." - volta ao menu

### Cenário 5: Listar Todos os Livros (Acervo Vazio)
1. Execute o programa
2. Escolha a opção **4**
3. ✅ **Resultado esperado**: "Nenhum livro no acervo."

### Cenário 6: Listar Todos os Livros (Com Livros)
1. Adicione alguns livros primeiro
2. Escolha a opção **4**
3. ✅ **Resultado esperado**: Lista de todos os livros adicionados

### Cenário 7: Buscar Livro Existente
1. Adicione um livro (ex: "O Cortiço" de "Aluísio Azevedo")
2. Escolha a opção **2**
3. Digite o título: `O Cortiço`
4. ✅ **Resultado esperado**: "Livro encontrado: O Cortiço de Aluísio Azevedo"

### Cenário 8: Buscar Livro que Não Existe
1. Escolha a opção **2**
2. Digite o título: `Livro Inexistente`
3. ❌ **Resultado esperado**: "Error: Livro Livro Inexistente não encontrado no acervo." - volta ao menu

### Cenário 9: Buscar Livro com Case Insensitive
1. Adicione um livro: "Memórias Póstumas de Brás Cubas"
2. Escolha a opção **2**
3. Digite o título: `memorias postumas de bras cubas` (tudo minúsculo)
4. ✅ **Resultado esperado**: Encontra o livro normalmente

### Cenário 10: Excluir Livro Existente
1. Adicione um livro (ex: "Capitães da Areia" de "Jorge Amado")
2. Escolha a opção **3**
3. Digite o título: `Capitães da Areia`
4. ✅ **Resultado esperado**: "Livro Capitães da Areia excluído do acervo."
5. Liste os livros (opção 4) para confirmar a exclusão

### Cenário 11: Tentar Excluir Livro que Não Existe
1. Escolha a opção **3**
2. Digite o título: `Livro que Não Existe`
3. ❌ **Resultado esperado**: "Error: Livro Livro que Não Existe não encontrado no acervo." - volta ao menu

### Cenário 12: Opção Inválida
1. Escolha uma opção inválida: `9`
2. ✅ **Resultado esperado**: "Opção inválida. Tente novamente." - volta ao menu

### Cenário 13: Sair do Programa
1. Escolha a opção **5**
2. ✅ **Resultado esperado**: "Saindo do gerenciador de biblioteca." - programa encerra

## 🔍 Fluxo de Teste Completo Recomendado

Execute os comandos na seguinte ordem para testar tudo:

```
1. Opção 4 (verificar acervo vazio)
2. Opção 1 → "Dom Casmurro" → "Machado de Assis"
3. Opção 1 → "1984" → "George Orwell"
4. Opção 1 → "O Cortiço" → "Aluísio Azevedo"
5. Opção 4 (ver os 3 livros listados)
6. Opção 1 → "1984" → "George Orwell" (testar duplicado - deve dar erro)
7. Opção 1 → "" → "Teste" (título vazio - deve dar erro)
8. Opção 1 → "Teste" → "" (autor vazio - deve dar erro)
9. Opção 2 → "1984" (buscar livro existente)
10. Opção 2 → "livro inexistente" (buscar livro que não existe - deve dar erro)
11. Opção 3 → "O Cortiço" (excluir livro)
12. Opção 4 (verificar que restam apenas 2 livros)
13. Opção 3 → "Livro Inexistente" (tentar excluir livro que não existe - deve dar erro)
14. Opção 9 (opção inválida)
15. Opção 5 (sair)
```

## 📁 Estrutura do Projeto

```
gerenciador_biblioteca/
├── src/
│   ├── Main.java
│   └── gerenciador/
│       ├── model/
│       │   └── Livro.java
│       └── service/
│           └── GerenciadorBibliotecaService.java
└── README.md
```

## 🛠️ Tecnologias Utilizadas

- Java 25+
- Records (Java 14+)
- Streams API
- ArrayList para armazenamento em memória

## 📝 Notas

- O sistema armazena os livros em memória, então os dados são perdidos ao encerrar o programa
- A busca por título é case-insensitive (não diferencia maiúsculas de minúsculas)
- O sistema não permite livros com título ou autor vazios
- Não é permitido adicionar livros com títulos duplicados
- Quando ocorre um erro, o programa volta automaticamente ao menu principal

