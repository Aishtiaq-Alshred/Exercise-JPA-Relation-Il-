package com.example.jparelationi.Service;


import com.example.jparelationi.ApiResponse.ApiException;
import com.example.jparelationi.DTO.AddressDTO;
import com.example.jparelationi.Model.Address;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.AddressRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAddress(){

        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiException("Teacher id not found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuilding_number(),teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiException("address id not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuilding_number());

        addressRepository.save(address);
    }


    public void deleteAddress(Integer id){

        Address address = addressRepository.findAddressById(id);
        Teacher teacher = teacherRepository.findTeacherById(id);

        if(address==null){
            throw new ApiException("address id not found");
        }

        teacher.setAddress(null);
        addressRepository.delete(address);
    }



}
