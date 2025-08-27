# Valid8 - Biblioteca de Validação para Java

Valid8 é uma biblioteca de validação para Java que oferece uma forma flexível e poderosa de validar dados em suas aplicações. Com suporte a anotações e uma API fluente, o Valid8 simplifica a implementação de regras de validação complexas de forma elegante e manutenível.

## Recursos Principais

- **Validação baseada em anotações**
- **API fluente** para validações programáticas
- **Validações prontas para uso** para os principais tipos de dados
- **Mensagens de erro personalizáveis**
- **Integração simples** com projetos Java existentes

## Tecnologias

- Java 21+
- Maven para gerenciamento de dependências
- Anotações para validação declarativa
- Design Pattern: Builder para a API fluente

## Anotações Disponíveis

### Validação de Strings
- `@NotBlank` - Verifica se a string não está vazia ou nula
- `@Email` - Valida o formato de e-mail
- `@AlphaNumeric` - Verifica se contém apenas letras e números
- `@MaxLength` - Define um tamanho máximo para a string
- `@MinLength` - Define um tamanho mínimo para a string
- `@Pattern` - Valida a string contra uma expressão regular
- `@StrongPassword` - Valida a força de senhas

### Validação de Números
- `@Positive` - Números positivos
- `@Negative` - Números negativos
- `@Digits` - Número de dígitos e casas decimais
- `@Max` - Valor máximo
- `@Min` - Valor mínimo
- `@Range` - Faixa de valores
- `@Zero` - Valor zero

### Validação de Datas
- `@Future` - Data futura
- `@Past` - Data passada

### Validação de Documentos
- `@CPF` - Validação de CPF brasileiro
- `@CNPJ` - Validação de CNPJ brasileiro
- `@UUIDValid` - Validação de UUID

## Como Usar

### 1. Adicionando a Dependência

Adicione ao seu `pom.xml`:

```xml
<dependency>
    <groupId>io.github.vijcoelho</groupId>
    <artifactId>valid8</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. Usando Anotações

```java
import com.java.valid8.annotations.*;
import com.java.valid8.annotations.security.*;
import com.java.valid8.annotations.dates.*;

public record Usuario(
    @NotBlank @UUIDValid
    String id,
    
    @NotBlank @CPF
    String cpf,
    
    @NotBlank @Email
    String email,
    
    @NotBlank @StrongPassword @MaxLength(max = 12)
    String senha,
    
    @Positive @Max(120)
    Integer idade,
    
    @Past
    LocalDate dataNascimento
) {}
```

### 3. Usando a API Fluente

```java
import com.java.valid8.fluent.Validator;

public class ValidadorUsuario {
    public void validar(Usuario usuario) {
        Validator.of(usuario)
            .requireString(Usuario::email)
                .notBlank()
                .email()
                .done()
            .requireString(Usuario::senha)
                .minLength(8)
                .matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$")
                .done()
            .requireNumber(Usuario::idade)
                .min(18)
                .max(120)
                .done()
            .throwIfInvalid();
    }
}
```

## Exemplo Completo

```java
import com.java.valid8.Validator;
import com.java.valid8.annotations.*;
import com.java.valid8.annotations.security.*;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Criando um usuário válido
        Usuario usuario = new Usuario(
            UUID.randomUUID().toString(),
            "123.456.789-09",
            "usuario@exemplo.com",
            "Senha@123",
            30,
            LocalDate.of(1993, 5, 15)
        );

        // Validando
        try {
            Validator.of(usuario).throwIfInvalid();
            System.out.println("Usuário válido! ");
        } catch (Exception e) {
            System.err.println("Erro de validação: " + e.getMessage());
        }
    }
}
```

## Licença

MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## Contato

Vitor José Coelho - vijcoelho@gmail.com

Link do Projeto: [https://github.com/vijcoelho/Valid8](https://github.com/vijcoelho/Valid8)
