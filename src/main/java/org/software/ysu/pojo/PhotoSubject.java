package org.software.ysu.pojo;

import lombok.Data;

/**
 * @description 用以前台成果展示的包装类
 */
@Data
public class PhotoSubject {
    private Photograph photograph;
    private String subjectName;
    private String subjectTeacher;
    private String subjectStudents;

    public Photograph getPhotograph() {
        return photograph;
    }

    public void setPhotograph(Photograph photograph) {
        this.photograph = photograph;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public String getSubjectStudents() {
        return subjectStudents;
    }

    public void setSubjectStudents(String subjectStudents) {
        this.subjectStudents = subjectStudents;
    }
}
