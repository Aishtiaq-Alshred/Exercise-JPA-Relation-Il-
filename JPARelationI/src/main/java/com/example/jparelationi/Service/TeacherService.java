package com.example.jparelationi.Service;

import com.example.jparelationi.ApiResponse.ApiException;
import com.example.jparelationi.Model.Address;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class TeacherService {

        private final TeacherRepository teacherRepository;


        public List<Teacher> getTeachers(){

            return teacherRepository.findAll();
        }


        public void addTeacher(Teacher teacher){

            teacherRepository.save(teacher);
        }


        public void updateTeacher(Integer id , Teacher teacher){
            Teacher teacher1 = teacherRepository.findTeacherById(id);
            if(teacher1==null){
                throw new ApiException("Teacher id not found");
            }
            teacher1.setName(teacher.getName());
            teacher1.setAge(teacher.getAge());
            teacher1.setEmail(teacher.getEmail());
            teacher1.setSalary(teacher.getSalary());
            teacherRepository.save(teacher1);
        }


        public void deleteTeacher(Integer id){
            Teacher teacher=teacherRepository.findTeacherById(id);
            if(teacher==null){
                throw new ApiException("Teacher id not found");
            }
            teacherRepository.delete(teacher);
        }

        public Address allTeacherDetails(Integer id){
            Teacher teacher = teacherRepository.findTeacherById(id);
            if(teacher==null){
                throw new ApiException("Teacher id not found");
            }
            if(teacher.getAddress()==null){
                throw new ApiException("address not found");
            }

            return teacher.getAddress();
        }
}
