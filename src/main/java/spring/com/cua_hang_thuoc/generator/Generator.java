package spring.com.cua_hang_thuoc.generator;

import org.springframework.stereotype.Component;

import java.util.List;

public class Generator {
    private static final String PREFIX_EMP = "NV";
    public static String getEmployeeCode(List<String> ids) {
        long max = ids.stream()
                .filter(i -> !i.equals("admin"))
                .map(i -> i.replace(PREFIX_EMP,""))
                .mapToLong(Long::parseLong).max().orElse(0L);
        return PREFIX_EMP + String.format("%03d", max + 1);
    }
}
