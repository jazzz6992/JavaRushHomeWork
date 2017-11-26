import java.util.ArrayList;

/**
 * Created by vsevolodvisnevskij on 22.10.16.
 */
public class Armstrong {
    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            char[] tmp = String.valueOf(i).toCharArray();
            boolean isOk = true;
            for (int j = 0; j < tmp.length - 1; j++) {
                if (tmp[j] > tmp[j + 1]) {
                    if (tmp[j + 1] == '0') {
                        int tmpIdx = j + 1;
                        boolean allIsZero = true;
                        while (tmpIdx < tmp.length) {
                            if (tmp[tmpIdx] != '0') {
                                allIsZero = false;
                                break;
                            } else {
                                tmpIdx++;
                            }
                        }
                        if (allIsZero) {
                            isOk = false;
                            try {
                                i = Integer.parseInt(String.copyValueOf(tmp));
                                res.add(i);
                            } catch (NumberFormatException ex) {
                                break;
                            }
                            int tmp2 = j + 1;
                            while (tmp2 < tmp.length) {
                                tmp[tmp2] = tmp[tmp2 - 1];
                                try {
                                    i = Integer.parseInt(String.copyValueOf(tmp));
                                    res.add(i);
                                } catch (NumberFormatException ex) {
                                    break;
                                }
                                tmp2++;
                            }
                            break;
                        }
                    }
                    tmp[j + 1] = tmp[j];
                }
            }
            if (isOk) {
                try {
                    i = Integer.parseInt(String.copyValueOf(tmp));
                    res.add(i);
                } catch (NumberFormatException ex) {
                    break;
                }
            }
        }

        ArrayList<Integer> finalResult = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            String cur = String.valueOf(res.get(i));
            int length = cur.length();
            int result = 0;
            for (int j = 0; j < cur.length(); j++) {
                result += Math.pow(Character.getNumericValue(cur.charAt(j)), length);
            }
            String resS = String.valueOf(result);
            int len = resS.length();
            int result2 = 0;
            for (int j = 0; j < resS.length(); j++) {
                result2 += Math.pow(Character.getNumericValue(resS.charAt(j)), len);
            }
            if (result == result2) {
                if (!finalResult.contains(result)) {
                    finalResult.add(result);
                }

            }
        }


        for (int i = 0; i < finalResult.size(); i++) {
            System.out.println(finalResult.get(i));
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(finalResult.size());
    }
}
