package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import dao.MstKaryawanDao;
import dto.MstKaryawanDto;
import entity.MstKaryawan;
import entity.MstKaryawanPK;
import service.MstKaryawanSvc;



public class MstKaryawanSvcImpl implements MstKaryawanSvc {
	
	@Autowired
	private MstKaryawanDao dao;

	@Override
	public List<MstKaryawanDto> findAllKaryawan() {
		List<MstKaryawan> list = dao.findAllKaryawan();
		List<MstKaryawanDto> dtos = new ArrayList<>();
		for(MstKaryawan m : list){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(m.getKodeKaryawan());
			dto.setNamaKaryawan(m.getNamaKaryawan());
			dto.setPassword(m.getPassword());
			dto.setUsername(m.getUsername());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstKaryawanDto dto) {
		// TODO Auto-generated method stub
		MstKaryawan kr = new MstKaryawan();
		kr.setKodeKaryawan(dto.getKodeKaryawan());
		kr.setNamaKaryawan(dto.getNamaKaryawan());
		kr.setPassword(dto.getPassword());
		kr.setUsername(dto.getUsername());
		dao.save(kr);
		
	}

	@Override
	public void update(MstKaryawanDto dto) {
		// TODO Auto-generated method stub
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(dto.getKodeKaryawan());
		MstKaryawan kr = dao.findOne(pk);
		kr.setNamaKaryawan(dto.getNamaKaryawan());
		kr.setPassword(dto.getPassword());
		kr.setUsername(dto.getUsername());
		dao.save(kr);
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(Id);
		dao.delete(pk);
		
	}

	@Override
	public List<MstKaryawanDto> findAllWhitSerchKaryawan(String Id) {
		// TODO Auto-generated method stub
		List<MstKaryawan> list = dao.findAllWhitSerchKaryawan(Id);
		List<MstKaryawanDto> dtos = new ArrayList<>();
		for(MstKaryawan m : list){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(m.getKodeKaryawan());
			dto.setNamaKaryawan(m.getNamaKaryawan());
			dto.setPassword(m.getPassword());
			dto.setUsername(m.getUsername());
			dtos.add(dto);
		}
		return dtos;
	}
	

}
