package Client;

import Compute.Task;
import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements Task<BigDecimal>, Serializable {
    private static final long serialVersionUID = 227L;
    private static final BigDecimal FOUR = BigDecimal.valueOf(4L);
    private static final int roundingMode = 6;
    private final int digits;

    public Pi(int var1) {
        this.digits = var1;
    }

    public BigDecimal execute() {
        return computePi(this.digits);
    }

    public static BigDecimal computePi(int var0) {
        int var1 = var0 + 5;
        BigDecimal var2 = arctan(5, var1);
        BigDecimal var3 = arctan(239, var1);
        BigDecimal var4 = var2.multiply(FOUR).subtract(var3).multiply(FOUR);
        return var4.setScale(var0, 4);
    }

    public static BigDecimal arctan(int var0, int var1) {
        BigDecimal var5 = BigDecimal.valueOf((long)var0);
        BigDecimal var6 = BigDecimal.valueOf((long)(var0 * var0));
        BigDecimal var3 = BigDecimal.ONE.divide(var5, var1, 6);
        BigDecimal var2 = var3;
        int var7 = 1;

        BigDecimal var4;
        do {
            var3 = var3.divide(var6, var1, 6);
            int var8 = 2 * var7 + 1;
            var4 = var3.divide(BigDecimal.valueOf((long)var8), var1, 6);
            if (var7 % 2 != 0) {
                var2 = var2.subtract(var4);
            } else {
                var2 = var2.add(var4);
            }

            ++var7;
        } while(var4.compareTo(BigDecimal.ZERO) != 0);

        return var2;
    }
}