package domain;


import infrastructure.CommonException;

/**
 * @author hansh
 */
public interface CompareSameHandsType<T> {
    /**
     * @param var1
     * @param var2
     * @return
     * @throws CommonException
     */

    int compare(T var1, T var2) throws CommonException;
}
