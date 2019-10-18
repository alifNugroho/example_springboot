package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.TrDetailPenjualan;
import entity.TrDetailPenjualanPK;

public interface TrDetailPenjualanDao extends JpaRepository<TrDetailPenjualan, TrDetailPenjualanPK> {
	@Query("select a, b.namaBarang, c.noNota from TrDetailPenjualan a, MstBarang b, TrHeaderPenjualan c where a.kodeBarang = b.kodeBarang and a.noNota = c.noNota")
	public List<Object[]> findAllWhitJoinDetailPenjualan();

}
