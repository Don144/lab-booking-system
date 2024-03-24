package lk.hasi.labbookingsystem.service.impl;

import lk.hasi.labbookingsystem.dto.TestDto;
import lk.hasi.labbookingsystem.entity.Test;
import lk.hasi.labbookingsystem.repo.TestRepository;
import lk.hasi.labbookingsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public TestDto addNewTest(Test test) {
        try{
            TestDto testDto = new TestDto();
            Test retsultTest = testRepository.save(test);
            testDto.setTest_name(retsultTest.getTest_name());
            testDto.setTest_category(retsultTest.getTest_category());
            testDto.setAvaliable(retsultTest.getAvaliable());
//            testDto.setTechniciansDTO(retsultTest.getTechnicians());

            return null;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TestDto> fetchAll() {
        try{
            List<TestDto> testDtoList =new ArrayList<>();
            List<Test> result = testRepository.findAll();
            if(!result.isEmpty()){
                for(Test test: result){
                    TestDto testDto = new TestDto();
                    testDto.setId(test.getId());
                    testDto.setTest_category(test.getTest_category());
                    testDto.setTest_name(test.getTest_name());
                    testDto.setAvaliable(test.getAvaliable());

                    testDtoList.add(testDto);
                }
                return testDtoList;
            }
            return null;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public List<TestDto> fetchAvailableTests(Boolean available) {
        try{
            List<TestDto> testDtoList =new ArrayList<>();
            List<Test> result = testRepository.findAllByAvaliableOrderByIdAsc(true);
            if(!result.isEmpty()){
              for(Test test: result){
                  TestDto testDto = new TestDto();
                  testDto.setTest_category(test.getTest_category());
                  testDto.setTest_name(test.getTest_name());
                  testDto.setId(test.getId());

                  testDtoList.add(testDto);
              }
              return testDtoList;
            }
            return null;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TestDto> fetchTestsFromTechnicians(Integer tech_id) {
        try{
            List<TestDto> testDtoList =new ArrayList<>();
            List<Test> result = testRepository.findAll();
            if(!result.isEmpty()){
                for(Test test: result){
                    TestDto testDto = new TestDto();
                    if(Objects.equals(test.getTechnicians().getTech_id(), tech_id)){
                        testDto.setId(test.getId());
                        testDto.setTest_category(test.getTest_category());
                        testDto.setTest_name(test.getTest_name());

                        testDtoList.add(testDto);
                    }
                }
                return testDtoList;
            }
            return null;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public Test updateTestDetails(Test test, Integer testId) {
        try{
            Test tests = testRepository.findById(testId).get();

            if(Objects.nonNull(test.getTest_name()) && !"".equalsIgnoreCase(test.getTest_name())){
                tests.setTest_name(test.getTest_name());
            }

            if(Objects.nonNull(test.getTest_category()) && !"".equalsIgnoreCase(test.getTest_category())){
                tests.setTest_category(test.getTest_category());
            }

            if(Objects.nonNull(test.getAvaliable())){
                tests.setAvaliable(test.getAvaliable());
            }

           return testRepository.save(tests);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeTestDetails(Integer testId) {
        testRepository.deleteById(testId);
    }
}
