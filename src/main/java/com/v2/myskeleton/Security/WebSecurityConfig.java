package com.v2.myskeleton.Security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ちなみに求められる認証はpropertiesに書かれている内容でも通る
		http.formLogin()
				.loginPage("/login") // 認証されてないならここにリダイレクトされる。
				.permitAll() //誰でもアクセウ可能
				.usernameParameter("username") //デフォルト設定を明示。Parameterは、viewのidとnameのものと合わせること
				.passwordParameter("password") //デフォルト設定を明示。Parameterは、viewのidとnameのものと合わせること
				.defaultSuccessUrl("/Hello") // 認証成功時の遷移先
				.failureUrl("/login"); //認証失敗時遷移するパスの指定
		http.authorizeRequests()
				.anyRequest().authenticated(); // それ以外は認証後のみ閲覧可
				
	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	}
}
