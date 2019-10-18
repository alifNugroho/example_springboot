package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MstBarangDao;
import dto.MstBarangDto;
import dto.MstBarangJoinDto;
import entity.MstBarang;
import entity.MstBarangPK;
import service.MstBarangSvc;

@Service
@Transactional
public class MstBarangSvcImpl implements MstBarangSvc {
	
	@Autowired
	private MstBarangDao dao;

	@Override
	public List<MstBarangDto> findAllBarang() {
		// TODO Auto-generated method stub
		List<MstBarang> list = dao.findAllBarang();
		List<MstBarangDto> dtos = new ArrayList<>();
		for(MstBarang m : list){
			MstBarangDto dto = new MstBarangDto();
			dto.setKodeBarang(m.getKodeBarang());
			dto.setKodeSupplier(m.getKodeSupplier());
			dto.setNamaBarang(m.getNamaBarang());
			dto.setStokBarang(m.getStokBarang());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstBarangDto dto) {
		// TODO Auto-generated method stub
		MstBarang br = new MstBarang();
		br.setKodeBarang(dto.getKodeBarang());
		br.setKodeSupplier(dto.getKodeSupplier());
		br.setNamaBarang(dto.getNamaBarang());
		br.setStokBarang(dto.getStokBarang());
		dao.save(br);
		
	}

	@Override
	public void update(MstBarangDto dto) {
		// TODO Auto-generated method stub
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(dto.getKodeBarang());
		MstBarang barang = dao.findOne(pk);
		barang.setKodeSupplier(dto.getKodeSupplier());
		barang.setNamaBarang(dto.getNamaBarang());
		barang.setStokBarang(dto.getStokBarang());
		dao.save(barang);
		
	}

	@Override
	public void delete(String Id) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(Id);
		dao.delete(pk);
		
	}

	@Override
	public List<MstBarangJoinDto> findAllWhitJoinBarang() {
		List<Object[]> list = dao.findAllWhitJoinBarang();
		List<MstBarangJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstBarangJoinDto dto = new MstBarangJoinDto();
			MstBarang m = (MstBarang) o[0];
			String nSuplier = (String)o[1];
			dto.setKodeBarang(m.getKodeBarang());;
			dto.setKodeSupplier(m.getKodeSupplier());
			dto.setNamaBarang(m.getNamaBarang());
			dto.setStokBarang(m.getStokBarang());
			dto.setNamaSupplier(nSuplier);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public List<MstBarangJoinDto> findAllWhitJoinSerchBarang(String kode) {
		List<Object[]> list = dao.findAllWhitJoinSerchBarang(kode);
		List<MstBarangJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstBarangJoinDto dto = new MstBarangJoinDto();
			MstBarang m = (MstBarang) o[0];
			String nSuplier = (String)o[1];
			dto.setKodeBarang(m.getKodeBarang());;
			dto.setKodeSupplier(m.getKodeSupplier());
			dto.setNamaBarang(m.getNamaBarang());
			dto.setStokBarang(m.getStokBarang());
			dto.setNamaSupplier(nSuplier);
			dtos.add(dto);
			
		}
		return dtos;
	}

}
