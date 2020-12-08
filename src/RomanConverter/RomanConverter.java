package RomanConverter;

public class RomanConverter {
    String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",};

    public int romanToInt(String romanNumber) {
        int ans = 0;
        int prev = 0;
        for (int i = romanNumber.length() - 1; i > -1; i--) {
            switch (romanNumber.charAt(i)) {
                case 'I':
                    if (prev == 5 || prev == 10) {
                        ans -= 1;
                        prev = 1;
                    } else {
                        ans += 1;
                        prev = 1;
                    }
                    break;
                case 'V':
                    ans += 5;
                    prev = 5;
                    break;
                case 'X':
                    if (prev == 50 || prev == 100) {
                        ans -= 10;
                        prev = 10;
                    } else {
                        ans += 10;
                        prev = 10;
                    }
                    break;
                case 'L':
                    ans += 50;
                    prev = 50;
                    break;
                case 'C':
                    if (prev == 500 || prev == 1000) {
                        ans -= 100;
                        prev = 100;
                    } else {
                        ans += 100;
                        prev = 100;
                    }
                    break;
                case 'D':
                    ans += 500;
                    prev = 500;
                    break;
                case 'M':
                    ans += 1000;
                    prev = 1000;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

    public static String intToRoman(int input) {
        String s = "";

        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }

    public boolean isRomanNumber(String input) {
        boolean isRoman = false;
        for (String i : rome) {
            if (input.equals(i)) {
                isRoman = true;
                break;
            }
        }
        return isRoman;
    }
}
