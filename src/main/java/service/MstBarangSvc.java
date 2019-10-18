package service;

import java.util.List;

import dto.MstBarangDto;
import dto.MstBarangJoinDto;


public interface MstBarangSvc {
	
	public List<MstBarangDto> findAllBarang();
	public List<MstBarangJoinDto> findAllWhitJoinBarang();
	public List<MstBarangJoinDto> findAllWhitJoinSerchBarang(String kode);
	public void save (MstBarangDto dto);
	public void update (MstBarangDto dto);
	public void delete (String Id);

}
