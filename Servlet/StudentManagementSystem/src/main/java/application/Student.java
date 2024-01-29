package application;

public class Student {
	private int rollNo ;
	private String name ;
	private String dob ;
	private String degree ;
	private String stream ;
	private double percentage ;
	public Student() {
		
	}
	public Student(int rollNo, String name, String dob, String degree, String stream, double percentage) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.degree = degree;
		this.stream = stream;
		this.percentage = percentage;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getDob() {
		return dob;
	}
	public String getDegree() {
		return degree;
	}
	public String getStream() {
		return stream;
	}
	public double getPercentage() {
		return percentage;
	}
	
	
	
	
	
}
