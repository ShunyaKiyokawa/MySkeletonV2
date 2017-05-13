package com.v2.myskeleton.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="Users")
public class UserEntity implements UserDetails {

	private final UserEntity userEntity;
	//private final Collection<GrantedAuthority> authorities;
	
	private static final long serialVersionUID = 148159819823L;
	
	// UserDetailsServiceを実装したUserAuthServiceから、user情報がこの引数の形式で飛んでくる
//	public UserEntity(
//		UserEntity userEntity, Collection<GrantedAuthority> authorities){
//		this.userEntity = userEntity;
//		this.authorities = authorities;
//	}
	public UserEntity(UserEntity userEntity){
			this.userEntity = userEntity;
		}
		

	 // 以下フィールド定義

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@NotEmpty
	private String role;
	
	// 以下UserDetailsServiceのOverride
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// ユーザーに与えられている権限リストを返却する。認可処理で使用する。
//		return null;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		return authorities;
	}
	
	@Override
	public String getPassword() {
		// パスワードを返却する
		// このメソッドで返却したパスワードとブラウザのパスワードが一致しないならBadCredentialsException
		return this.password;
	}

	// setはスーパーメソッドに書かれてないのでoverrideではない
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getUsername() {
		// ユーザー名を返却する
		return userEntity.getUsername();
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// アカウント有効期限内かどうか。期限内ならtrue
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// ユーザーがロックされていないか。されていないならtrue。無効ならLockedException
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// passwordの有効期限内かどうか。期限内ならtrue
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 有効なアカウントなのかの判定。無効ならDisabledException
		return true;
	}

	// 以下getterとsetter
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
