package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import dao.MstBarangDao;
import dto.MstBarangDto;
import entity.MstBarang;
import service.MstBarangSvc;


public class tes {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstBarangDao dao = ctx.getBean(MstBarangDao.class);
		MstBarang br = new MstBarang();
		br.setKodeBarang("br22");
		br.setKodeSupplier("sp12");
		br.setNamaBarang("orange water");
		br.setStokBarang(3);
		dao.save(br);

	}
}
