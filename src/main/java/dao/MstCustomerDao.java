package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstCustomer;
import entity.MstCustomerPK;

public interface MstCustomerDao extends JpaRepository<MstCustomer, MstCustomerPK> {
	@Query("select a from MstCustomer a")
	public List<MstCustomer> findAllCustomer();
	
	@Query("select a,b.namaKota from MstCustomer a, MstKota b where a.kodeKota = b.kodeKota")
	public List<Object[]> findAllWhitJoinCustomer();
	
	@Query("select a,b.namaKota from MstCustomer a, MstKota b where a.kodeKota = b.kodeKota and a.kodeCustomer like %:Id%")
	public List<Object[]> findAllWhitJoinSerchCustomer(@Param("Id") String Id);

}
