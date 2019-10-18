package service;

import java.util.List;


import dto.MstProvinsiDto;

public interface MstProvinsiSvc {
	public List<MstProvinsiDto> findAllProvinsi();
	public List<MstProvinsiDto> findAllWhitSerchProvinsi(String Id);
	public void save (MstProvinsiDto dto);
	public void update (MstProvinsiDto dto);
	public void delete (String Id);

}
