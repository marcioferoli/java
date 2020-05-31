package br.com.southsystem.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.southsystem.utils.Log;

/**
 * Salesman Entity
 * 
 * @author marcioferoli <marcioferoli@gmail.com>
 * @version 1.0
 * @since 2020-05-07
 */
public class Salesman {

  public static final int TYPE = 1;

  private String cpf = null;
  private String name = null;
  private BigDecimal salary = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

  /**
   * Constructor
   */
  public Salesman(String[] line) {
    super();
    this.cpf = line[1];
    this.name = line[2];
    this.salary = new BigDecimal(line[3]).setScale(2, RoundingMode.HALF_UP);

    Log.info(String.format("Salesman [%s][%s][%s]", cpf, name, salary));
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

}
