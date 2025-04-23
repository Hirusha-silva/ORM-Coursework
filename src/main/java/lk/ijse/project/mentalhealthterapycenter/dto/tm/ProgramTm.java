package lk.ijse.project.mentalhealthterapycenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramTm {
    private String therapyID;
    private String therapyName;
    private String therapyDescription;
    private Double therapyFee;
}
