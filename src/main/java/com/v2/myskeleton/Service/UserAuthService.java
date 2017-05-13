package com.v2.myskeleton.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.v2.myskeleton.Entity.UserEntity;
import com.v2.myskeleton.Repository.UserEntityRepository;

@Service

public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserEntityRepository userEntityRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || "".equals(username)) {
			throw new UsernameNotFoundException("ユーザー名を入力してください");
		}

		UserEntity usernameInfo = userEntityRepository.findByUsername(username);
		if (usernameInfo == null) {
			throw new UsernameNotFoundException("ユーザー名が登録されていません" + username);
		}

		//return usernameInfo; getはentityにかかれてるsetterを呼べばいい
		return new UserEntity(usernameInfo);
	}
	
//	private Collection<GrantedAuthority> getAuthorities(UserEntity userInfo){
//		if (userInfo.isAdmin()){
//			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
//		} else {
//			return AuthorityUtils.createAuthorityList("ROLE_USER");
//		}
//	}
	
	
	
}
