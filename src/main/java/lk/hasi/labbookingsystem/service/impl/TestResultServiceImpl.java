package lk.hasi.labbookingsystem.service.impl;

import lk.hasi.labbookingsystem.dto.TestResultDTO;
import lk.hasi.labbookingsystem.entity.TestResult;
import lk.hasi.labbookingsystem.repo.TestResultRepository;
import lk.hasi.labbookingsystem.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private TestResultRepository testResultRepository;


    @Override
    public TestResultDTO addNewTestResult(TestResult testResult) {
        try{
            TestResultDTO testResultDTO = new TestResultDTO();
            TestResult result = testResultRepository.save(testResult);
            testResultDTO.setId(result.getId());
            testResultDTO.setResult_url(result.getResult_url());
            testResultDTO.setDoctorName(result.getDoctors().getDoctor_name());
            testResultDTO.setPatient_name(result.getPatient().getName());
            testResultDTO.setPatient_email(result.getPatient().getEmail());
            testResultDTO.setPatient_address(result.getPatient().getAddress());
            testResultDTO.setTechnicians_id(result.getTechnicians().getTech_id());
            testResultDTO.setTechnicians_name(result.getTechnicians().getTech_name());

            return testResultDTO;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TestResultDTO> fetchAll() {
        try{
            List<TestResultDTO> testResultDTOS =new ArrayList<>();
            List<TestResult> result = testResultRepository.findAll();
            if(!result.isEmpty()){
                for(TestResult testResult: result){
                    TestResultDTO testResultDTO = new TestResultDTO();
                    testResultDTO.setId(testResult.getId());
                    testResultDTO.setTechnicians_id(testResult.getTechnicians().getTech_id());
                    testResultDTO.setResult_url(testResult.getResult_url());
                    testResultDTO.setPatient_name(testResult.getPatient().getName());
                    testResultDTO.setPatient_email(testResult.getPatient().getEmail());
                    testResultDTO.setPatient_address(testResult.getPatient().getAddress());
                    testResultDTO.setDoctorName(testResult.getDoctors().getDoctor_name());
                    testResultDTO.setTechnicians_name(testResult.getTechnicians().getTech_name());

                    testResultDTOS.add(testResultDTO);
                }
                return testResultDTOS;
            }
            return null;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public TestResultDTO updateTestResultDetails(TestResult testResult, Integer testId) {
        return null;
    }

    @Override
    public void removeTestDetails(Integer testId) {
        try{
            testResultRepository.deleteById(testId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
