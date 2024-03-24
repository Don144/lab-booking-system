package lk.hasi.labbookingsystem.controller;

import lk.hasi.labbookingsystem.dto.TestDto;
import lk.hasi.labbookingsystem.entity.Test;
import lk.hasi.labbookingsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    // Save operation
    @PostMapping("/test")
    public TestDto saveTest(
             @RequestBody Test test)
    {
        return testService.addNewTest(test);
    }

    // Read operation
    @GetMapping("/test")
    public List<TestDto> fetchTestList()
    {
        return testService.fetchAll();
    }

    // Update operation
    @PutMapping("/test/{id}")
    public Test
    updateTest(@RequestBody Test test,
                     @PathVariable("id") Integer testId)
    {
        return testService.updateTestDetails(test, testId);
    }

    // Delete operation
    @DeleteMapping("/test/{id}")
    public String deleteTestById(@PathVariable("id")
                                       Integer testId)
    {
        testService.removeTestDetails(
                testId);
        return "Deleted Successfully";
    }
}
