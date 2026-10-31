import java.util.Arrays;
import java.util.Scanner;

public class StudentsRecords{
    public static void main(String[]args){
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!!=> WELCOME TO LAGBAJA SCHOOL RECORDS <=!!!");
        System.out.println("_=_=> WHICH GRADE'S RECORD DO YOU WISH TO CREATE: <=_=_"); 
            int grade =  scanner.nextInt();
            
        System.out.println("Number of students please: ");
            int numberOfStudents = scanner.nextInt();
        System.out.println("Saved--->");
            
        System.out.println("Number of subjects taken please");
            int numberOfSubjects = scanner.nextInt();
        System.out.println("Saved--->");
                                
        System.out.printf("_=_=> CREATING GRADE %d RECORDS SHEET <=_=_",grade);
            System.out.println("");
            
            int [][] recordBook = new int [numberOfStudents][numberOfSubjects + 3];
             for (int index = 0 ; index < numberOfStudents; index++){
                        int i = index + 1;
                        System.out.printf("NEW STUDENT: STUDENT %d", i);  
                        System.out.println("");
                 for(int index_a = 0; index_a < numberOfSubjects; index_a++){
                            System.out.println("ENTER STUDENTS SUBJECT SCORE"); 
                                int score = scanner.nextInt();
                            while (score < 0 || score > 100){
                                System.out.println("invalid score");
                                System.out.println("ENTER STUDENTS SUBJECT SCORE");
                                score = scanner.nextInt();
                                }
                            recordBook [index][index_a] = score;                         
                }
             }
        
        
        for (int index = 0 ; index < numberOfStudents; index++){
                 int total = 0;
                 for(int index_a = 0; index_a < numberOfSubjects; index_a++){
                     total += recordBook[index][index_a];                               
                }
                 recordBook[index][numberOfSubjects] = total; 
             }
        
        double [] averages = new double [numberOfStudents];
        for (int index = 0 ; index < numberOfStudents; index++){
                 double average = recordBook[index][numberOfSubjects] / (double) numberOfSubjects;                                
                 averages[index] = average;
              }       
             
        for (int index = 0 ; index < numberOfStudents; index++){
                 int position = 1;
                 for (int index_a = 0 ; index_a < numberOfStudents; index_a++){
                     if (recordBook[index_a][numberOfSubjects] > recordBook[index][numberOfSubjects]){
                         position++;
                     }
                 }
                 recordBook[index][numberOfSubjects + 2] = position;
             }
                    
             
             System.out.println("=======================================================================");
             System.out.printf("Class%d|",grade);
             
        for( int index = 1; index <= numberOfSubjects; index++){
           System.out.printf(" \t subject%d \t ", index);      
        }
        System.out.println(" \t TOT \t AVE \t POS");
        System.out.println("=======================================================================");

        for (int index = 0 ; index < numberOfStudents; index++){
                 System.out.printf("Student %d |", index + 1);
                 for(int index_a = 0; index_a < numberOfSubjects; index_a++){
                     System.out.printf(" \t %d \t ", recordBook[index][index_a]);
                 }
                 System.out.printf(" \t %d \t %.2f \t %d%n", recordBook[index][numberOfSubjects], averages[index], recordBook[index][numberOfSubjects + 2]);
             }
        System.out.println("=======================================================================");
        System.out.println("=======================================================================");

        System.out.println("SUBJECT SUMMARY");
        int [] passes = new int [numberOfSubjects];
        int [] fails = new int [numberOfSubjects];
        int overallHighest = recordBook[0][0];
        int overallHighestStudent = 0;
        int overallHighestSubject = 0;
        int overallLowest = recordBook[0][0];
        int overallLowestStudent = 0;
        int overallLowestSubject = 0;

        for (int index_a = 0 ; index_a < numberOfSubjects; index_a++){
                 int highest = recordBook[0][index_a];
                 int highestStudent = 0;
                 int lowest = recordBook[0][index_a];
                 int lowestStudent = 0;
                 int subjectTotal = 0;

                 for (int index = 0 ; index < numberOfStudents; index++){
                     int mark = recordBook[index][index_a];
                     subjectTotal += mark;

                     if (mark > highest){
                         highest = mark;
                         highestStudent = index;
                     }
                     if (mark < lowest){
                         lowest = mark;
                         lowestStudent = index;
                     }
                     if (mark >= 50){
                         passes[index_a]++;
                     }
                     else{
                         fails[index_a]++;
                     }
                 }

                 if (highest > overallHighest){
                     overallHighest = highest;
                     overallHighestStudent = highestStudent;
                     overallHighestSubject = index_a;
                 }
                 if (lowest < overallLowest){
                     overallLowest = lowest;
                     overallLowestStudent = lowestStudent;
                     overallLowestSubject = index_a;
                 }

                 System.out.printf("Subject %d%n", index_a + 1);
                 System.out.printf("Highest scoring student is: Student %d scoring %d%n", highestStudent + 1, highest);
                 System.out.printf("Lowest scoring student is: Student %d scoring %d%n", lowestStudent + 1, lowest);
                 System.out.printf("Total score is: %d%n", subjectTotal);
                 System.out.printf("Average score is: %.2f%n", subjectTotal / (double) numberOfStudents);
                 System.out.printf("Number of passes: %d%n", passes[index_a]);
                 System.out.printf("Number of fails: %d%n", fails[index_a]);
                 System.out.println("");
             }

        int hardest = 0;
        int easiest = 0;
        for (int index_a = 1 ; index_a < numberOfSubjects; index_a++){
                 if (fails[index_a] > fails[hardest]){
                     hardest = index_a;
                 }
                 if (passes[index_a] > passes[easiest]){
                     easiest = index_a;
                 }
             }
        System.out.printf("The hardest subject is Subject %d with %d failures%n", hardest + 1, fails[hardest]);
        System.out.printf("The easiest subject is Subject %d with %d passes%n", easiest + 1, passes[easiest]);
        System.out.printf("The overall highest score is scored by Student %d in subject %d scoring %d%n", overallHighestStudent + 1, overallHighestSubject + 1, overallHighest);
        System.out.printf("The overall lowest score is scored by Student %d in subject %d scoring %d%n", overallLowestStudent + 1, overallLowestSubject + 1, overallLowest);
        System.out.println("=======================================================================");

        int bestStudent = 0;
        int worstStudent = 0;
        int classTotal = 0;
        for (int index = 0 ; index < numberOfStudents; index++){
                 classTotal += recordBook[index][numberOfSubjects];
                 if (recordBook[index][numberOfSubjects] > recordBook[bestStudent][numberOfSubjects]){
                     bestStudent = index;
                 }
                 if (recordBook[index][numberOfSubjects] < recordBook[worstStudent][numberOfSubjects]){
                     worstStudent = index;
                 }
             }

        System.out.println("");
        System.out.println("CLASS SUMMARY");
        System.out.println("=======================================================================");
        System.out.printf("Best graduating student is: Student %d scoring %d%n", bestStudent + 1, recordBook[bestStudent][numberOfSubjects]);
        System.out.println("=======================================================================");
        System.out.println("");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.printf("Worst graduating student is: Student %d scoring %d%n", worstStudent + 1, recordBook[worstStudent][numberOfSubjects]);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("");
        System.out.println("=======================================================================");
        System.out.printf("Class total score is: %d%n", classTotal);
        System.out.printf("Class average score is: %.1f%n", classTotal / (double) numberOfStudents);
        System.out.println("=======================================================================");
        System.out.println("THANK YOU FOR USING OUR RECORD SYSTEM!\\(O-O)/");
        
 }
} 
