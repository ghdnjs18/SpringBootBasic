package com.lecture.springbasic.autowired;

import com.lecture.springbasic.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            // 호출 자체가 안됨
            System.out.println("noBean1 = " +noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            // noBean2 = null
            System.out.println("noBean2 = " +noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            // noBean3 = Optional.empty
            System.out.println("noBean3 = " +noBean3);
        }
    }
}
