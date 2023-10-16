package flexnyl.com.br.backendsoapp.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public UserDTO createUser(UserDTO userDTO) {
        User userAccount = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(userAccount);
        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found."));
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(long id, UserDTO updatedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found."));
        user.setFirstName(updatedUser.getFirstName());
        user.setJobTitle(updatedUser.getJobTitle());
        user.setLastName(updatedUser.getLastName());
        user.setPassword(updatedUser.getPassword());
        user.setUserAccessLevel(updatedUser.getUserAccessLevel());
        user.setUserName(updatedUser.getUserName());
        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDTO(updatedUserObj);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found."));
        userRepository.deleteById(id);
    }

}
