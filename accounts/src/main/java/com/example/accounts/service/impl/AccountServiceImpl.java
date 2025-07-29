package com.example.accounts.service.impl;

import com.example.accounts.constants.AccountsConstants;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.entity.Accounts;
import com.example.accounts.entity.Customers;
import com.example.accounts.exceptions.CustomerAlreadyExistException;
import com.example.accounts.mapper.CustomerMapper;
import com.example.accounts.repository.AccountsRepo;
import com.example.accounts.repository.CustomerRepo;
import com.example.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@Data
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountsRepo accountsRepo;
    @Autowired
    private CustomerRepo customerRepo;
    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customers customers= CustomerMapper.mapToCustomer(new Customers(),customerDto);
        Optional<Customers> optionalCustomers=customerRepo.findByContactNo(customerDto.getContactNo());
        if(optionalCustomers.isPresent()){
            throw new CustomerAlreadyExistException("Customer Already Existing with given mobile Number:"+customerDto.getContactNo());
        }
        customers.setCreatedAt(LocalDateTime.now());
        customers.setCreatedBy("SomeOne!");
        Customers savedCustomer=customerRepo.save(customers);
        accountsRepo.save(createNewAccount(savedCustomer));
    }
    private Accounts createNewAccount(Customers customers){
        Accounts newAccount=new Accounts();
        newAccount.setCustomerId(customers.getCustomerId());
        int randomAccNumber=10000000+new Random().nextInt(9000000);
        newAccount.setAccountNo(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("SomeOne!");
        return newAccount;
    }
}
