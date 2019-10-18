package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstBarangSvc;
import service.MstCustomerSvc;
import service.TrHeaderPenjualanSvc;
import dto.MstBarangDto;
import dto.MstBarangJoinDto;
import dto.MstCustomerDto;
import dto.MstCustomerJoinDto;
import dto.TrHeaderPenjualanAllDto;
import dto.TrHeaderPenjualanDto;

public class TesService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");		
		TrHeaderPenjualanSvc svc = ctx.getBean(TrHeaderPenjualanSvc.class);
		List<TrHeaderPenjualanDto> list = svc.findAllWhitJoinTrHeaderPenjualan();
		for(TrHeaderPenjualanDto dto : list){
			System.out.println("Nota : " + dto.getNoNota());
			System.out.println("namaHeader  : " + dto.getNamaHeader());
			System.out.println("namaKaryawan : " + dto.getNamaKaryawan());
			System.out.println("TanggalTransaksi : " + dto.getTanggalTransaksi());
			System.out.println("HargaTotal : " + dto.getHargaTotal());
		
//		TrHeaderPenjualanAllDto br = new TrHeaderPenjualanAllDto();
//		br.setNoNota("M032");
//		br.setKodeCustomer("C002");
//		br.setKodeKaryawan("K004");
//		br.setTanggalTransaksi(Date.valueOf("2019-10-22"));
//		br.setGlobalDiskon(10);
//		br.setHargaTotal(10);
//		svc.save(br);
		

		}}}


