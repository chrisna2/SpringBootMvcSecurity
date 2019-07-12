package com.tyn.boot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.hibernate.cfg.SetSimpleValueTypeSecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyn.boot.entity.Account;
import com.tyn.boot.repository.AccountRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private AccountRepository accountrepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/* mybatis를 사용해도 여기서 설정을 하면 된다!  */
	
	public Account createAccout(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		//account.setPassword(password);
		account.setPassword(passwordEncoder.encode(password));
		return accountrepository.save(account);
	}

	@PostConstruct
	public void init() {
		Optional<Account> byUserName = accountrepository.findByUsername("hyunkee");
		if(!byUserName.isPresent()) {
			Account newAccount = this.createAccout("hyunkee", "1111");
			System.out.println(newAccount);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> byusername = accountrepository.findByUsername(username);
		Account account = byusername.orElseThrow(() ->new UsernameNotFoundException(username));
		return new User(account.getUsername(),account.getPassword(),authorities());
	}
	
	private Collection<? extends GrantedAuthority> authorities(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
