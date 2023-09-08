package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
    
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    //서비르랑 레포지토리를 스프링빈에 등록을 하고
    // 등록되어있는걸 멤버 서비스에 넣어줌
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean 
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
