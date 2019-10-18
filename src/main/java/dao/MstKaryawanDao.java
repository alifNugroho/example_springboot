package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;

import entity.MstKaryawan;
import entity.MstKaryawanPK;

public interface MstKaryawanDao extends JpaRepository<MstKaryawan, MstKaryawanPK> {
	@Query("select a from MstKaryawan a")
	public List<MstKaryawan> findAllKaryawan();
	
	@Query("select a from MstKaryawan a where kodeKaryawan like %:Id%")
	public List<MstKaryawan> findAllWhitSerchKaryawan(@Param("Id") String Id);

}
