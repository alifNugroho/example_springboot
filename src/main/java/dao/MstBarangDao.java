package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstBarang;
import entity.MstBarangPK;

public interface MstBarangDao extends JpaRepository<MstBarang, MstBarangPK> {
	@Query("select a from MstBarang a")
	public List<MstBarang> findAllBarang();
	
	@Query("select a,b.namaSupplier from MstBarang a, MstSupplier b where a.kodeSupplier = b.kodeSupplier")
	public List<Object[]> findAllWhitJoinBarang();
	
	@Query("select a,b.namaSupplier from MstBarang a, MstSupplier b where a.kodeSupplier = b.kodeSupplier and a.kodeBarang like %:Id%")
	public List<Object[]> findAllWhitJoinSerchBarang(@Param("Id") String kode);

}
