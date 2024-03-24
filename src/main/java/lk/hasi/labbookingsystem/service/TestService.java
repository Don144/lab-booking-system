package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.TestDto;
import lk.hasi.labbookingsystem.entity.Test;

import java.util.List;

public interface TestService {

    TestDto addNewTest(Test test);

    List<TestDto> fetchAll();

    List<TestDto> fetchAvailableTests(Boolean available);

    List<TestDto> fetchTestsFromTechnicians(Integer tech_id);

    Test updateTestDetails(Test test,
                             Integer testId);

    void removeTestDetails(Integer testId);
}
