package dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

public class TrHeaderPenjualanDto {
	private String noNota;
	private String namaHeader;
	private String namaKaryawan;
	private Date tanggalTransaksi;
	private int hargaTotal;
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public String getNamaHeader() {
		return namaHeader;
	}
	public void setNamaHeader(String namaHeader) {
		this.namaHeader = namaHeader;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	public int getHargaTotal() {
		return hargaTotal;
	}
	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}
	
	
	
	

}
