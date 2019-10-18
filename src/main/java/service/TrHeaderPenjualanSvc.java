package service;

import java.util.List;

import dto.TrHeaderPenjualanAllDto;
import dto.TrHeaderPenjualanDto;

public interface TrHeaderPenjualanSvc {
	public List<TrHeaderPenjualanDto> findAllWhitJoinTrHeaderPenjualan();
	public void save (TrHeaderPenjualanAllDto dto);
	public void update (TrHeaderPenjualanAllDto dto);
	public void delete (String Id);

}
