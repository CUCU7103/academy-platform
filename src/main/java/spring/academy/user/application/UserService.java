package spring.academy.user.application;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.academy.global.util.BcryptPasswordEncryptor;
import spring.academy.user.dao.UserRepository;
import spring.academy.user.domain.User;
import spring.academy.user.dto.UserDto;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

	private final UserRepository userRepository;

	private final BcryptPasswordEncryptor passwordEncryptor;

	public UserDto insertUser(UserDto dto) {

		String hashPassword = BcryptPasswordEncryptor.hashPassword(dto.getUserPassword());
		log.error("show encoding {} ", hashPassword);
		dto.setUserPassword(hashPassword);
		User result = userRepository.save(User.from(dto));

		return UserDto.from(result);
	}
}
