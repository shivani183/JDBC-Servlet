package dto;

import java.io.Serializable;

public class Politics implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer pid;
	private String pname;
	private Integer pexpert;
	private String pparty;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPexpert() {
		return pexpert;
	}
	public void setPexpert(Integer pexpert) {
		this.pexpert = pexpert;
	}
	public String getPparty() {
		return pparty;
	}
	public void setPparty(String pparty) {
		this.pparty = pparty;
	}
	@Override
	public String toString() {
		return "Politics [pid=" + pid + ", pname=" + pname + ", pexpert=" + pexpert + ", pparty=" + pparty + "]";
	}

	
}
