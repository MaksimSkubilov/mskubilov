package mskubilov.nonblocking;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.06.17
 */
public class OptimisticException extends RuntimeException {
    /**
     * @param message message.
     */
    public OptimisticException(String message) {
        super(message);
    }
}
