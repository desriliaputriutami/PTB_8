package com.example.a8.models;

public class Thesis{
    private Student student;
    private int studentId;
    private Object gradeBy;
    private String createdAt;
    private String jsonMemberAbstract;
    private String title;
    private String startAt;
    private int createdBy;
    private String updatedAt;
    private Object grade;
    private int id;
    private int topicId;
    private int status;

    public Student getStudent(){
        return student;
    }

    public int getStudentId(){
        return studentId;
    }

    public Object getGradeBy(){
        return gradeBy;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public String getJsonMemberAbstract(){
        return jsonMemberAbstract;
    }

    public String getTitle(){
        return title;
    }

    public String getStartAt(){
        return startAt;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public Object getGrade(){
        return grade;
    }

    public int getId(){
        return id;
    }

    public int getTopicId(){
        return topicId;
    }

    public int getStatus(){
        return status;
    }
}
