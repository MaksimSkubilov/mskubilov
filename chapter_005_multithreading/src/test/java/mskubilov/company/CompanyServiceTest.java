package mskubilov.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.06.17
 */
public class CompanyServiceTest {

    /**
     * Test of getting top company's parent.
     */
    @Test
    public void testGetParentCompany() {
        Company company = new Company(null, 10);
        Company company1 = new Company(company, 20);
        Company company2 = new Company(company1, 30);
        Company company3 = new Company(company2, 40);
        CompanyService service = new CompanyService();
        assertThat(service.getTopLevelParent(company3), is(company));
    }

    /**
     * Test of getting all company's childs employees count including company.
     */
    @Test
    public void testGetEmployeeCount() {
        Company company = new Company(null, 10);
        Company company1 = new Company(company, 20);
        Company company2 = new Company(company, 30);
        Company company3 = new Company(company2, 40);
        CompanyService service = new CompanyService();
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company);
        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
        assertThat(service.getEmployeeCountForCompanyAndChildren(company, companies), is(100L));
        assertThat(service.getEmployeeCountForCompanyAndChildren(company2, companies), is(70L));
    }

}