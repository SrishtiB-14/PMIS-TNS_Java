package OOPs;

class StudentProfile{
	
	String name;
	int id;
	double score;
	
	
	public StudentProfile(String name, int id, double score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}


	public StudentProfile(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	void grade(double score) {
		
		if(score >= 90) {
			System.out.println("Your grade is A");
		}else if(score <= 89 && score >= 75) {
			System.out.println("Your grade is B");
		}else if(score <= 74 && score >= 50) {
			System.out.println("Your grade is C");
		}else {
			System.out.println("Your grade is F");
		}
	}
	
	
	void reportCard() {
		System.out.println("Student Name: "+ name);
		System.out.println("Student ID: "+ id);
		System.out.println("Student score: "+ score);
		grade(score);
	}
	
	
	
}

public class Academy {
	public static void main(String[] args) {
		
		StudentProfile s1 = new StudentProfile("Anushka",101,82.5);
		s1.reportCard();
		
		System.out.println("----------------------------");
		
		StudentProfile s2 = new StudentProfile("Shravni",205);
		s2.reportCard();
		
	}

}
