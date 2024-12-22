package com.example.yassineehtp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class Person {
    private String firstName;
    private String familyName;
    private LocalDate birthDate;
    private String address;

    public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("123 Rue A").build());

        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public static List<Person> filterAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("123 Rue A").build());

        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;

        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }

}
