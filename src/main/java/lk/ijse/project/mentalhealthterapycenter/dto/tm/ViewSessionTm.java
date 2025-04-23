package lk.ijse.project.mentalhealthterapycenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewSessionTm {
    private String sessionID;
    private String sessionDate;
    private String sessionNotes;
    private String sessionTime;
    private String doctorID;
    private List<String> programID;
    private String patientName;
    private String paymentID;
    private Double paymentAmount;
    private String paymentMethod;
    private String appointmentStatus;
}
