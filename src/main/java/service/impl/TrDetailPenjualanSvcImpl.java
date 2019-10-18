package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TrDetailPenjualanDao;
import dao.TrHeaderPenjualanDao;
import dto.TrDetailPenjualanAllDto;
import dto.TrDetailPenjualanDto;
import dto.TrHeaderPenjualanDto;
import entity.TrDetailPenjualan;
import entity.TrDetailPenjualanPK;
import entity.TrHeaderPenjualan;
import entity.TrHeaderPenjualanPK;
import service.TrDetailPenjualanSvc;

@Service
@Transactional
public class TrDetailPenjualanSvcImpl implements TrDetailPenjualanSvc {

	@Autowired
	private TrDetailPenjualanDao dao;
	@Override
	public List<TrDetailPenjualanDto> findAllWhitJoinDetailPenjualan() {
		List<Object[]> list = dao.findAllWhitJoinDetailPenjualan();
		List<TrDetailPenjualanDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			TrDetailPenjualanDto dto = new TrDetailPenjualanDto();
			TrDetailPenjualan tr = (TrDetailPenjualan) o[0];
			String nBarang = (String)o[1];
			dto.setNoNota(tr.getNoNota());
			dto.setKodeDetail(tr.getKodeDetail());
			dto.setNamaBarang(nBarang);
			dto.setHargaSatuan(tr.getHargaSatuan());
			dto.setQty(tr.getQty());
			dto.setDiskon(tr.getDiskon());
			dto.setSubtotal(tr.getSubtotal());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(TrDetailPenjualanAllDto dto) {
		TrDetailPenjualan tr = new TrDetailPenjualan();
		tr.setKodeDetail(dto.getKodeDetail());
		tr.setKodeBarang(dto.getKodeBarang());
		tr.setQty(dto.getQty());
		tr.setHargaSatuan(dto.getHargaSatuan());
		tr.setDiskon(dto.getDiskon());
		tr.setSubtotal(dto.getSubtotal());
		dao.save(tr);
		
	}

	@Override
	public void update(TrDetailPenjualanAllDto dto) {
		TrDetailPenjualanPK pk = new TrDetailPenjualanPK();
		pk.setKodeDetail(dto.getKodeDetail());;
		TrDetailPenjualan tr = dao.findOne(pk);
		tr.setKodeBarang(dto.getKodeBarang());
		tr.setQty(dto.getQty());
		tr.setHargaSatuan(dto.getHargaSatuan());
		tr.setDiskon(dto.getDiskon());
		tr.setSubtotal(dto.getSubtotal());
		dao.save(tr);
		
	}

	@Override
	public void delete(String Id) {
		TrDetailPenjualanPK pk = new TrDetailPenjualanPK();
		pk.setKodeDetail(Id);
		dao.delete(pk);
	}

}
