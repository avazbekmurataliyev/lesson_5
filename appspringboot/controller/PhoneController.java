package com.start.appspringboot.controller;

import com.start.appspringboot.model.Phone;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PhoneController {

    List<Phone> phoneList = new ArrayList<>(Arrays.asList(
            new Phone(1,"Iphone 5","222:222:2323:1122","+998931234567"),
            new Phone(2,"Realme ","333:111:2323:1122","+998937654321"),
            new Phone(3,"Redmi 5X","234:121:2323:1122","+998933212311"),
            new Phone(4,"Samsung A10","434:222:5453:1122","+998935437621")
    ));

    @RequestMapping(value = "/phone" , method = RequestMethod.GET)
    public List<Phone> getPhoneList(){

        return phoneList;

    }

    @RequestMapping(value = "/phone/{id}",method = RequestMethod.GET)
    public Phone getPhoneById(@PathVariable Integer id){

        for (Phone phone : phoneList) {
            if (phone.getId()==id)
                return phone;
        }

        return new Phone();
    }

    @RequestMapping(value = "/phone",method = RequestMethod.POST)
    public String savePhone(@RequestBody Phone phone){
    boolean check = false ;
        for (Phone phone1 : phoneList) {
            if (phone1.getMacAddress().equals(phone.getMacAddress()))
            {
                check = true ; break;
            }
        }
        if (!check){
            phone.setId(phoneList.get(phoneList.size()-1).getId()+1);
            phoneList.add(phone);
            return "Telefon qo`shildi";
        }

        return "Telefon mavjud,Mac adressni tekshiring ";
    }

    @RequestMapping(value = "/phone/{id}" , method = RequestMethod.PUT)
    public String updatePhone(@PathVariable Integer id,@RequestBody Phone phone){
        boolean check = false;
        for (Phone phone1 : phoneList) {

            if (phone1.getId() == id){

                for (Phone phone2 : phoneList) {

                    if (phone2.getMacAddress().equals(phone.getMacAddress())){
                        check = true ; break;
                    }

                }
                if (!check){
                    phone1.setPhoneNumber(phone.getPhoneNumber());
                    phone1.setModel(phone.getModel());
                    phone1.setMacAddress(phone.getMacAddress());
                    return "update phone";
                }
            }

        }

        return "update phone error";
    }

    @RequestMapping(value = "/phone/{id}",method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Integer id){
        for (Phone phone : phoneList) {
            if (phone.getId() == id) {
         phoneList.remove(phone);
                return "Malumotlar o`chdi";
            }
        }
        return "Phone not found";
    }
}
