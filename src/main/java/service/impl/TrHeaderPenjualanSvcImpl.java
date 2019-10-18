package service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.TrHeaderPenjualanDao;
import dto.TrHeaderPenjualanAllDto;
import dto.TrHeaderPenjualanDto;
import entity.TrHeaderPenjualan;
import entity.TrHeaderPenjualanPK;
import service.TrHeaderPenjualanSvc;

@Service
@Transactional
public class TrHeaderPenjualanSvcImpl implements TrHeaderPenjualanSvc {
	
	@Autowired
	private TrHeaderPenjualanDao dao;

	@Override
	public List<TrHeaderPenjualanDto> findAllWhitJoinTrHeaderPenjualan() {
		List<Object[]> list = dao.findAllWhitJoinTrHeaderPenjualan();
		List<TrHeaderPenjualanDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
			TrHeaderPenjualan tr = (TrHeaderPenjualan) o[0];
			String nCustomer = (String)o[1];
			String nKaryawan = (String)o[2];
			dto.setNoNota(tr.getNoNota());
			dto.setNamaHeader(nCustomer);
			dto.setNamaKaryawan(nKaryawan);
			dto.setTanggalTransaksi(tr.getTanggalTransaksi());
			dto.setHargaTotal(tr.getHargaTotal());
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public void save(TrHeaderPenjualanAllDto dto) {
		TrHeaderPenjualan tr = new TrHeaderPenjualan();
		tr.setNoNota(dto.getNoNota());
		tr.setKodeCustomer(dto.getKodeCustomer());
		tr.setKodeKaryawan(dto.getKodeKaryawan());
		tr.setTanggalTransaksi(dto.getTanggalTransaksi());
		tr.setGlobalDiskon(dto.getGlobalDiskon());
		tr.setHargaTotal(dto.getHargaTotal());
		dao.save(tr);
	}
	@Override
	public void update(TrHeaderPenjualanAllDto dto) {
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(dto.getNoNota());
		TrHeaderPenjualan tr = dao.findOne(pk);
		tr.setKodeCustomer(dto.getKodeCustomer());
		tr.setKodeKaryawan(dto.getKodeKaryawan());
		tr.setTanggalTransaksi(dto.getTanggalTransaksi());
		tr.setGlobalDiskon(dto.getGlobalDiskon());
		tr.setHargaTotal(dto.getHargaTotal());
		dao.save(tr);
	}
	@Override
	public void delete(String Id) {
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(Id);
		dao.delete(pk);
		
	}

}
