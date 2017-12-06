package com.github.KKimishima.MailAdmin.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcTestTest {
  @Test
  public void sqlCheck() throws Exception {
    JdbcTest jdbcTest = new JdbcTest();
    assertEquals(true,jdbcTest.sqlCheck());
  }

}