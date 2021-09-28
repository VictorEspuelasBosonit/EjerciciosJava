//package com.example.jpa.infraestructure.domain.Materia;
//
//import com.example.jpa.infraestructure.domain.Estudiante.Student;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.time.Instant;
//import java.util.List;
//
//@Entity
//@Data
//@Table(name = "StudentMatter")
//@NoArgsConstructor
//@AllArgsConstructor
//public class StudentMatter {
//
//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    String id_matter;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "students_get_studentMatter",
//            joinColumns = {@JoinColumn(name="id_studentMatter")},
//            inverseJoinColumns = {@JoinColumn(name = "id_students")}
//    )
//    List<Student> students;
//
//    @Column(nullable = false)
//    String matter;
//
//    @Column(nullable = false)
//    String comments;
//
//    @Column(nullable = false)
//    Date initial_date = (Date) Date.from(Instant.now());
//
//    @Column(nullable = false)
//    Date finish_date;
//
//
//}
