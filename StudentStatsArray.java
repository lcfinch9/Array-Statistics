public class StudentStatsArray {

  // Add private final variable to hold Students array
  private final Student[] students;

  public StudentStatsArray(Student[] students) {
    // Constructor code
    this.students = students;
  }

  // Returns the average gpa of the students
  public double averageGpa() {
    double avg = 0;
    double sum = 0;
    for (Student stu : students) {
      sum += stu.getGpa();
    }
    avg = sum / students.length;
    return avg;
  }

  // Returns the gpa range of the students
  public double getGpaRange() {
    double min = 10.0;
    double max = 0.0;
    double[] arr = new double[students.length];
    for (int i = 0; i < students.length; i++) {
      arr[i] = students[i].getGpa();
    }
    for (double num: arr) {
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }
    return max - min;
  }

  // Returns the name of the student that has the longest length
  public String getLongestName() {
    String longest = "";
    String[] arr = new String[students.length];
    for (int i = 0; i < students.length; i++) {
      arr[i] = students[i].getName();
    }
    for (String name: arr) {
      if (name.length() > longest.length()) {
        longest = name;
      }
    }
    return longest;
  }

  // Returns a count of the number freshman students
  public int getNumFreshman() {
    int count = 0;
    int[] arr = new int[students.length];
    for (int i = 0; i < students.length; i++) {
      arr[i] = students[i].getYear();
    }
    for (int year: arr) {
      if (year == 1) {
        count++;
      }
    }
    return count;
  }

  // Returns the index of the first student with a name equal to name. 
  // Returns -1 if not found
  public int search(String name) {
    int found = -1;
    String[] arr = new String[students.length];
    for (int i = 0; i < students.length; i++) {
      arr[i] = students[i].getName();
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(name)) {
        found = i;
        break;
      }
    }
    return found;
  }

  // Returns the index of the first student with a gpa greater than or equal to the gpa
  // Returns -1 if not found
  public int search(double gpa) {
    int found = -1;
    double[] arr = new double[students.length];
    for (int i = 0; i < students.length; i++) {
      arr[i] = students[i].getGpa();
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= gpa) {
        found = i;
        break;
      }
    }
    return found;
  }

  // Returns 1 if the students are sorted in ascending order by their gpa; -1 if they
  // are sorted in descending order; 0 otherwise.
  public int sortStatus() {
    boolean ascending = true;
    boolean descending = true;
    
    double[] arr = new double[students.length];
    for (int i = 0; i < students.length; i++) {
      arr[i] = students[i].getGpa();
    }
    
    for (int i = 0; i < arr.length-1; i++){
      double num1 = arr[i];
      for (int j = i + 1; j < arr.length; j++){
        double num2 = arr[j];
        if (num1 < num2){
          descending = false;
        }
      }
    }
    
    for (int i = 0; i < arr.length-1; i++){
      double num1 = arr[i];
      for (int j = i + 1; j < arr.length; j++){
        double num2 = arr[j];
        if (num1 > num2){
          ascending = false;
        }
      }
    }
    
    if (ascending){
      return 1;
    }
    else if (descending){
      return -1;
    }
    return 0;
  }


  // Returns the array of students in JSON like format
  public String toString() {
    String out = "[\n";
    for (Student stu : students){
      out += stu + ",\n";
    }
    return out + "]";
  }

}