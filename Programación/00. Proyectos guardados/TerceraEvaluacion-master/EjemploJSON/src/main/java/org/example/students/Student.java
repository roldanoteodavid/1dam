package org.example.students;

import java.util.HashSet;
import java.util.Set;

public class Student{
        private long studentId;
        private String studentName;
        private Set<Phone> studentPhoneNumbers = new HashSet<>(0);

    public Student(int id, String studentName) {
        this.studentId = id;
        this.studentName = studentName;
    }

    public long getStudentId() {
            return studentId;
        }

        public void setStudentId(long studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public Set <Phone> getStudentPhoneNumbers() {
            return studentPhoneNumbers;
        }

        public void setStudentPhoneNumbers(Set <Phone> studentPhoneNumbers) {
            this.studentPhoneNumbers = studentPhoneNumbers;
        }

        @Override
        public String toString() {
            return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPhoneNumbers=" +
                    studentPhoneNumbers + "]";
        }

    }
