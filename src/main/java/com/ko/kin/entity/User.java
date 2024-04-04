package com.ko.kin.entity;

import com.ko.kin.enums.UserRank;
import com.ko.kin.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String nickname;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;
    private int adopted_answer;

    @Enumerated(EnumType.STRING)
    private UserRank user_rank;

    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

//    public void addQuestion(Question question) {
//        questions.add(question);
//        question.setUser(this);
//    }
//
//    public void addAnswer(Answer answer) {
//        answers.add(answer);
//        answer.setUser(this);
//    }

}
