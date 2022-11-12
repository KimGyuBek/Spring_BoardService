package com.basicproject.boardservice.data.repository;

import com.basicproject.boardservice.data.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

   Optional<Member> findByMemberName(String memberName);


}
