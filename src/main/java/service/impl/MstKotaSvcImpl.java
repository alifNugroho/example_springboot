package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MstCustomerDao;
import dao.MstKotaDao;
import dto.MstBarangDto;
import dto.MstBarangJoinDto;
import dto.MstKotaDto;
import dto.MstKotaJoinDto;
import entity.MstBarang;
import entity.MstKaryawan;
import entity.MstKaryawanPK;
import entity.MstKota;
import entity.MstKotaPK;
import service.MstKotaSvc;

@Service
@Transactional

public class MstKotaSvcImpl implements MstKotaSvc{
	
	@Autowired
	private MstKotaDao dao;

	@Override
	public List<MstKotaDto> findAllKota() {
		// TODO Auto-generated method stub
		List<MstKota> list = dao.findAllKota();
		List<MstKotaDto> dtos = new ArrayList<>();
		for(MstKota m : list){
			MstKotaDto dto = new MstKotaDto();
			dto.setKodeKota(m.getKodeKota());
			dto.setKodeProvinsi(m.getKodeProvinsi());
			dto.setNamaKota(m.getNamaKota());
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstKotaDto dto) {
		// TODO Auto-generated method stub
		MstKota kt = new MstKota();
		kt.setKodeKota(dto.getKodeKota());
		kt.setKodeProvinsi(dto.getKodeProvinsi());
		kt.setNamaKota(dto.getNamaKota());
		dao.save(kt);
		
	}

	@Override
	public void update(MstKotaDto dto) {
		// TODO Auto-generated method stub
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(dto.getKodeKota());
		MstKota kt = dao.findOne(pk);
		kt.setKodeKota(dto.getKodeKota());
		kt.setKodeProvinsi(dto.getKodeProvinsi());
		kt.setNamaKota(dto.getNamaKota());
		dao.save(kt);
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(Id);
		dao.delete(pk);
		
	}

	@Override
	public List<MstKotaJoinDto> findAllWhitJoinKota() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllWhitJoinKota();
		List<MstKotaJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstKotaJoinDto dto = new MstKotaJoinDto();
			MstKota m = (MstKota) o[0];
			String nKota = (String)o[1];
			dto.setKodeKota(m.getKodeKota());
			dto.setKodeProvinsi(m.getKodeProvinsi());
			dto.setNamaKota(m.getNamaKota());
			dto.setNamaProvinsi(nKota);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public List<MstKotaJoinDto> findAllWhitJoinSerchKota(String Id) {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllWhitJoinSerchKota(Id);
		List<MstKotaJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstKotaJoinDto dto = new MstKotaJoinDto();
			MstKota m = (MstKota) o[0];
			String nKota = (String)o[1];
			dto.setKodeKota(m.getKodeKota());
			dto.setKodeProvinsi(m.getKodeProvinsi());
			dto.setNamaKota(m.getNamaKota());
			dto.setNamaProvinsi(nKota);
			dtos.add(dto);
		}
		return dtos;
	}

}
