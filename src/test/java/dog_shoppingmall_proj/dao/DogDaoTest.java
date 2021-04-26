package dog_shoppingmall_proj.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dog_shoppingmall_proj.JdbcUtil;
import dog_shoppingmall_proj.dao.impl.DogDaoImpl;
import dog_shoppingmall_proj.dto.Dog;

public class DogDaoTest {
	private static Connection con = JdbcUtil.getConnection();
	private static DogDaoImpl dao = DogDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectDogList() {
		System.out.printf("%s()%n", "test03SelectDogList");
		List<Dog> list = dao.selectDogList();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test04SelectDog() {
		System.out.printf("%s()%n", "test04SelectDog");
		int id = 1;
		Dog dog = dao.selectDog(id);
		Assert.assertNotNull(dog);
		System.out.printf("dog >> " + dog);
	}

	@Test
	public void test01InsertDog() {
		System.out.printf("%s()%n", "test01InsertDog");
		Dog newDog  = new Dog(0, "리트리버", 5000, "retriever.jpg", "영국", 1, 25, "금빛의 풍성한 털이 있다.", 0);
		int res = dao.insertDog(newDog);
		Assert.assertEquals(1, res);
		System.out.printf("InsertDog >> " + newDog);
	}
	
	@Test
	public void test02UpdateReadCount() {
		System.out.printf("%s()%n", "test02UpdateReadCount");
		int id = 1;
		int res = dao.updateReadCount(id);
		Assert.assertEquals(1, res);
		System.out.println(res);
	}

}
