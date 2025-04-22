package lk.ijse.project.mentalhealthterapycenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TherapistDTO {
    private String doctorID;
    private String doctorName;
    private String doctorQualifications;
    private String doctorAvailability;
    private String doctorPhone;
    private String doctorEmail;
}
