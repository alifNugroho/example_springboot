package service;

import java.util.List;

import dto.MstKaryawanDto;



public interface MstKaryawanSvc {
	public List<MstKaryawanDto> findAllKaryawan();
	public List<MstKaryawanDto> findAllWhitSerchKaryawan(String Id);
	public void save (MstKaryawanDto dto);
	public void update (MstKaryawanDto dto);
	public void delete (String Id);

}
