package June_7st.Relationships.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentDTO {
    private String firstName;

    public String getFirstName(){
        return firstName;
    }
}
