package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;

import entity.MstSupplier;
import entity.MstSupplierPK;

public interface MstSupplierDao extends JpaRepository<MstSupplier, MstSupplierPK> {
	@Query("select a from MstSupplier a")
	public List<MstSupplier> findAllSupplier();
	
	@Query("select a,b.namaKota from MstSupplier a, MstKota b where a.kodeKota = b.kodeKota")
	public List<Object[]> findAllWhitJoin();
	
	@Query("select a,b.namaKota from MstSupplier a, MstKota b where a.kodeKota = b.kodeKota and a.kodeSupplier like %:Id%")
	public List<Object[]> findAllWhitJoinSerch(@Param("Id") String Id);

}
