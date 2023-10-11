package flexnyl.com.br.backendsoapp.user;

public class UserMapper {

    public static User mapToUser (UserDTO userDTO){
        return new User(
            userDTO.getId(),
            userDTO.getUserName(),
            userDTO.getFirstName(),
            userDTO.getLastName(),
            userDTO.getPassword(),
            userDTO.getJobTitle(),
            userDTO.getUserAccessLevel()
        );
    }

    public static UserDTO mapToUserDTO (User user){
        return new UserDTO(
        		user.getId(),
        		user.getUserName(),
        		user.getFirstName(),
        		user.getLastName(),
        		user.getPassword(),
        		user.getJobTitle(),
        		user.getUserAccessLevel()
        		);

    }
}
