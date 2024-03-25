package com.lecture.springbasic.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
