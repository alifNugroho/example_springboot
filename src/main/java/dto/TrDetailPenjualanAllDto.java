package dto;


public class TrDetailPenjualanAllDto {
	private String kodeDetail;
	private String kodeBarang;
	private int qty;
	private int hargaSatuan;
	private int diskon;
	private int subtotal;
	public String getKodeDetail() {
		return kodeDetail;
	}
	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getHargaSatuan() {
		return hargaSatuan;
	}
	public void setHargaSatuan(int hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}
	public int getDiskon() {
		return diskon;
	}
	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
