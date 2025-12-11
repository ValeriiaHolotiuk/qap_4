package com.valeriiaholotiuk.qap_4.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valeriiaholotiuk.qap_4.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);


    List<Member> findByNameContainingIgnoreCase(String name);

    List<Member> findByPhoneNumber(String phoneNumber);

    List<Member> findByMembershipStartDate(LocalDate membershipStartDate);
}
