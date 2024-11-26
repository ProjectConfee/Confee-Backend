
//
//package com.backend.confee.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin
//@Entity
//@Table(name = "stalls")
//@Getter
//@Setter
//public class Stall_sp {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private long stallId;
//
//    private String stallName;
//    private String sponsorId;
//
//
//}
//package com.backend.confee.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin
//@Entity
//@Table(name = "stalls")
//@Getter
//@Setter
//public class Stall_sp {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private long stallId;
//
//    private String stallType;  // Added field for stall type (e.g., main or sub)
//    private String stallNumber;  // Added field for stall number
//    private String sponsorId;
//
////    // Optionally, if you want to keep stallName as a derived field:
////    @Transient  // This will not be persisted in the database
////    private String stallName;
////
////    @PostLoad
////    @PostPersist
////    @PostUpdate
////    private void setStallName() {
////        this.stallName = stallType + " " + stallNumber;
////    }
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

    private String stallType;
    private String stallNumber;
    private String sponsorId;

    @Transient
    private String stallName;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void setStallName() {
        this.stallName = stallType + " " + stallNumber;
    }
}
