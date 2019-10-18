package service;

import java.util.List;

import dto.MstBarangDto;
import dto.MstBarangJoinDto;
import dto.MstSupplierDto;
import dto.MstSupplierJoinDto;

public interface MstSupplierSvc {
	public List<MstSupplierDto> findAllSupplier();
	public List<MstSupplierJoinDto> findAllWhitJoinSupplier();
	public List<MstSupplierJoinDto> findAllWhitJoinSerchSupplier(String kode);
	public void save (MstSupplierDto dto);
	public void update (MstSupplierDto dto);
	public void delete (String Id);

}
