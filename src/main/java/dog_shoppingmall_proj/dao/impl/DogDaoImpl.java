package dog_shoppingmall_proj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dog_shoppingmall_proj.dao.DogDao;
import dog_shoppingmall_proj.dto.Dog;

public class DogDaoImpl implements DogDao {
	private static final DogDaoImpl instance = new DogDaoImpl();
	private Connection con;
	
	public static DogDaoImpl getInstance() {
		return instance;
	}

	public DogDaoImpl() {
		
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public List<Dog> selectDogList() {
		String sql = "SELECT id, kind, price, image, country "
				 + 	 "	,height, weight, content, readcount FROM dog";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Dog> list = new ArrayList<Dog>();
					do {
						list.add(getDog(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Dog getDog(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String kind = rs.getString("kind");
		int price = rs.getInt("price");
		String image = rs.getString("image");
		String country = rs.getString("country");
		int height = rs.getInt("height");
		int weight = rs.getInt("weight");
		String content = rs.getString("content");
		int readcount = rs.getInt("readcount");
		
		return new Dog(id, kind, price, image, country, height, weight, content, readcount);
	}

	@Override
	public Dog selectDog(int id) {
		String sql = "SELECT id, kind, price, image, country " 
				 +	 "	,height, weight, content, readcount FROM dog "
				 + 	 "	WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getDog(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertDog(Dog dog) {
		String sql = "INSERT INTO shoppingmall.dog "
				 +	 " (kind, price, image, country, height, weight, content, readcount) values "
				 + 	 " (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, dog.getKind());
			pstmt.setInt(2, dog.getPrice());
			pstmt.setString(3, dog.getImage());
			pstmt.setString(4, dog.getCountry());
			pstmt.setInt(5, dog.getHeight());
			pstmt.setInt(6, dog.getWeight());
			pstmt.setString(7, dog.getContent());
			pstmt.setInt(8, dog.getReadcount());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateReadCount(int id) {
		String sql = "UPDATE dog SET readcount = readcount + 1 WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
