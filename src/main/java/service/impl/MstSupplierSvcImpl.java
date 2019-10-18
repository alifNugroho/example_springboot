package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MstProvinsiDao;
import dao.MstSupplierDao;
import dto.MstBarangDto;
import dto.MstBarangJoinDto;
import dto.MstSupplierDto;
import dto.MstSupplierJoinDto;
import entity.MstBarang;
import entity.MstKaryawan;
import entity.MstKaryawanPK;
import entity.MstSupplier;
import entity.MstSupplierPK;
import service.MstSupplierSvc;

@Service
@Transactional
public class MstSupplierSvcImpl implements MstSupplierSvc {
	
	@Autowired
	private MstSupplierDao dao;

	@Override
	public List<MstSupplierDto> findAllSupplier() {
		// TODO Auto-generated method stub
		List<MstSupplier> list = dao.findAllSupplier();
		List<MstSupplierDto> dtos = new ArrayList<>();
		for(MstSupplier m : list){
			MstSupplierDto dto = new MstSupplierDto();
			dto.setKodeSupplier(m.getKodeSupplier());
			dto.setAlamatSupplier(m.getAlamatSupplier());
			dto.setEmailSupplier(m.getEmailSupplier());
			dto.setKodeKota(m.getKodeKota());
			dto.setNamaSupplier(m.getNamaSupplier());
			dto.setTelpSupplier(m.getTelpSupplier());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<MstSupplierJoinDto> findAllWhitJoinSupplier() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllWhitJoin();
		List<MstSupplierJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstSupplierJoinDto dto = new MstSupplierJoinDto();
			MstSupplier m = (MstSupplier) o[0];
			String nKota = (String)o[1];
			dto.setKodeSupplier(m.getKodeSupplier());
			dto.setAlamatSupplier(m.getAlamatSupplier());
			dto.setEmailSupplier(m.getEmailSupplier());
			dto.setKodeKota(m.getKodeKota());
			dto.setNamaSupplier(m.getNamaSupplier());
			dto.setTelpSupplier(m.getNamaSupplier());
			dto.setNamaKota(nKota);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public List<MstSupplierJoinDto> findAllWhitJoinSerchSupplier(String kode) {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllWhitJoinSerch(kode);
		List<MstSupplierJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstSupplierJoinDto dto = new MstSupplierJoinDto();
			MstSupplier m = (MstSupplier) o[0];
			String nKota = (String)o[1];
			dto.setKodeSupplier(m.getKodeSupplier());
			dto.setAlamatSupplier(m.getAlamatSupplier());
			dto.setEmailSupplier(m.getEmailSupplier());
			dto.setKodeKota(m.getKodeKota());
			dto.setNamaSupplier(m.getNamaSupplier());
			dto.setTelpSupplier(m.getNamaSupplier());
			dto.setNamaKota(nKota);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public void save(MstSupplierDto dto) {
		// TODO Auto-generated method stub
		MstSupplier sp = new MstSupplier();
		sp.setKodeSupplier(dto.getKodeSupplier());
		sp.setAlamatSupplier(dto.getAlamatSupplier());
		sp.setEmailSupplier(dto.getEmailSupplier());
		sp.setKodeKota(dto.getKodeKota());
		sp.setNamaSupplier(dto.getNamaSupplier());
		sp.setTelpSupplier(dto.getTelpSupplier());
		dao.save(sp);
		
	}

	@Override
	public void update(MstSupplierDto dto) {
		// TODO Auto-generated method stub
		
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(dto.getKodeSupplier());
		MstSupplier sp = dao.findOne(pk);
		sp.setAlamatSupplier(dto.getAlamatSupplier());
		sp.setEmailSupplier(dto.getEmailSupplier());
		sp.setKodeKota(dto.getKodeKota());
		sp.setNamaSupplier(dto.getNamaSupplier());
		sp.setTelpSupplier(dto.getTelpSupplier());
		dao.save(sp);
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(Id);
		dao.delete(pk);
		
	}

}
