package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.TrHeaderPenjualan;
import entity.TrHeaderPenjualanPK;

public interface TrHeaderPenjualanDao extends JpaRepository<TrHeaderPenjualan, TrHeaderPenjualanPK> {
	@Query("select a,b.namaCustomer,c.namaKaryawan from TrHeaderPenjualan a, MstCustomer b, MstKaryawan c where a.kodeCustomer = b.kodeCustomer and a.kodeKaryawan = c.kodeKaryawan")
	public List<Object[]> findAllWhitJoinTrHeaderPenjualan();
}
