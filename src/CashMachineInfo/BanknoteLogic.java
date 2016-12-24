package CashMachineInfo;

/**
 * Created by aracorn on 20.12.16.
 */
public class BanknoteLogic {
    public static int[] banknoteLogic(int sum, int[] info) {
        int sumRemain = sum;
        int count5000 = 0;
        int count1000 = 0;
        int count500 = 0;
        int count100 = 0;
        int countAll = 0;

        outer:
        while (sumRemain != 0) {
            if (sumRemain / 5000 >= 1 && info[1] > 0) {
                while (sumRemain >= 5000) {
                    if (info[2] - info[1] >= 5 && sumRemain >= 5000) {
                        if (countAll >= 36) {
                            System.out.println("40 banknotes at a time!");
                            break outer;
                        }
                        info[2] -= 5;
                        sumRemain -= 5000;
                        count1000 += 5;
                        countAll += 5;
                    } else {
                        if (countAll >= 40) {
                            System.out.println("40 banknotes at a time!");
                            break outer;
                        }
                        sumRemain -= 5000;
                        info[1]--;
                        count5000++;
                        countAll++;
                    }
                }
            } else if (sumRemain / 1000 >= 1 && info[2] > 0) {
                while (sumRemain >= 1000) {
                    if (info[3] - info[2] >= 2 && sumRemain >= 1000) {
                        if (countAll >= 39) {
                            System.out.println("40 banknotes at a time!");
                            break outer;
                        }
                        info[3] -= 2;
                        sumRemain -= 1000;
                        count500 += 2;
                        countAll += 2;
                    } else {
                        if (countAll >= 40) {
                            System.out.println("40 banknotes at a time!");
                            break outer;
                        }
                        sumRemain -= 1000;
                        info[2]--;
                        count1000++;
                        countAll++;
                    }
                }
            } else if (sumRemain / 500 >= 1 && info[3] > 0) {
                while (sumRemain >= 500) {
                    if (info[4] - info[3] >= 5 && sumRemain >= 500) {
                        if (countAll >= 36) {
                            System.out.println("40 banknotes at a time!");
                            break outer;
                        }
                        info[4] -= 5;
                        sumRemain -= 500;
                        count100 += 5;
                        countAll += 5;
                    } else {
                        if (countAll >= 40) {
                            System.out.println("40 banknotes at a time!");
                            break outer;
                        }
                        sumRemain -= 500;
                        info[3]--;
                        count500++;
                        countAll++;
                    }
                }
            } else if (sumRemain / 100 >= 1 && info[4] > 0) {
                while (sumRemain >= 100) {
                    if (countAll >= 40) {
                        System.out.println("40 banknotes at a time!");
                        break outer;
                    }
                    sumRemain -= 100;
                    info[4]--;
                    count100++;
                    countAll++;
                }
            }
        }
        int[] result = {info[0] - sumRemain, info[1], info[2], info[3], info[4], sum - sumRemain, count5000, count1000, count500, count100};
        return result;
    }
}
