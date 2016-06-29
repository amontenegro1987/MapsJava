package tests;

public class Student extends Person{
	public Student(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public boolean isAsleep(int hr)//Override
	{ return 2 < hr && 8 >hr;

}
	public static void main(String[]args){
		Person p = new Student("Sally");
		p.status(1);
				
	}
}
