package spring.teamproject.dabang.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int save(User user)throws Exception;
	public User findUserByUserEmail(String email) throws Exception;
}
