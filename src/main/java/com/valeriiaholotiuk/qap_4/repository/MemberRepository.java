package com.valeriiaholotiuk.qap_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valeriiaholotiuk.qap_4.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
}
