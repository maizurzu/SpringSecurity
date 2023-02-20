package demospringsecurityform.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService{
									//Spring security에서 지원하는 서비스, DAO를 통해서 DB에 있는 정보를 가져와서 '인증' 할때 사용하는 인터페이스
										//무조건 RDBMS 혹은 NOSQL에 있어야 한다는 등의 제약은 없음
	@Autowired
	AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		return null;
	}
	
	
}
