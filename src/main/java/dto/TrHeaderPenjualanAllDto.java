package dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

public class TrHeaderPenjualanAllDto {
	private String noNota;
	private String kodeCustomer;
	private String kodeKaryawan;
	private Date tanggalTransaksi;
	private int globalDiskon;
	private int hargaTotal;
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public String getKodeKaryawan() {
		return kodeKaryawan;
	}
	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	public int getGlobalDiskon() {
		return globalDiskon;
	}
	public void setGlobalDiskon(int globalDiskon) {
		this.globalDiskon = globalDiskon;
	}
	public int getHargaTotal() {
		return hargaTotal;
	}
	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}
	
	
	
}
