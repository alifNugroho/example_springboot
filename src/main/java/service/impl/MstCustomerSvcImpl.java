package service.impl;

import java.util.ArrayList;
import java.util.List;












import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MstBarangDao;
import dao.MstCustomerDao;
import dto.MstBarangJoinDto;
import dto.MstCustomerDto;
import dto.MstCustomerJoinDto;
import entity.MstBarang;
import entity.MstBarangPK;
import entity.MstCustomer;
import entity.MstCustomerPK;
import service.MstCustomerSvc;

@Service
@Transactional


public class MstCustomerSvcImpl implements MstCustomerSvc {
	
	@Autowired
	private MstCustomerDao dao;

	@Override
	public List<MstCustomerDto> findAllCustomer() {
		// TODO Auto-generated method stub
		List<MstCustomer> list = dao.findAllCustomer();
		List<MstCustomerDto> dtos = new ArrayList<>();
		for(MstCustomer m : list){
			MstCustomerDto dto = new MstCustomerDto();
			dto.setKodeCustomer(m.getKodeCustomer());
			dto.setAlamatCustomer(m.getAlamatCustomer());
			dto.setEmailCustomer(m.getEmailCustomer());
			dto.setJenisKelamin(m.getJenisKelamin());
			dto.setKodeKota(m.getKodeKota());
			dto.setNamaCustomer(m.getNamaCustomer());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstCustomerDto dto) {
		// TODO Auto-generated method stub
		MstCustomer cs = new MstCustomer();
		cs.setKodeCustomer(dto.getKodeCustomer());
		cs.setAlamatCustomer(dto.getAlamatCustomer());
		cs.setEmailCustomer(dto.getEmailCustomer());
		cs.setJenisKelamin(dto.getJenisKelamin());
		cs.setKodeKota(dto.getKodeKota());
		cs.setNamaCustomer(dto.getNamaCustomer());
		dao.save(cs);
		
	}

	@Override
	public void update(MstCustomerDto dto) {
		// TODO Auto-generated method stub
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(dto.getKodeCustomer());
		MstCustomer cs = dao.findOne(pk);
		cs.setAlamatCustomer(dto.getAlamatCustomer());
		cs.setEmailCustomer(dto.getEmailCustomer());
		cs.setJenisKelamin(dto.getJenisKelamin());
		cs.setKodeKota(dto.getKodeKota());
		cs.setNamaCustomer(dto.getNamaCustomer());
		dao.save(cs);
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(Id);
		dao.delete(pk);
		
	}

	@Override
	public List<MstCustomerJoinDto> findAllWhitJoinCustomer() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllWhitJoinCustomer();
		List<MstCustomerJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstCustomerJoinDto dto = new MstCustomerJoinDto();
			MstCustomer m = (MstCustomer) o[0];
			String nKota = (String)o[1];
			dto.setKodeCustomer(m.getKodeCustomer());
			dto.setAlamatCustomer(m.getAlamatCustomer());
			dto.setEmailCustomer(m.getEmailCustomer());
			dto.setJenisKelamin(m.getJenisKelamin());
			dto.setNamaCustomer(m.getNamaCustomer());
			dto.setNamaKota(nKota);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public List<MstCustomerJoinDto> findAllWhitJoinSerchCustomer(String Id) {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllWhitJoinSerchCustomer(Id);
		List<MstCustomerJoinDto> dtos = new ArrayList<>();
		for(Object[] o : list){
			MstCustomerJoinDto dto = new MstCustomerJoinDto();
			MstCustomer m = (MstCustomer) o[0];
			String nKota = (String)o[1];
			dto.setKodeCustomer(m.getKodeCustomer());
			dto.setAlamatCustomer(m.getAlamatCustomer());
			dto.setEmailCustomer(m.getEmailCustomer());
			dto.setJenisKelamin(m.getJenisKelamin());
			dto.setNamaCustomer(m.getNamaCustomer());
			dto.setNamaKota(nKota);
			dtos.add(dto);
			
		}
		return dtos;
	}

}
