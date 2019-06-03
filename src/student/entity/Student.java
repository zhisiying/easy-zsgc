package student.entity;

public class Student {
	private int snumber;
	private String sname;

	private int sage;
	private String saddress;
	
	public Student() {
	
	}
	
	public Student(String sname,  int sage, String saddress) {
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	
	
	public Student(int snumber,String sname,  int sage, String saddress) {
		
		this.sname = sname;
		this.snumber = snumber;
		this.sage = sage;
		this.saddress = saddress;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSnumber() {
		return snumber;
	}
	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getSnumber()+"--"+this.getSname()+"--"+this.getSage()+"--"+this.getSaddress();
	}
}
	