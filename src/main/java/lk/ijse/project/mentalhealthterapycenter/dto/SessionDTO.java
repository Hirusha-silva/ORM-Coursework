package lk.ijse.project.mentalhealthterapycenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    private String sessionId;
    private String patient_ID;
    private String therapist_ID;
    private String time;
    private String notes;
    private String date;
}
