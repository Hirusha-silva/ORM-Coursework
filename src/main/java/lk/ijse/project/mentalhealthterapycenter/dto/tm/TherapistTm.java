package lk.ijse.project.mentalhealthterapycenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TherapistTm {
    private String doctorID;
    private String doctorName;
    private String doctorQualifications;
    private String doctorAvailability;
    private String doctorPhone;
    private String doctorEmail;
}
