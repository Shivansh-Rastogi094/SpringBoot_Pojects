package Demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Demo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImp implements StudentDao{

	
	private EntityManager entitymanager;
	
	@Autowired
	public StudentDaoImp(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}


	@Override
	@Transactional
	public void save(Student student) {
		entitymanager.persist(student);
	}


	@Override
	public Student findId(Integer id) {
		
		return entitymanager.find(Student.class,id);
	}
	
	
	public List<Student> findByName(String name) {

	    TypedQuery<Student> query =
	            entitymanager.createQuery(
	                    "FROM Student WHERE FName LIKE :data",
	                    Student.class);

	    query.setParameter("data", "%" + name + "%");

	    return query.getResultList();
	}

}
