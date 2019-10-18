package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MstKotaDao;
import dao.MstProvinsiDao;
import dto.MstKaryawanDto;
import dto.MstProvinsiDto;
import entity.MstKaryawan;
import entity.MstKaryawanPK;
import entity.MstProvinsi;
import entity.MstProvinsiPK;
import service.MstProvinsiSvc;

@Service
@Transactional
public class MstProvinsiSvcImpl implements MstProvinsiSvc {
	
	@Autowired
	private MstProvinsiDao dao;

	@Override
	public List<MstProvinsiDto> findAllProvinsi() {
		// TODO Auto-generated method stub
		List<MstProvinsi> list = dao.findAllProvinsi();
		List<MstProvinsiDto> dtos = new ArrayList<>();
		for(MstProvinsi m : list){
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(m.getKodeProvinsi());
			dto.setNamaProvinsi(m.getNamaProvinsi());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstProvinsiDto dto) {
		// TODO Auto-generated method stub
		
		MstProvinsi pr = new MstProvinsi();
		pr.setKodeProvinsi(dto.getKodeProvinsi());
		pr.setNamaProvinsi(dto.getNamaProvinsi());
		dao.save(pr);
		
	}

	@Override
	public void update(MstProvinsiDto dto) {
		// TODO Auto-generated method stub
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(dto.getKodeProvinsi());
		MstProvinsi pr = dao.findOne(pk);
		pr.setKodeProvinsi(dto.getKodeProvinsi());
		pr.setNamaProvinsi(dto.getNamaProvinsi());
		dao.save(pr);
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(Id);;
		dao.delete(pk);
		
	}

	@Override
	public List<MstProvinsiDto> findAllWhitSerchProvinsi(String Id) {
		// TODO Auto-generated method stub
		List<MstProvinsi> list = dao.findAllWhitSerchProvinsi(Id);
		List<MstProvinsiDto> dtos = new ArrayList<>();
		for(MstProvinsi m : list){
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(m.getKodeProvinsi());
			dto.setNamaProvinsi(m.getNamaProvinsi());
			dtos.add(dto);
		}
		return dtos;
	}

}
