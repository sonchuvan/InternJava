package teacherSM;

import teacherSM.subject.Subject;
import teacherSM.teacher.GSTS;
import teacherSM.teacher.GVC;
import teacherSM.teacher.PGSTS;
import teacherSM.teacher.Teacher;

public class Service {

    public static void main(String[] args) {
        Teacher teacher = new GSTS("1","1","1");
        Teacher teacher1 = new PGSTS("1","1","1");
        Teacher teacher2 = new GVC("1","1","1");
        Teacher teacher3 = new GSTS("1","1","1");
        System.out.println(teacher.toString());
        System.out.println(teacher1.toString());

        System.out.println(teacher2.toString());
        System.out.println(teacher3.toString());

        Subject subject1 = new Subject();
        Subject subject2 = new Subject();
        Subject subject3 = new Subject();
        Subject subject4 = new Subject();

        System.out.println(subject1.toString());
        System.out.println(subject2.toString());
        System.out.println(subject3.toString());
        System.out.println(subject4.toString());


    }
}
