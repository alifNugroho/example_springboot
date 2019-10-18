package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.RestResponse;
import dao.MstBarangDao;
import dao.MstSupplierDao;
import dto.MstBarangDto;
import dto.MstBarangJoinDto;
import dto.MstSupplierDto;
import entity.MstSupplier;
import service.MstBarangSvc;
import service.MstSupplierSvc;

@RestController
@RequestMapping(value="/barang")
public class MstBarangCtl {
	
	@Autowired
	private MstBarangSvc svc;
	@Autowired
	private MstSupplierSvc vcs;

	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<MstBarangDto>> findAllBarang(){
		List<MstBarangDto> list = svc.findAllBarang();
		return new ResponseEntity<List<MstBarangDto>>(list,HttpStatus.OK);
	}
	@RequestMapping(value="/findall", method = RequestMethod.GET)
	public RestResponse findAll(){
		RestResponse response = new RestResponse();
		try{
			List<MstBarangDto> list = svc.findAllBarang();
			response.setStatus(1);
			response.setMassege("berhasil");
			response.setData(list);
		}catch(Exception ee){
			response.setStatus(0);
			response.setMassege("error");
		}
		return response;
	}
	
//	@RequestMapping(value="/cari",method = RequestMethod.GET)
//	public RestResponse findAllBySearch(@RequestParam(value="search",defaultValue="",required=false) String search){
//		RestResponse response = new RestResponse();
//		try{
//			List<MstBarangJoinDto> list = svc.findAllWhitJoinSerchBarang(search);
//			response.setStatus(1);
//			response.setMassege("berhasil");
//			response.setData(list);
//			
//		}catch(Exception ee){
//			response.setStatus(0);
//			response.setMassege("error");
//			
//		}
//		
//		return response;
//		
//	}
	
	@RequestMapping(value="/cari/{search}",method = RequestMethod.GET)
	public RestResponse findAllBySearch(@PathVariable("search") String cari){
		RestResponse response = new RestResponse();
		try{
			List<MstBarangJoinDto> list = svc.findAllWhitJoinSerchBarang(cari);
			response.setStatus(1);
			response.setMassege("berhasil");
			response.setData(list);
		}catch(Exception ee){
			response.setStatus(0);
			response.setMassege("error");
		}
		return response;
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public RestResponse save(@RequestBody MstBarangDto dto){
		RestResponse response = new RestResponse();
		try{
			List<String> listerror = ValidateKode(dto);
			response.setErr(listerror);
			if(listerror.size() > 0){
				response.setMassege("data Gagal di masukan");
				response.setStatus(0);
			}
			else{
			svc.save(dto);
			response.setStatus(1);
			response.setMassege("Berhasil insert data");
			response.setData(dto);
			}
		}catch(Exception ee){
			response.setStatus(0);
			response.setMassege("Error");
		}
		return  response;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public RestResponse update(@RequestBody MstBarangDto dto){
		RestResponse response = new RestResponse();
		try{
			List<String> listerror = ValidateKode(dto);
			response.setErr(listerror);
			if(listerror.size() > 0){
				response.setMassege("data Gagal di masukan");
				response.setStatus(0);
			}else{
				svc.update(dto);
				response.setStatus(1);
				response.setMassege("Berhasil update data");
				response.setData(dto);
			}
		}catch(Exception ee){
			response.setStatus(0);
			response.setMassege("Data yang di update tidak tersedia");
		}
		return  response;
	}
	
	@RequestMapping(value="/delete/{search}",method = RequestMethod.DELETE)
	public RestResponse delete(@PathVariable("search") String cari){
		RestResponse response = new RestResponse();
		try{
			svc.delete(cari);
			response.setStatus(1);
			response.setMassege("Berhasil insert data");
			
		}catch(Exception ee){
			response.setStatus(0);
			response.setMassege("Data yang ingin  dihapus tidak ada");
		}
		return  response;
	}
	
	public List<String> ValidateKode(MstBarangDto dto ){
		List<String> errors = new ArrayList<String>();
		if(dto.getKodeBarang().length() > 5 ){
			errors.add("Kode Barang Maximal 5 Karakter");
		}
		if(dto.getKodeBarang().isEmpty()){
			errors.add("Kode barang belum dimasukkan");
		}
		if(dto.getNamaBarang().length() > 5){
			errors.add("Nama Barang Maximal 5 Karakter");
		}
		if(dto.getNamaBarang().isEmpty()){
			errors.add("Kode barang belum dimasukkan");
		}
		if(dto.getStokBarang()  > 1000){
			errors.add("maximal seribu");
		}
		if(vcs.findAllWhitJoinSerchSupplier(dto.getKodeSupplier()).size()==0){
			errors.add("kode baranga tidak sama dengan kode");
			
		}
		return errors;
	}
	
	
	
	

}
