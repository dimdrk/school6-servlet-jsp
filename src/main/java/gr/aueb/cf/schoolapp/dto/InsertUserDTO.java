package gr.aueb.cf.schoolapp.dto;

public class InsertUserDTO extends BaseUserDTO {
    private String confirmPassword;

    public InsertUserDTO() {}

    public InsertUserDTO(String username, String password, String confirmPassword) {
        super(username, password, confirmPassword);
    }

}
