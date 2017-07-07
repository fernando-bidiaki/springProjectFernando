package springProjectFernando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import springProjectFernando.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findById(Integer id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByCpf(String cpf) {
		return em.createNamedQuery("User.findbyCpf", User.class).setParameter("cpf", cpf).getSingleResult();
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	@Override
	public void save(User user) {
		em.persist(user);
	}

	@Override
	public User update(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void delete(User user) {
		em.remove(findById(user.getId()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findBy(String lastName, String firstName, String cpf) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT u FROM User u WHERE 1=1 ");

		if (StringUtils.isNotEmpty(lastName)) {
			sql.append(" AND u.lastName = :lastName ");
		}

		if (StringUtils.isNotEmpty(firstName)) {
			sql.append(" AND u.firstName = :firstName ");
		}

		if (StringUtils.isNotEmpty(cpf)) {
			sql.append(" AND u.cpf = :cpf ");
		}

		Query query = em.createQuery(sql.toString());

		if (StringUtils.isNotEmpty(lastName)) {
			query.setParameter("lastName", lastName);
		}

		if (StringUtils.isNotEmpty(firstName)) {
			query.setParameter("firstName", firstName);
		}

		if (StringUtils.isNotEmpty(cpf)) {
			query.setParameter("cpf", cpf);
		}

		return query.getResultList();
	}

	@Override
	public User findUserName(String username) {
		String sql = "SELECT u FROM User u WHERE u.username = :username";
		User user = em.createQuery(sql,User.class).setParameter("username", username).getSingleResult();
		
		if(user != null){
			Hibernate.initialize(user.getUserProfiles());
		}
		
		return user;
	}

}
