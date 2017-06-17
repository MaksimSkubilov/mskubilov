package mskubilov.company;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.06.17
 */
public class Company {
    /**
     * Parent Company for which this instance is a child.
     */
    private final Company parent;
    /**
     * Count of employees of this Company instance.
     */
    private final long employeeCount;

    /**
     * @param parent Company.
     * @param employeeCount count of Company's employees.
     */
    Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    /**
     * @return parent Company.
     */
    public Company getParent() {
        return parent;
    }

    /**
     * @return employees count.
     */
    public long getEmployeeCount() {
        return employeeCount;
    }

    /**
     * @param o Company equaled.
     * @return true if equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        if (getEmployeeCount() != company.getEmployeeCount()) return false;
        return getParent() != null ? getParent().equals(company.getParent()) : company.getParent() == null;
    }

    /**
     * @return this.hashcode().
     */
    @Override
    public int hashCode() {
        int result = getParent() != null ? getParent().hashCode() : 0;
        result = 31 * result + (int) (getEmployeeCount() ^ (getEmployeeCount() >>> 32));
        return result;
    }
}
