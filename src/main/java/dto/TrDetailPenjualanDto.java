package dto;


public class TrDetailPenjualanDto {
	
	private String noNota;
	private String kodeDetail;
	private String namaBarang;
	private int hargaSatuan;
	private int qty;
	private int diskon;
	private int subtotal;
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public String getKodeDetail() {
		return kodeDetail;
	}
	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public int getHargaSatuan() {
		return hargaSatuan;
	}
	public void setHargaSatuan(int hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
