package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 12.04.17
 */
public class Visitor {
    /**
     * count. Количество посетителей.
     */
    private static int count = 0;
    /**
     * id. Уникальный номер посетителя.
     */
    private int id;
    /**
     * in. Время входа.
     */
    private long in;
    /**
     * out. Время выхода.
     */
    private long out;

    /**
     * @param in - время прихода.
     * @param out - время ухода.
     */
    public Visitor(long in, long out) {
        this.id = ++count;
        this.in = in;
        this.out = out;
    }
    /**
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * @return in.
     */
    public long getIn() {
        return this.in;
    }
    /**
     * @return out.
     */
    public long getOut() {
        return this.out;
    }
    /**
     * equals. Переопределение equals.
     * @return равны или не равны.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            result = false;
        }
        Visitor other = (Visitor) obj;
        if (this.id == other.getId() && this.in == other.getIn() && this.out == other.getOut()) {
            result = true;
        }
        if (this.getIn() == this.getOut()) {
            result = true;
        }
        return result;
    }
    /**
     * hashCode. Переопределение hashCode.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return ((int) (this.out - this.in)) / id;
    }
}
