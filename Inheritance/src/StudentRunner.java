import java.util.Scanner;

public class StudentRunner{
    
	
    public static void main (String [] args){
    	Student s = new Upper("Davis Dictator Davis", 2023);
    	Student s1 = new Student("Bob", 2023);
    	Student s2 = new Upper("Alyson", 2023);
    	Student s3 = new Middle("Sammy", 2026);
    	Employee e = new Employee("jimmy Bit");
    	
    	System.out.println(s.assetTag());
    	System.out.println(e.assetTag());
    	
    	((Upper) s2).beard();
    	((Upper) s2).thunderDome();
    	
//        Student s;
//        Scanner sc=new Scanner(System.in);
//       int currYear = 2019;
//    
//        System.out.println("Enter your name.");
//        String name = sc.next();
//    
//        System.out.println("Enter your Graduation Year.");
//        int y = sc.nextInt();
//    
//            if((y - currYear) <= 4){
//                //upper school
//                s = new Upper(name, y);
//                System.out.println("Upper");
//            }
//            else if((y-currYear) <= 8){
//                //middle school
//                 s = new Middle(name, y);
//                 System.out.println("Middle");
//            }
//            else {
//            	s = new Lower(name,y);
//            	System.out.println("Lower");
//            }
//    
//        s.getChapel();
//        s.getLunch();
        //System.out.println(s.lunchInfo());
        
          //Upper u = new Upper("Timmy", 2018);
          //Student su = new Student("Timmy", 2018);
          //System.out.println(su.getSS());//su.ss --> this won't work
    
    }

    
}