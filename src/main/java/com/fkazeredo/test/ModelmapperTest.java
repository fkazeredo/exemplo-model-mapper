package com.fkazeredo.test;

import com.fkazeredo.domain.*;
import com.fkazeredo.dto.CompanyData;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ModelmapperTest {

    private ModelMapper mapper;

    /*
     *  Configuração necessária porque a camada de domínio está utilizando getters fluentes
     */
    @Before
    public void setUp() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE)
                .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                .setSourceNamingConvention(NamingConventions.NONE);
    }

    @Test
    public void mustMapDomainToDTO() {
        Country country = new Country(1L, "Brasil", "BRA");

        Region region = new Region(1L, "RJ", "Rio de Janeiro", country);

        City city = new City(1L, "Rio de Janeiro", region, country);

        Address address = new Address(
                "111111111",
                "Main Street",
                "28",
                null,
                "Hell's kitchen",
                city
        );

        NaturalPerson representative = new NaturalPerson(
                1L,
                "28174132023",
                new PersonName("Brian", "Johnson"),
                new Contact(ContactType.EMAIL, "brian.johnson@acdc.com")
        );


        JuridicalPerson companyInfo = new JuridicalPerson(
                1L,
                "04639119000160",
                new CompanyName("AC/DC", "AC/DC Corporation"),
                address,
                new Contact(ContactType.PHONE_NUMBER, "2125668698"),
                new Contact(ContactType.EMAIL, "contact@acdc.com"),
                representative
        );

        Company company = new Company(
                1L,
                companyInfo,
                "For those about to rock, we salute you"
        );

        CompanyData dto = mapper.map(company, CompanyData.class);

        assertEquals(company.companyInfo().address().city().id(), dto.getAddress().getCity().getId());
        assertEquals(company.companyInfo().address().city().name(), dto.getAddress().getCity().getName());

        assertEquals(company.companyInfo().address().city().region().id(), dto.getAddress().getRegion().getId());
        assertEquals(company.companyInfo().address().city().region().name(), dto.getAddress().getRegion().getName());

        assertEquals(company.companyInfo().address().city().country().id(), dto.getAddress().getCountry().getId());
        assertEquals(company.companyInfo().address().city().country().name(), dto.getAddress().getCountry().getName());

        assertEquals(company.companyInfo().address().zipCode(), dto.getAddress().getZipCode());
        assertEquals(company.companyInfo().address().street(), dto.getAddress().getStreet());
        assertEquals(company.companyInfo().address().number(), dto.getAddress().getNumber());
        assertEquals(company.companyInfo().address().neighborhood(), dto.getAddress().getNeighborhood());
        assertNull(company.companyInfo().address().complement());

        assertEquals(company.companyInfo().representative().cpf(), dto.getRepresentative().getCpf());
        assertEquals(company.companyInfo().representative().personName().firstName(), dto.getRepresentative().getFirstName());
        assertEquals(company.companyInfo().representative().personName().lastName(), dto.getRepresentative().getLastName());
        assertEquals(company.companyInfo().representative().email(), dto.getRepresentative().getEmail());


        assertEquals(company.companyInfo().cnpj(), dto.getCnpj());
        assertEquals(company.companyInfo().companyName().tradingName(), dto.getTradingName());
        assertEquals(company.companyInfo().companyName().legalName(), dto.getLegalName());
        assertEquals(company.companyInfo().phoneNumber(), dto.getPhoneNumber());
        assertEquals(company.companyInfo().email(), dto.getEmail());

        assertEquals(company.id(), dto.getId());
        assertEquals(company.description(), dto.getDescription());


    }

}
