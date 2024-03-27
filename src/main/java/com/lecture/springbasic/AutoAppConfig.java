package com.lecture.springbasic;

import com.lecture.springbasic.member.MemberRepository;
import com.lecture.springbasic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 기존 AppConfig를 자동으로 등록하지 않게 하기 위해서 기존 설정정보는 추가되지 않게 해준다.
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 자동 빈 등록과 수동 빈 등록 출동 테스트
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
