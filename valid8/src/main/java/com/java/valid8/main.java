package com.java.valid8;

import com.java.valid8.fluent.Validator;

record User(String nome, String email, Integer age) {}

public class main {
    public static void main(String[] args) {
        final User user = new User("Vitor", null, null);

        final Validator<User> validator = Validator.of(user)
                .require(User::age, "age")
                    .notNull()
                    .greaterThan(18)
                    .done()
                .require(User::email, "email")
                    .notNull()
                    .email()
                    .done();

        try {
            validator.throwIfInvalid();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
