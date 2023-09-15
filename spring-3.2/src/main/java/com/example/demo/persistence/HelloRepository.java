package com.example.demo.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HelloRepository {

  private final JdbcClient jdbcClient;
  private final JdbcTemplate jdbcTemplate;


  public Optional<Invoice> getComprobante() {
    final var sql = " SELECT ID,FOLIO FROM dbo.FN_SPRINGBOOT_TEST() ";
    return jdbcClient.sql(sql)
        .query(Invoice.class)
        .optional();
  }

  public Integer save(String name) {
    jdbcTemplate.setResultsMapCaseInsensitive(true);
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("NAME", name)
        .addValue("ID", 0);
    var map = new SimpleJdbcCall(jdbcTemplate)
        .withProcedureName("SP_SPRINGBOOT_TEST")
        .execute(parameters);
    return Integer.parseInt(map.get("ID").toString());
  }

}
