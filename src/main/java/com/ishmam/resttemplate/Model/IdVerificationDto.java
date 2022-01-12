package com.ishmam.resttemplate.Model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdVerificationDto {

  private String fullNameEn;

  private String fullNameBn;

  private String fatherNameEn;

  private String fatherNameBn;

  private String motherNameEn;

  private String motherNameBn;

  private String spouseNameEn;

  private String spouseNameBn;

  private String presentAddressEn;

  private String presentAddressBn;

  private String permanentAddressEn;

  private String permanentAddressBn;

  private String gender;

  private String profession;

  private String dateOfBirth;

  private String nationalIdNumber;

  private String photoUrl;

  private List<MemOtherEngagedDto> memOtherEngagedDtos;

}
