//package com.backend.confee.entity;

//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin
//@Entity
//@Table(name = "stalls")
//@Getter
//@Setter
//public class Stall_sp {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private long stallId;
//
//    private String stallName;
//    private String sponsorId;
//
//    public Object getstallName() {
//    }
//
//    public Object getsponsorId() {
//    }
//
//    public long getstallId() {
//    }
//
//    public long getStallId() {
//    }
//
//    public Object getStallName() {
//    }
//}

package com.backend.confee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
@Table(name = "stalls")
@Getter
@Setter
public class Stall_sp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long stallId;

    private String stallName;
    private String sponsorId;


}
