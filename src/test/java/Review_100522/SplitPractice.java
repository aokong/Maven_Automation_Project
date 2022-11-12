package Review_100522;

public class SplitPractice {
    public static void main(String[] args) {

        String subjectLine = "Automation_AI05";
        String[] splitSubjectLine = subjectLine.split("I");
        System.out.println(splitSubjectLine[1]);
    }
}
