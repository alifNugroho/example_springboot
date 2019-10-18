package common;

import java.util.List;

public class RestResponse {
	private int status;
	private String massege;
	private Object data;
	private List<String> err;
	
	public List<String> getErr() {
		return err;
	}
	public void setErr(List<String> err) {
		this.err = err;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMassege() {
		return massege;
	}
	public void setMassege(String massege) {
		this.massege = massege;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	

}
