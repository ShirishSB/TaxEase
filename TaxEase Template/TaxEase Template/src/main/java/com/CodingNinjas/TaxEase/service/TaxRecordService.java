package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.exception.TaxRecordNotFoundException;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import com.CodingNinjas.TaxEase.repository.TaxRecordRepository;

import java.util.List;
import java.util.Optional;

import javax.script.Bindings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaxRecordService {

    /*
        This is the service class for TaxRecord, you need to complete the class by doing the following:

            a. Use appropriate annotations.
            b. Complete the methods given below.
            c. Autowire the necessary dependencies.
     */
	@Autowired
	TaxRecordRepository taxRecordRepository;


    // This is the service method for the api which allows user to get a tax Record by sending the record id
    public TaxRecord getTaxRecordById(Long id) throws TaxRecordNotFoundException{
    	if(taxRecordRepository.existsById(id)) {
    	TaxRecord taxRecord = taxRecordRepository.getById(id);
    	return taxRecord;
    	}
    	throw new TaxRecordNotFoundException("Tax record not found with ID: " + id);
    }


    // This is the service method for the api which allows user fetch all tax Records
    public List<TaxRecord> getAllRecords(Long id) {
        return taxRecordRepository.findAll();
    }


    // This is the service method for the api which allows user to create a tax Record by sending TaxRecordDto as the @ResponseBody
    public void createTaxRecord(TaxRecordDto taxRecordDto) {
    	TaxRecord taxRecord = new TaxRecord();
    	taxRecord.setUserName(taxRecordDto.getUserName());
    	taxRecord.setIncome(taxRecordDto.getIncome());
    	taxRecord.setTaxYear(taxRecordDto.getTaxYear());
    	taxRecord.setDeductions(taxRecordDto.getDeductions());
    	taxRecord.setFilingApproved(false);
    	taxRecordRepository.save(taxRecord);
    }


    // This is the service method for the api which allows user to update a tax Record by sending the record id as a pathVariable and TaxRecordDto as a RequestBody
    public void updateTaxRecord(TaxRecordDto taxRecordDto, Long id) {
    	TaxRecord taxRecord = taxRecordRepository.getById(id);
    	taxRecord.setUserName(taxRecordDto.getUserName());
    	taxRecord.setTaxYear(taxRecordDto.getTaxYear());
    	taxRecord.setIncome(taxRecordDto.getIncome());
    	taxRecord.setDeductions(taxRecordDto.getDeductions());
    }


    // This is the service method for the api which allows user to delete a tax Record by sending the record id as a pathVariable
    public void deleteTaxRecord(Long id) {
    	TaxRecord taxRecord = taxRecordRepository.getById(id);
    	taxRecordRepository.delete(taxRecord);
    }


    // This is the service method for the api which allows user to fetch all the tax Records by sending the username as a requestParam
    public List<TaxRecord> getRecordsByName(String userName) {
    	List<TaxRecord> list = taxRecordRepository.findByUserName(userName);
        return list;
    }


    // This is the service method for the api which allows user to approve a tax Record by sending the record id as a pathVariable
    public void approveTaxFiling(Long id) {
    	TaxRecord taxRecord = taxRecordRepository.getById(id);
    	taxRecord.setFilingApproved(true);
    }


    // This is the service method for the api which allows user to reject a tax Record by sending the record id as a pathVariable
    public void rejectTaxFiling(Long id) {
    	TaxRecord taxRecord = taxRecordRepository.getById(id);
    	taxRecord.setFilingApproved(false);

    }
}
