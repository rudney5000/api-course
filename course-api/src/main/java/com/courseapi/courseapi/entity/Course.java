package com.courseapi.courseapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String content;
    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToMany
    @JoinTable(name = "COUCAT",
            joinColumns = @JoinColumn(name = "Category_ID"),
            inverseJoinColumns = @JoinColumn(name = "Course_ID"))
    private List<Category> categories;

//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
//    private List<Category> categories;
    public Course(String name, String content) {
        this.name = name;
        this.content = content;
    }

}
