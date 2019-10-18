package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;

import entity.MstKaryawan;
import entity.MstProvinsi;
import entity.MstProvinsiPK;

public interface MstProvinsiDao extends JpaRepository<MstProvinsi, MstProvinsiPK> {
	@Query("select a from MstProvinsi a")
	public List<MstProvinsi> findAllProvinsi();
	
	@Query("select a from MstProvinsi a where kodeProvinsi like %:Id%")
	public List<MstProvinsi> findAllWhitSerchProvinsi(@Param("Id") String Id);

}
