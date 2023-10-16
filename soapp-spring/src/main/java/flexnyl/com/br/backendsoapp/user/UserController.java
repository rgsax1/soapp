package flexnyl.com.br.backendsoapp.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO savedUser = userService.createUser(userDTO);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
    
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO updatedUser){
        UserDTO userDTO = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
}
