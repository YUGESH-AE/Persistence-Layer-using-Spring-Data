package com.demo;

import com.demo.dto.CustomerDto;
import com.demo.entity.Customer;
import com.demo.enumentity.CustomerType;
import com.demo.service.customerServiceImpl;
import com.demo.repository.Data_JPA.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PersistenceLayerUsingSpringDataApplication implements CommandLineRunner {

static Logger logger= LogManager.getLogger(PersistenceLayerUsingSpringDataApplication.class);

static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(PersistenceLayerUsingSpringDataApplication.class, args);
	}

	@Autowired
	customerServiceImpl customerService;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {

		CustomerDto a1=new CustomerDto(1,"ravi@gmail","ravi", LocalDate.of(1999,8,20), CustomerType.GOLD);
		CustomerDto a2=new CustomerDto(2,"raj@gmail","raj", LocalDate.of(1999,4,20), CustomerType.PLATINUM);
		CustomerDto a3=new CustomerDto(3,"suman@gmail","suman", LocalDate.of(1999,5,20), CustomerType.GOLD);
		CustomerDto a4=new CustomerDto(4,"sanjay@gmail","sanjay", LocalDate.of(1999,1,20), CustomerType.SILVER);
		CustomerDto a5=new CustomerDto(5,"shyam@gmail","shyam", LocalDate.of(1999,9,20), CustomerType.PLATINUM);
		CustomerDto a6=new CustomerDto(6,"tanu@gmail","tanu", LocalDate.of(1999,10,20), CustomerType.SILVER);
		CustomerDto a7=new CustomerDto(7,"manu@gmail","manu", LocalDate.of(1999,12,20), CustomerType.GOLD);

		try{
			/*
			inserting record orm
			 */
//			logger.info(customerService.insert(a1));
//			logger.info(customerService.insert(a2));
//			logger.info(customerService.insert(a3));
//			logger.info(customerService.insert(a4));
//			logger.info(customerService.insert(a5));
//			logger.info(customerService.insert(a6));
//			logger.info(customerService.insert(a7));

			/*
			updating record orm
			 */
//			logger.info("Enter the customer id which needs to be updated");
//			Integer custid=scanner.nextInt();
//			logger.info("Enter the name which needs to be updated");
//			String name=scanner.next();
//			logger.info("Enter the email id which needs to be updated");
//			String email=scanner.next();
//			logger.info(customerService.update(custid,name,email));

			/*
			delete record orm
			 */
//			logger.info("Enter the customer id which needs to be deleted");
//			Integer cust=scanner.nextInt();
//			int result=customerService.delete(cust);
//			if(result>0){
//				logger.info("Records succesfully deleted");
//			}
//			else {
//				logger.info("Invalid");
//			}

			/*
			fetching record orm
//			 */
//			List<CustomerDto>cust=customerService.getAll();
//			for (CustomerDto i:cust
//				 ) {
//				logger.info(i);
//			}

			/*
			Spring Data JPA Implementations
			 */

			/*
			inserting records
			 */
//			logger.info(customerService.insert(a1));
//			logger.info(customerService.insert(a2));
//			logger.info(customerService.insert(a3));
//			logger.info(customerService.insert(a4));
//			logger.info(customerService.insert(a5));
//			logger.info(customerService.insert(a6));
//			logger.info(customerService.insert(a7));

			/*
			updating records
			 */
//			logger.info("Enter the customer id which needs to be updated");
//			Integer customer1ID=scanner.nextInt();
//			CustomerDto v=new CustomerDto();
//			v.setCustomerId(customer1ID);
//			logger.info("Enter the name");
//			String cname=scanner.next();
//			v.setName(cname);
//			logger.info("Enter the emailID");
//			String cemail=scanner.next();
//			v.setEmailId(cemail);
//			v.setDateOfBirth(LocalDate.of(1999,8,20));
//			v.setCustomerType(CustomerType.PLATINUM);
//			logger.info(customerService.update(v,customer1ID));

			/*
			deleting record
			 */
//			logger.info("Enter the Customer id which needs to be deleted");
//			Integer custIDNO=scanner.nextInt();
//			int result=customerService.delete(custIDNO);
//			if(result>0){
//				logger.info("Record deleted successfully");
//			}
//			else {
//				logger.info("NO record found");
//			}

			/*
			fetching all record
			 */
//			List<Customer>cust=customerService.getall();
//			for(Customer i:cust){
//				logger.info(i);
//			}

			/*
			Pagination  & Sorting
			 */
//			int k=(int)(customerRepository.count()/3);
//			for(int i=0;i<=k;i++){
//				Sort sort=Sort.by("name").ascending();
//				Pageable pageable= PageRequest.of(i,3,sort);
//				logger.info("Records in page:{}",i);
//				Iterable<Customer>customers8= customerService.findAll(pageable);
//				for (Customer v:customers8){
//					logger.info(v);
//				}
//			}


//			logger.info(" Sorted records: ");
//
//			Iterable<Customer>customers9= customerService.findAll(Sort.by(Sort.Direction.ASC,"name"));
//			for (Customer n:customers9){
//				logger.info(n);
//			}




			scanner.close();
		}catch (DataAccessException e){
			logger.info(e.getMessage());
		}
	}
}
