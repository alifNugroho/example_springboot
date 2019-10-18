package service;

import java.util.List;




import dto.MstKotaDto;
import dto.MstKotaJoinDto;

public interface MstKotaSvc {
	public List<MstKotaDto> findAllKota();
	public List<MstKotaJoinDto> findAllWhitJoinKota();
	public List<MstKotaJoinDto> findAllWhitJoinSerchKota(String Id);
	public void save (MstKotaDto dto);
	public void update (MstKotaDto dto);
	public void delete (String Id);

}
