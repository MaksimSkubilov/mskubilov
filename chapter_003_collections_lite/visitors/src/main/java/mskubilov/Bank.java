package mskubilov;

import java.util.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 12.04.17
 */
public class Bank {
    /**
     * Calendar of actual time.
     */
    private Calendar calendar = new GregorianCalendar();
    /**
     * Set of one day bank's visitors.
     */
    private Set<Visitor> visitors = new HashSet<Visitor>();
    /**
     * Map of visitors count at same time.
     */
    private Map<Visitor, Integer> periodsOfVisits = new TreeMap<Visitor, Integer>(new Comparator<Visitor>() {
        @Override
        public int compare(Visitor o1, Visitor o2) {
            if (o1.getIn() > o2.getIn()) {
                return 1;
            } else if (o2.getIn() == o2.getOut()) {
                return 0;
            } else {
                return -1;
            }
        }
    });

    /**
     * Set calendar's actual time.
     */
    public void setCalendar() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        this.calendar.set(year, month, date, 8, 0, 0);
    }

    /**
     * fill visitors with Random.
     */
    public void fillVisitors() {
        Random rn = new Random();
        long in;
        long out;
        long openSince = this.calendar.getTimeInMillis();
        long time = 12 * 60 * 60 * 1000;
        int count = (int) (rn.nextDouble() * 20 + 1);
        for (int i = 0; i <= count; i++) {
            in = openSince + Math.abs((long) (rn.nextDouble() * time));
            out = in + Math.abs((long) (rn.nextDouble() * (openSince + time - in)));
            this.visitors.add(new Visitor(in, out));
        }
    }

    /**
     * fill visitors from array.
     * @param visitors - array of visitors.
     */
    public void fillVisitors(Visitor[] visitors) {
        for (Visitor visitor : visitors) {
            this.visitors.add(visitor);
        }
    }

    /**
     * counting of Max value of visits at same time and filling this.periodsOfVisits.
     * @return Max value.
     */
    public int maxVisitorsAmount() {
        Map<Long, Boolean> visitorsTime = new TreeMap<Long, Boolean>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (Visitor visitor : this.visitors) {
            visitorsTime.put(visitor.getIn(), true);
            visitorsTime.put(visitor.getOut(), false);
        }
        ArrayList<Map.Entry<Long, Boolean>> time = new ArrayList<>();
        time.addAll(visitorsTime.entrySet());
        long in = time.get(0).getKey(), out = in;
        int temp = 0, result = temp;
        for (int i = 0; i != time.size(); i++) {
            if (time.get(i).getValue() && temp == 0) {
                temp++;
                in = time.get(i).getKey();
            } else if (time.get(i).getValue()) {
                    out = time.get(i).getKey();
                    this.periodsOfVisits.put(new Visitor(in, out), temp);
                    in = out;
                    temp++;
            } else {
                out = time.get(i).getKey();
                this.periodsOfVisits.put(new Visitor(in, out), temp);
                in = out;
                temp--;
            }
            if (temp > result) {
                result = temp;
            }
        }

        return result;
    }

    /**
     * Print visits on count of Visitors.
     * @param count - count of Visitors.
     */
    public void printVisitors(int count) {
        System.out.printf("Max %s visitors was on %s %s %s\n", count, this.calendar.get(Calendar.YEAR), this.calendar.get(Calendar.MONTH), this.calendar.get(Calendar.DATE));
        for (Map.Entry<Visitor, Integer> entry : this.periodsOfVisits.entrySet()) {
            if (entry.getValue() == count) {
                System.out.printf("%s visitors from %s till %s\n", entry.getValue(), new Date(entry.getKey().getIn()), new Date(entry.getKey().getOut()));
            }
        }
        System.out.println();
    }

    /**
     * Print all visits.
     */
    public void printVisitors() {
        System.out.println("Visits amount on same time:");
        for (Map.Entry<Visitor, Integer> entry : this.periodsOfVisits.entrySet()) {
            System.out.printf("%s visitors from %s till %s\n", entry.getValue(), new Date(entry.getKey().getIn()), new Date(entry.getKey().getOut()));
        }
        System.out.println();
    }

}
