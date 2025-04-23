package lk.ijse.project.mentalhealthterapycenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientInEveryProgramTm {
    String patientId;
    String patientName;
    String patientAddress;
    String patientContact;
}
