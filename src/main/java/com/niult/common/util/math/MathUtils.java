package com.niult.common.util.math;

/**
 * @author Niu Liangtao
 * @create 2018/01/28 18:07
 */
public class MathUtils {

    public static double getCosSim(double[] a, double[] b, double[] c) {
        return multi(a, b, c) / Math.sqrt(multi(a, a) * multi(b, b));
    }

    public static double getCosSim(double[] a, double[] b) {
        return multi(a, b) / Math.sqrt(multi(a, a) * multi(b, b));
    }

    public static double multi(double[] a, double[] b, double[] c) {
        if(a == null || b == null || c == null || a.length != b.length) {
            error("参数错误");
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i] * b[i] * c[i];
        }
        return sum;
    }

    public static double multi(double[] a, double[] b) {
        if(a == null || b == null || a.length != b.length) {
            error("参数错误");
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    private static void error(String info) {
        System.out.println(info);
    }

    /**
     * 根据给定的数据集进行平均值计算
     *
     * @param arr 数据集
     * @return 给定数据集的平均值
     */
    public static double means(double[] arr) {
        return sum(arr) / arr.length;
    }

    /**
     * 根据给定的数据集进行求和计算
     *
     * @param arr 数据集
     * @return 给定数据集的和
     */
    public static double sum(double[] arr) {
        double sum = 0.0;
        for(double data : arr) {
            sum += data;
        }
        return sum;
    }

    public static double getPearsonCorrelationScore(double[] x, double[] y) {
        //拿到两个数据的平均值
        double xMeans = means(x);
        double yMeans = means(y);

        // 计算皮尔逊系数的分子
        double numerator = 0.0;
        for(int i = 0; i < x.length; i++) {
            numerator += (x[i] - xMeans) * (y[i] - yMeans);
        }

        // 计算皮尔逊系数的分母
        double denominator;
        double xSum = 0.0;
        for(double aXData : x) {
            xSum += (aXData - xMeans) * (aXData - xMeans);
        }

        double ySum = 0.0;
        for(double aYData : y) {
            ySum += (aYData - yMeans) * (aYData - yMeans);
        }

        denominator = Math.sqrt(xSum) * Math.sqrt(ySum);

        //计算皮尔逊系数
        return numerator / denominator;
    }

    public static int inverseNumber(double[] arr) {
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == - 100.11) {
                continue;
            }
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j] && arr[j] != - 100.11) {
                    count++;
                }
            }
        }
        return count;
    }
}
