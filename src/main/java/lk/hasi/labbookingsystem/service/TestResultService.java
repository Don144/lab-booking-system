package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.TestResultDTO;
import lk.hasi.labbookingsystem.entity.TestResult;

import java.util.List;

public interface TestResultService {

    TestResultDTO addNewTestResult(TestResult testResult);

    List<TestResultDTO> fetchAll();

    TestResultDTO updateTestResultDetails(TestResult testResult,
                           Integer testId);

    void removeTestDetails(Integer testId);
}
