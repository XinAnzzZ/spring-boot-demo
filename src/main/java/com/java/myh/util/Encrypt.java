package com.java.myh.util;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author 心安
 * @date 2018/5/30 13:13
 */
public class Encrypt {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * @param paramMap
     * @param urlEncode
     * @param keyToLower
     * @return
     */
    public static String formatUrlMap(Map<String, String> paramMap, boolean urlEncode, boolean keyToLower) {
        String result;
        try {
            List<Map.Entry<String, String>> list = new ArrayList<>(paramMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            list.sort(Comparator.comparing(item -> (item.getKey())));
            // 构造URL 键值对的格式
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> item : list) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower) {
                        stringBuilder.append(key.toLowerCase()).append("=").append(val);
                    } else {
                        stringBuilder.append(key).append("=").append(val);
                    }
                    stringBuilder.append("&");
                }
            }
            result = stringBuilder.toString();
            if (!result.isEmpty()) {
                result = result.substring(0, result.length() - 1);
            }
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ParseException {
//        Map<String, String> map = new HashMap<>(16);
//        map.put("token", "9527");
        long time = new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-30").getTime();
        System.out.println(time);
//        map.put("timestamp", String.valueOf(time));
//        map.put("nonce", "123");
//        String result = formatUrlMap(map, false, false);//nonce=123timestamp=1527609600000token=9527


        String string = "12315276096000009527";
        String encode = encode(string);
        System.out.println(encode);
    }
}
