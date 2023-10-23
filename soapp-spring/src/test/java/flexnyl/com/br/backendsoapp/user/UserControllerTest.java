package flexnyl.com.br.backendsoapp.user;

import lombok.AllArgsConstructor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import flexnyl.com.br.backendsoapp.config.TestConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@AllArgsConstructor
@ContextConfiguration(classes = TestConfig.class)
public class UserControllerTest {
	/*
	
	private final UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Limpe o banco de dados de teste antes de cada teste, se necessário.
        // Isso é especialmente importante se você estiver usando um banco de dados de teste incorporado.
        // userRepository.deleteAll();
    }

    @Test
    public void testCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("testuser");
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setPassword("password");
        userDTO.setJobTitle("Developer");
        userDTO.setUserAccessLevel(UserAccessLevel.USER);

        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)));

    }

    @Test
    public void testGetUserById() throws Exception {
        // Crie um usuário de teste no banco de dados antes de realizar o teste de busca por ID.
        User user = new User();
        user.setUserName("testuser");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");
        user.setJobTitle("Developer");
        user.setUserAccessLevel(UserAccessLevel.USER);
        // Salve o usuário no banco de dados e obtenha o ID.
        user = userRepository.save(user);

        mockMvc.perform(get("/api/v1/users/" + user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("testuser"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Crie um usuário de teste no banco de dados antes de realizar o teste de atualização.
        User user = new User();
        user.setUserName("testuser");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");
        user.setJobTitle("Developer");
        user.setUserAccessLevel(UserAccessLevel.USER);
        // Salve o usuário no banco de dados e obtenha o ID.
        user = userRepository.save(user);

        UserDTO updatedUser = new UserDTO();
        updatedUser.setFirstName("UpdatedFirstName");
        updatedUser.setLastName("UpdatedLastName");
        updatedUser.setPassword("UpdatedPassword");
        updatedUser.setJobTitle("UpdatedJobTitle");
        updatedUser.setUserAccessLevel(UserAccessLevel.MANAGER);

        mockMvc.perform(put("/api/v1/users/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("UpdatedFirstName"))
                .andExpect(jsonPath("$.lastName").value("UpdatedLastName"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        // Crie um usuário de teste no banco de dados antes de realizar o teste de exclusão.
        User user = new User();
        user.setUserName("testuser");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");
        user.setJobTitle("Developer");
        user.setUserAccessLevel(UserAccessLevel.USER);
        // Salve o usuário no banco de dados e obtenha o ID.
        user = userRepository.save(user);

        mockMvc.perform(delete("/api/v1/users/" + user.getId()))
                .andExpect(status().isOk());

        // Verifique se o usuário foi excluído do banco de dados.
        mockMvc.perform(get("/api/v1/users/" + user.getId()))
                .andExpect(status().isNotFound());
    }
    */
}
