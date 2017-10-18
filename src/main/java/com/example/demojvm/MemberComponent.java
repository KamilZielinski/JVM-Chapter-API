package com.example.demojvm;

import org.springframework.stereotype.Component;

@Component
public class MemberComponent {

  public String geVeryCoolToString(final Member member) {
    return member.toString();
  }
}
