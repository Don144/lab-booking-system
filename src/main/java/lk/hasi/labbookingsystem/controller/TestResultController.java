package lk.hasi.labbookingsystem.controller;

import lk.hasi.labbookingsystem.dto.TestResultDTO;
import lk.hasi.labbookingsystem.entity.TestResult;
import lk.hasi.labbookingsystem.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    // Save operation
    @PostMapping("/testResult")
    public TestResultDTO saveTestResult(
            @RequestBody TestResult test)
    {
        return testResultService.addNewTestResult(test);
    }

    // Read operation
    @GetMapping("/testResult")
    public List<TestResultDTO> fetchTestResultList()
    {
        return testResultService.fetchAll();
    }

    // Update operation
    @PutMapping("/testResult/{id}")
    public TestResultDTO
    updateTest(@RequestBody TestResult test,
               @PathVariable("id") Integer testId)
    {
        return testResultService.updateTestResultDetails(test, testId);
    }

    // Delete operation
    @DeleteMapping("/testResult/{id}")
    public String deleteTestResultById(@PathVariable("id")
                                 Integer testId)
    {
        testResultService.removeTestDetails(
                testId);
        return "Deleted Successfully";
    }
}
