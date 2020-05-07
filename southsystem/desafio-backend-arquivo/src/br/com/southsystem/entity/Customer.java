package br.com.southsystem.entity;

import br.com.southsystem.utils.Log;

/**
 * Customer Entity
 * 
 * @author marcioferoli <marcioferoli@gmail.com>
 * @version 1.0
 * @since 2020-05-07
 */
public class Customer {

  public static final int TYPE = 2;

  private String cnpj = null;
  private String name = null;
  private String businessArea = null;

  /**
   * Constructor
   */
  public Customer(String[] line) {
    super();
    this.cnpj = line[1];
    this.name = line[2];
    this.businessArea = line[3];

    Log.info(String.format("Customer [%s][%s][%s]", cnpj, name, businessArea));
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBusinessArea() {
    return businessArea;
  }

  public void setBusinessArea(String businessArea) {
    this.businessArea = businessArea;
  }

}
