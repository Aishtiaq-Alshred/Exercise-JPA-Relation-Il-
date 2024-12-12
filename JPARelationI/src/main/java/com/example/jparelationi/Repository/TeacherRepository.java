package com.example.jparelationi.Repository;

import com.example.jparelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {


    Teacher findTeacherById(Integer id);
}
