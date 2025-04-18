package lk.ijse.project.mentalhealthterapycenter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
public class User implements SuperEntity {
    @Id
    private String userID;
    private String userFullName;
    private String userEmail;
    private String userRole;
    private String userName;
    private String userPassword;
}
