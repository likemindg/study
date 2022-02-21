package hello.hellospirng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospirng.repository.JdbcMemberRepository;
import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
	private final DataSource dataSource;

	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new JdbcMemberRepository(dataSource);
	}
}