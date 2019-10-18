package service;

import java.util.List;

import dto.TrDetailPenjualanAllDto;
import dto.TrDetailPenjualanDto;

public interface TrDetailPenjualanSvc {
	public List<TrDetailPenjualanDto> findAllWhitJoinDetailPenjualan();
	public void save (TrDetailPenjualanAllDto dto);
	public void update (TrDetailPenjualanAllDto dto);
	public void delete (String Id);

}
