package ru.eda.tech.authorization.process;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListProfileRepositoryTest {

    TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
            .withUsername("shpikich")
            .withPassword("12345678")
            .withId(0)
            .build();
    PersonalInformation personalInformation = new PersonalInformation.Builder()
            .withName("Nikita")
            .withSurname("Yushkov")
            .withAge(24)
            .withGender(Gender.Male)
            .withEmail("y@gmail.com")
            .withPhone("88005553535")
            .withDateOfBirth(LocalDate.of(1997, 3, 14))
            .build();
    Profile profile = new Profile.Builder()
            .withTechnicalInformation(technicalInformation)
            .withPersonalInformation(personalInformation)
            .build();

    ArrayListProfileRepository arrayListProfileRepository = new ArrayListProfileRepository();

    @Test
    void savedIsSameAsFound() {

        arrayListProfileRepository.save(profile);
        assertEquals(profile, arrayListProfileRepository.find(technicalInformation.getId()));
    }

    @Test
    void findProfileByWrongId() {

        arrayListProfileRepository.save(profile);
        assertNull(arrayListProfileRepository.find(technicalInformation.getId() + 2));
    }

    @Test
    void findProfileInEmptyRepository() {
        assertNull(arrayListProfileRepository.find(1));
    }
}