package com.codegym.repository;

import com.codegym.model.MedicalDeclaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {

    private static List<MedicalDeclaration> declarations = new ArrayList<>();

    static {
        declarations.add(new MedicalDeclaration(1, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
        declarations.add(new MedicalDeclaration(2, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
        declarations.add(new MedicalDeclaration(3, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
        declarations.add(new MedicalDeclaration(4, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
        declarations.add(new MedicalDeclaration(5, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
        declarations.add(new MedicalDeclaration(6, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
        declarations.add(new MedicalDeclaration(7, "Hà Bảo Ân", "01/01/1993", "Nam", "Việt nam", 241399524, "Xe ô tô", "51H-1057", 8, "01-01-2020", "02/01/2020", "none"));
    }

    @Override
    public List<MedicalDeclaration> displayAll() {
        return declarations;
    }

    @Override
    public MedicalDeclaration finById(int id) {
        return declarations.get(id);
    }

    @Override
    public MedicalDeclaration edit(MedicalDeclaration medicalDeclaration) {
        MedicalDeclaration declaration = finById(medicalDeclaration.getId());
        declaration.setName(medicalDeclaration.getName());
        declaration.setDayOfBirth(medicalDeclaration.getDayOfBirth());
        declaration.setCountry(medicalDeclaration.getCountry());
        declaration.setEndDay(medicalDeclaration.getEndDay());
        declaration.setGender(medicalDeclaration.getGender());
        declaration.setIdCard(medicalDeclaration.getIdCard());
        declaration.setLicense(medicalDeclaration.getLicense());
        declaration.setStartDay(medicalDeclaration.getStartDay());
        declaration.setNumberOfSeat(medicalDeclaration.getNumberOfSeat());
        declaration.setTravelHistory(medicalDeclaration.getTravelHistory());
        declaration.setTravelInformation(medicalDeclaration.getTravelInformation());
        return declaration;
    }

    public List<Integer> dateList() {
        List<Integer> dates = new ArrayList<>();
        dates.add(1990);
        dates.add(1991);
        dates.add(1992);
        dates.add(1993);
        dates.add(1994);
        dates.add(1995);
        dates.add(1996);
        dates.add(1997);
        dates.add(1998);
        dates.add(1999);
        return dates;
    }

    @Override
    public List<String> genderList() {
        List<String> strings = new ArrayList<>();
        strings.add("Nam");
        strings.add("Nữ");
        strings.add("LGBT");
        return strings;
    }

    @Override
    public List<String> countryList() {
        List<String> strings = new ArrayList<>();
        strings.add("Việt Nam");
        strings.add("Nhật Bản");
        strings.add("Trung quốc");
        strings.add("Anh");
        strings.add("Cambodia");
        return strings;
    }

    @Override
    public List<String> travelInfo() {
        List<String> strings = new ArrayList<>();
        strings.add("Máy bay");
        strings.add("Ô tô");
        strings.add("Thuyền");
        strings.add("Tàu hỏa");
        strings.add("Khác");
        return strings;
    }

}
