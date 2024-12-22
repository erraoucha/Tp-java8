package com.example.yassineehtp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

public class PersonTest {

        @Test
        public void testFilterByAddress() {
                List<Person> peopleLivingIn123RueA = Person.filterByAddress("123 Rue A");
                // Liste attendue des personnes vivant à "123 Rue A"
                List<Person> expectedPersonsLivingIn123RueA = Arrays.asList(
                                Person.builder().firstName("Alice").familyName("Doe")
                                                .birthDate(LocalDate.of(1990, 5, 12))
                                                .address("123 Rue A").build(),
                                Person.builder().firstName("Charlie").familyName("Brown")
                                                .birthDate(LocalDate.of(1985, 3, 9))
                                                .address("123 Rue A").build());

                // Vérification avec AssertJ
                assertThat(peopleLivingIn123RueA).containsExactlyInAnyOrderElementsOf(expectedPersonsLivingIn123RueA);
        }

        @Test
        public void testFilterAdults() {
                List<Person> adults = Person.filterAdults();

                // Liste attendue des adultes (18 ans ou plus)
                List<Person> expectedAdultPersons = Arrays.asList(
                                Person.builder().firstName("Alice").familyName("Doe")
                                                .birthDate(LocalDate.of(1990, 5, 12))
                                                .address("123 Rue A").build(),
                                Person.builder().firstName("Bob").familyName("Smith")
                                                .birthDate(LocalDate.of(2005, 10, 15))
                                                .address("456 Rue B").build(),
                                Person.builder().firstName("Charlie").familyName("Brown")
                                                .birthDate(LocalDate.of(1985, 3, 9))
                                                .address("123 Rue A").build());

                // Vérification avec AssertJ
                assertThat(adults).containsExactlyInAnyOrderElementsOf(expectedAdultPersons);
        }

}