package com.example.demojvm;

import com.example.demojvm.MemberRepository.MemberProjection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;

@RepositoryRestResource(excerptProjection = MemberProjection.class)
public interface MemberRepository extends JpaRepository<Member, Integer> {

  Optional<Member> findByName(@Param("name") String name);

  @Projection(types = Member.class)
  interface MemberProjection {
    String getName();

    String getPassword();

    @Value("#{target.name} #{target.surname}")
    String getSuperUberConnectedNameAndSurname();

    @Value("#{@memberComponent.geVeryCoolToString(target)}")
    String getVeryCoolToString();
  }

  @Override
  @RestResource(exported = false)
  void delete(Member member);
}
