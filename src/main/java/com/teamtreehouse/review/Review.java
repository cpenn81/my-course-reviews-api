package com.teamtreehouse.review;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.course.Course;
import com.teamtreehouse.user.User;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review extends BaseEntity {

    @NotNull
    @Range(min = 0, max = 10)
    private int rating;

    @NotNull
    @Size(min = 2, max = 500)
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviewer;

    protected  Review(){
        super();
    }

    public Review(int rating, String description) {
        this();

        this.rating = rating;
        this.description = description;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
