package Demo.Dao;

import java.util.List;

import Demo.model.Student;

public interface StudentDao {
	public void save(Student student);
	public Student findId(Integer id);
	List<Student> findByName(String name);
}
