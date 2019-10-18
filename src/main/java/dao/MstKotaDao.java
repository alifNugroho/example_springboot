package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstKota;
import entity.MstKotaPK;

public interface MstKotaDao extends JpaRepository<MstKota, MstKotaPK> {
	@Query("select a from MstKota a")
	public List<MstKota> findAllKota();
	
	@Query("select a,b.namaProvinsi from MstKota a, MstProvinsi b where a.kodeProvinsi = b.kodeProvinsi")
	public List<Object[]> findAllWhitJoinKota();
	
	@Query("select a,b.namaProvinsi from MstKota a, MstProvinsi b where a.kodeProvinsi = b.kodeProvinsi and a.kodeKota like %:Id%")
	public List<Object[]> findAllWhitJoinSerchKota(@Param("Id") String Id);
	
	

}
