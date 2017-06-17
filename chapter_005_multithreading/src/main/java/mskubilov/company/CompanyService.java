package mskubilov.company;

import java.util.List;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.06.17
 */
public class CompanyService implements ICompanyService {

    /**
     * @param child - company for whom we are searching the top
     *              level parent (parent of parent of...)
     * @return top level parent.
     */
    @Override
    public Company getTopLevelParent(Company child) {
        Company result;
        if (child.getParent() != null) {
            child = child.getParent();
            result = getTopLevelParent(child);
        } else {
            result = child;
        }
        return result;
    }

    /**
     * @param company   - company for whom we are searching count of employees
     *                  (count of this company employees +
     *                  count of employees for all children companies and their children, etc.).
     * @param companies - all available companies.
     * @return count of employees.
     */
    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long result = company.getEmployeeCount();
        for (Company cmpn : companies) {
            if (company.equals(cmpn.getParent())) {
                result += getEmployeeCountForCompanyAndChildren(cmpn, companies);
            }
        }
        return result;
    }
}
