package model;

import java.util.Objects;

public class Quiz {

    private int quizId;
    private String quizName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return quizId == quiz.quizId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId);
    }
}
