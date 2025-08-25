package com.java.valid8;

import com.java.valid8.annotations.NotNull;
import com.java.valid8.annotations.dates.Future;
import com.java.valid8.annotations.dates.Past;
import com.java.valid8.annotations.numbers.*;
import com.java.valid8.annotations.security.CNPJ;
import com.java.valid8.annotations.security.CPF;
import com.java.valid8.annotations.security.StrongPassword;
import com.java.valid8.annotations.security.UUIDValid;
import com.java.valid8.annotations.strings.*;
import com.java.valid8.fluent.Validator;

import java.time.LocalDate;
import java.util.UUID;

record User(
        @NotNull @UUIDValid String uuid,
        @CNPJ String cnpj,
        @CPF String cpf,
        @NotBlank @AlphaNumeric String nome,
        @NotBlank @Email String email,
        @NotBlank @StrongPassword @MaxLength(max = 12) String password,
        @NotNull @Digits(digits = 1, decimals = 1) @Positive Number age,
        @Past LocalDate date,
        @Future LocalDate futureDate
) {
}

public class main {

    public static void main(String[] args) {
        System.out.println("--- Teste de Validação com Anotações ---");

        final User userValido = new User(
                String.valueOf(UUID.randomUUID()),
                "98663315000113",
                "153.871.910-08",
                "dae39i",
                "dae39i@gmail.com",
                "P$d173WE23s",
                3.1,
                LocalDate.of(2024, 8, 1),
                LocalDate.of(2026, 1, 1)
        );

        final Validator<User> validandoValido = Validator.of(userValido);

        try {
            validandoValido.throwIfInvalid();
            System.out.println("Validação de usuário VÁLIDO passou! ✅");
        } catch (Exception e) {
            System.err.println("Validação de usuário VÁLIDO falhou. ❌");
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
