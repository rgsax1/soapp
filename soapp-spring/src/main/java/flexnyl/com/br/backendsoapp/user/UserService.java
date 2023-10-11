package flexnyl.com.br.backendsoapp.user;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(long id);

    List<UserDTO> getAllUser();

    UserDTO updateUser(long id, UserDTO user);

    void deleteUser(long id);

}
