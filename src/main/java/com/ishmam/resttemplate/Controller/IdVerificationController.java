package com.ishmam.resttemplate.Controller;

import com.ishmam.resttemplate.Model.IdVerificationDto;
import com.ishmam.resttemplate.Model.IdVerificationPostDto;
import com.ishmam.resttemplate.Model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdVerificationController {

  static IdVerificationDto idVerificationDto = new IdVerificationDto();

  static {
    idVerificationDto.setFatherNameBn("সৈয়দ নুরুজ্জামান");
    idVerificationDto.setFullNameEn("Syed Monir Hasan");
    idVerificationDto.setFullNameBn("সৈয়দ মনির হাসান");
    idVerificationDto.setFatherNameEn("Syed Nuruzzaman");
    idVerificationDto.setMotherNameEn("Amena Khatun");
    idVerificationDto.setMotherNameBn("আমেনা খাতুন");
    idVerificationDto.setSpouseNameEn("Nasrin Aktar");
    idVerificationDto.setSpouseNameBn("নাসরিন আক্তার");
    idVerificationDto.setPresentAddressEn(
        "House#x, Road#Y, Tejkunipara Honda Goli, Tejgaon, Dhaka");
    idVerificationDto.setPresentAddressBn(
        "বাসাঃ ১৮, রোডঃ ১১, সেকশনঃ ১২, ব্লকঃ বি , মিরপুর - ১২, ঢাকা");
    idVerificationDto.setPermanentAddressEn(
        "House#x, Road#Y, Tejkunipara Honda Goli, Tejgaon, Dhaka");
    idVerificationDto.setPermanentAddressBn(
        "ধারীশ্বর, পোস্টঃ  জারইতলা, থানাঃ নিকলী , জেলাঃ কিশোরগঞ্জ ");
    idVerificationDto.setGender("Male");
    idVerificationDto.setPhotoUrl("https://via.placeholder.com/150");
  }
  public IdVerificationController() {
  }

  @PostMapping("/id-verification")
  public IdVerificationDto getStudent(@RequestBody IdVerificationPostDto idVerificationPostDto){
    return idVerificationDto;
  }

}
