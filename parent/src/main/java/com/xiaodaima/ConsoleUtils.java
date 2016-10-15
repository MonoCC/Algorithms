package com.xiaodaima;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 控制台Utils，处理控制台输入，输出。
 */
public abstract class ConsoleUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ConsoleUtils.class);

    /**
     * 从控制台输入
     * @return int 数组
     */
    public static int[] readLine() {
        Scanner scanner = null;
        int[] b = null;
        try {
            LOG.info("请在下一行输入所有数字，并且使用空格分隔：");
            InputStream inputStream = System.in;
            scanner = new Scanner(inputStream);
            String line = scanner.nextLine().trim();
            if(line.equals("")) {
                LOG.info("请输入正确的数字！");
                System.exit(0);
            }
            LOG.info("输入的结果为：" + SystemUtils.LINE_SEPARATOR + line);
            String[] strs = line.split("( )+");
            if(strs.length == 0) {
                LOG.info("请输入正确的数字！");
                System.exit(0);
            }
            List<Integer> ints = Arrays.stream(strs).filter((s) -> {
                return NumberUtils.isNumber(s);
            }).map(s -> {
                return Integer.parseInt(s);
            }).collect(Collectors.toList());
            LOG.info("数组排序前：" + ints.toString());
            b = new int[ints.size()];
            for(int i=0; i<ints.size(); i++) {
                b[i] = ints.get(i);
            }
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
        return b;
    }

    /**
     * 通过日志输出
     * @param s
     */
    public static void putOut(int[] s) {
        LOG.info("数组排序后：" + Arrays.toString(s));
    }

    public static void main(String[] args){
        readLine();
    }
}
