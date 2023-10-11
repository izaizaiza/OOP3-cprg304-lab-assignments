import java.util.Comparator;

public class Student implements Comparable<Student>{
    /*
     * the Student class implements both Comparable and Comparator interfaces
     * create a compareTo method by the Comparable Interface to compare students by name
     * create a compare method by the Comparator Interface to compare students based on their age.
     * if their age is equal then compare by name
     * to test, create a list of student objects and sort it using Collections sort method.
     */


    //fields
    private String name;
    private int age;

    //constructors
    public Student(){}

    public Student(String aName, int anAge){
        this.name = aName;
        this.age = anAge;
    }

    //getters and setters
    public int getAge() {
        return this.age;
    }

    public void setAge(int anAge) {
        this.age = anAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName){
        this.name = aName;
    }


    //methods
    @Override
    public int compareTo(Student anotherStudent){
        // returns a negative if this student's name precedes anotherStudent alpabetically A>B...,
        // returns a 0 if the two names are the same
        // returns a positive if this student's name is after anotherStudent ex. D < C
        return this.getName().compareTo(anotherStudent.getName());
    }



}// end of Student class
