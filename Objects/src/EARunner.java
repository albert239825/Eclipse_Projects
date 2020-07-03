import java.util.Scanner;

import java.util.*;
import java.text.*;
public class EARunner
{

    public static void main (String [] args){
        Student s = null;
        Faculty f = new Faculty();

        Scanner sc=new Scanner(System.in);
        System.out.println("Type S for Student or F for faculty: ");
        String in = sc.nextLine();

        System.out.println("Enter Full Name: ");
        String name = sc.nextLine();

        System.out.println("Enter birthday MM/DD/YYYY: ");
        String birthday = sc.nextLine();
        


        if(in.equalsIgnoreCase("s")){

            System.out.println("Enter Grad Year: ");
            int grad = sc.nextInt();
            
            s = new Student(grad, name, birthday);
            
            System.out.println(s.createUsername());
            System.out.println(s.getAge());

            //initialize the Student object
            //update Student class so that 
            //createUsername and age methods called from constructor
            // print username and age to the screen
            
            
        }
        
        else{
        	f.setDOB(birthday);     
        	f.setName(name);
        	
            System.out.println(f.createUsername());
            System.out.println(f.getAge());
        }


    }
}