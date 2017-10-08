package com.stark._601_700._681_690;

/**
 * Created by Stark on 2017/10/8.
 * Given a non-negative integer n, print the number in words.
 */
public class LintCode_688 {
    public String convertWords(int number) {
        // Write your code here
        if(number==0){
            return "zero";
        }
        StringBuilder sb = new StringBuilder();
        int num = number / 1000000000;
        number = number % 1000000000;
        if (num > 0) {
            solve(num, sb);
            sb.append("billion ");
        }
        num = number / 1000000;
        number = number % 1000000;
        if (num > 0) {
            solve(num, sb);
            sb.append("million ");
        }

        num = number / 1000;
        number = number % 1000;
        if (num > 0) {
            solve(num, sb);
            sb.append("thousand ");
        }
        num = number;
        if (num > 0) {
            solve(num, sb);
        }
        return sb.toString().trim();
    }

    private void solve(int num, StringBuilder sb) {
        int h = num / 100;
        num = num % 100;
        if (h > 0) {
            switch (h) {
                case 1: {
                    sb.append("one");
                    break;
                }
                case 2: {
                    sb.append("two");
                    break;
                }
                case 3: {
                    sb.append("three");
                    break;
                }

                case 4: {
                    sb.append("four");
                    break;
                }
                case 5: {
                    sb.append("five");
                    break;
                }
                case 6: {
                    sb.append("six");
                    break;
                }
                case 7: {
                    sb.append("seven");
                    break;
                }
                case 8: {
                    sb.append("eight");
                    break;
                }
                case 9: {
                    sb.append("nine");
                    break;
                }
                default:
                    break;
            }
            sb.append(" ");
            sb.append("hundred ");
        }
        int t = num / 10;
        if (t > 1) {
            switch (t) {
                case 2: {
                    sb.append("twenty");
                    break;
                }
                case 3: {
                    sb.append("thirty");
                    break;
                }

                case 4: {
                    sb.append("forty");
                    break;
                }
                case 5: {
                    sb.append("fifty");
                    break;
                }
                case 6: {
                    sb.append("sixty");
                    break;
                }
                case 7: {
                    sb.append("seventy");
                    break;
                }
                case 8: {
                    sb.append("eighty");
                    break;
                }
                case 9: {
                    sb.append("ninety");
                    break;
                }
                default:
                    break;
            }
            sb.append(" ");
            num = num % 10;
        } else if(t==1){
            switch (num) {
                case 10: {
                    sb.append("ten");
                    break;
                }
                case 11: {
                    sb.append("eleven");
                    break;
                }

                case 12: {
                    sb.append("twenteen");
                    break;
                }
                case 13: {
                    sb.append("thirteen");
                    break;
                }
                case 14: {
                    sb.append("fourteen");
                    break;
                }
                case 15: {
                    sb.append("fifteen");
                    break;
                }
                case 16: {
                    sb.append("sixteen");
                    break;
                }
                case 17: {
                    sb.append("seventeen");
                    break;
                }
                case 18: {
                    sb.append("eighteen");
                    break;
                }
                case 19: {
                    sb.append("nineteen");
                    break;
                }
                default:
                    break;
            }
            sb.append(" ");
            return;
        }
        if (num >= 1) {
            switch (num) {
                case 1: {
                    sb.append("one");
                    break;
                }
                case 2: {
                    sb.append("two");
                    break;
                }
                case 3: {
                    sb.append("three");
                    break;
                }
                case 4: {
                    sb.append("four");
                    break;
                }
                case 5: {
                    sb.append("five");
                    break;
                }
                case 6: {
                    sb.append("six");
                    break;
                }
                case 7: {
                    sb.append("seven");
                    break;
                }
                case 8: {
                    sb.append("eight");
                    break;
                }
                case 9: {
                    sb.append("nine");
                    break;
                }
                default:
                    break;
            }
            sb.append(" ");
        }
    }

    public static void main(String[] args) {
        LintCode_688 lintCode_688 = new LintCode_688();
        String s = lintCode_688.convertWords(2147483647);
        System.out.println(s);
    }
}
