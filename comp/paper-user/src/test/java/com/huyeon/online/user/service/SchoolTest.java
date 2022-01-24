package com.huyeon.online.user.service;

import com.huyeon.online.user.domain.School;
import com.huyeon.online.user.repository.SchoolRepository;
import com.huyeon.online.user.service.helper.SchoolTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SchoolTest {

    @Autowired
    private SchoolRepository schoolRepository;

    private SchoolService schoolService;
    private SchoolTestHelper schoolTestHelper;
    private School school;

    @BeforeEach
    void before() {
        this.schoolRepository.deleteAll();
        this.schoolService = new SchoolService(schoolRepository);
        this.schoolTestHelper = new SchoolTestHelper(schoolService);

        school = schoolTestHelper.createSchool("테스트 학교", "서울");
    }

    @DisplayName("1. 학교 생성")
    @Test
    void test_1(){
        List<School> list = schoolRepository.findAll();
        assertEquals(1, list.size());
        SchoolTestHelper.assertSchool(list.get(0), "테스트 학교", "서울");
    }

    @DisplayName("2. 학교 이름 수정")
    @Test
    void test_2() {
        schoolService.updateName(school.getSchoolId(), "테스트 학교 2");
        assertEquals("테스트 학교 2", schoolRepository.findAll().get(0).getName());
    }

    @DisplayName("3. 지역 목록")
    @Test
    void test_3() {
        List<String > list = schoolService.cities();
        assertEquals(1, list.size());
        assertEquals("서울", list.get(0));

        schoolTestHelper.createSchool("부산 학교", "부산");
        list = schoolService.cities();
        assertEquals(2, list.size());
    }

    @DisplayName("4. 지역명으로 학교 목록 가져오기")
    @Test
    void test_4() {
        List<School> list = schoolService.findAllByCity("서울");
        assertEquals(1, list.size());

        schoolTestHelper.createSchool("서울 학교", "서울");
        list = schoolService.findAllByCity("서울");
        assertEquals(2, list.size());
    }
}
