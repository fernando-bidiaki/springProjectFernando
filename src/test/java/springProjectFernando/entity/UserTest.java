package springProjectFernando.entity;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import springProjectFernando.config.TestJPAContextConfiguration;
import springProjectFernando.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestJPAContextConfiguration.class})
@Transactional
@Rollback
public class UserTest {

		@Autowired
		private UserDAO dao;
		private User user;
		
		@Before
		public void before(){
			user = new User();
			user.setFirstName("Tester");
			user.setLastName("Test");
			user.setCpf("987.654.321-12");
			user.setUsername("junit");
			user.setPassword("season");
			dao.save(user);
		}
		
		@Test
		public void shouldSaveNewUser(){
			Assert.assertNotNull(user.getId());
		}
		
		@Test
		public void findByCpf(){
			List<User> users = dao.findBy("", "",user.getCpf());
			Assert.assertNotNull(dao.findByCpf(user.getCpf()));
			Assert.assertEquals(1, users.size());
			Assert.assertEquals("987.654.321-12", users.get(0).getCpf());
		}
		
		@Test
		public void findByLastName(){
			List<User> users = dao.findBy(user.getLastName(), "", "");
			Assert.assertEquals(1, users.size());
			Assert.assertEquals("Test", users.get(0).getLastName());
		}
		
		@Test
		public void findByFirstName(){
			List<User> users = dao.findBy("",user.getFirstName(), "");
			Assert.assertEquals(1, users.size());
			Assert.assertEquals("Tester", users.get(0).getFirstName());
		}
		
		@Test
		public void findAll(){
			List<User> users = dao.findAll();
			Assert.assertEquals(1, users.size());
		}
}
