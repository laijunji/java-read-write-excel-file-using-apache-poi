import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLParser {

    public static Set<String> extractFieldsForTable(String sql, String tableAlias) {
        // 正则表达式用于匹配指定表别名的字段
        String regex = tableAlias + "\\.([a-zA-Z_][a-zA-Z0-9_]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sql);

        Set<String> fields = new HashSet<>();

        // 循环查找匹配字段
        while (matcher.find()) {
            fields.add(matcher.group(1)); // 去重添加字段
        }

        return fields;
    }
}
