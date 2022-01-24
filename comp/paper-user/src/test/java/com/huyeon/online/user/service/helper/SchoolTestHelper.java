package com.huyeon.online.user.service.helper;

import com.huyeon.online.user.domain.School;
import com.huyeon.online.user.service.SchoolService;
import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class SchoolTestHelper {
    private final SchoolService schoolService;

    public static School makeSchool(String name, String city) {
        return School.builder()
                .name(name)
                .city(city)
                .build();
    }

    public School createSchool(String name, String city) {
        return schoolService.save(makeSchool(name, city));
    }

    public static void assertSchool(School school, String name, String city) {
        assertNotNull(school.getSchoolId());
        assertNotNull(school.getCreated());
        assertNotNull(school.getUpdated());

        assertEquals(name, school.getName());
        assertEquals(city, school.getCity());

    }
}
