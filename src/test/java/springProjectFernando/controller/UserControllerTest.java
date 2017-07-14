package springProjectFernando.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import springProjectFernando.entity.User;
import springProjectFernando.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	private static String ENDPOINT = "/user";
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private UserController controller;
	
	@Mock
	private UserService userService;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	private byte[] toJason(Object obj) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(obj);
	}
	
	@Test
	public void sholdSaveUser() throws Exception{
		User user = new User();
		user.setLastName("Tester");
		user.setUsername("jao");
		
		mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT)
				.content(toJason(user))).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
