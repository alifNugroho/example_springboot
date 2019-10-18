package service;

import java.util.List;

import dto.MstCustomerDto;
import dto.MstCustomerJoinDto;


public interface MstCustomerSvc {
	public List<MstCustomerDto> findAllCustomer();
	public List<MstCustomerJoinDto> findAllWhitJoinCustomer();
	public List<MstCustomerJoinDto> findAllWhitJoinSerchCustomer(String Id);
	public void save (MstCustomerDto dto);
	public void update (MstCustomerDto dto);
	public void delete (String Id);

}
