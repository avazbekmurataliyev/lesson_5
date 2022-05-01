package com.start.appspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    Integer id ;
    String model ;
    String macAddress ;
    String phoneNumber ;

}
