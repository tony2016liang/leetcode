package com.leetcode.demo.nowcoder;
import java.util.*;

/**
 * 华为机试 HJ27 查找兄弟单词
 * https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68?tpId=37&tqId=21250&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ27 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sss = "476 cb cba baad cbdb bdb acacd aba b cbbc b ccd d ddb acdab bab acc bc dccab bb daa cdcc dc adcab bd bbcab abc ba dd bdb dbbc ddbcd ab cc a c accb ddd cbc adb aad badd ad bac a addcb bcab d ccd b bc cdc acac adad d c ddc aba cac db dc aadbd bc cad baaa aaa d cddcc dabaa daa dcaac d db bab dbbbc cd acaab abbdc cda dddad a dbda cba cd dda bcca ccaca adbb bad c ba a ca d aca b bbdd dad bbcd abbcb ac aabac ca b ac dbbab bba bdcc cacbb bd a cbba badad ab ccda b c abcdc d bdab cbc ad dbcc bbddc ba caa ccac aadaa daad aacc dc dcb bca ab ccdda d cbbcc da ac b dcdba a adac ab dcc adac dd c bd bcd c ccbb dba abcb b cddc ccada dada dcca ddbbd c bda bac b bdbb bbba bdaa dda ac dd dcbbd ddccc badd adddd cba b b bbcab bcac bdad a adbd da ac adbbb cbbb caadb ab dc bdbc d c adb ab aadbd abad aaadc adcc b bbadd bbbc da acbb cbbdb bcdcc a bc ddba abadd ddc ada b bbcdc a bbccb bb a b cdac aab d dadad bad aabb dccba cd d cda b add dcacc bccdc add dc a cccd b aa ac dacbc a badb b dabbc b ddb acc c c a bc bc bcc dadc dad bba cbd b aa cbb a ababc da bc dcbcc dcbb aaad bdac ddbc bbbb bdbca d a cadac aaa dcd cc b dccba aadbd ddbbc aadb bca dcdcc a d c d b dbc abddb ccadb ccca ddda cd bbda adc ba bab adadb aaaa dbac abac acbb a cbd a dbdcd cdc c daaba a bc dabb bc aaadc b bdcc baaa addb ad dbdca cbb cbdd dc d dcbb bdd dca cad ddd cdbdd ca d c cd ddcda badb ab ba bc dcd add cc bb d dcda bbc abdb bd ba abcb d c ddaab cbbc cad bdb ba ba dbdcb dcddb dd cbdc cdd b cbcdb add bba bcaba d aba d cbcba bacb a abbca cdabc bdaa dbd bd ddc bacc bbcdc c bdbbb dd b cdc ba daaba ab b caac baad dcaca cda cbc cbdba bd dbbba aad b bbbba bbdc cdbb abc ddaa d c c bcd dcb adabd c bbc bb cd bccc ac d bbb cbd ad aad bcbaa bda ad d badba a a aa abacc cd bbbc d b ccbb dccad a ac bcbc bddc ddcad ddcb dd a dacb dddad dcb ac add ddc aa cc b ad baccb cda cbbdd adab abbdb c d bcb b ca cbdbd abbc dc abd bac bab bbb bcab cdaab bbaa 3";
//        String[] ss = in.nextLine().split(" ");
        String[] ss = sss.split(" ");
        int n = Integer.parseInt(ss[0]);  // 单词字典个数
        String base = ss[ss.length-2];  // 基准单词
        int k = Integer.parseInt(ss[ss.length-1]);  // 从排序后的兄弟单词后找第 k 个（从 1 开始）
        ss = Arrays.copyOfRange(ss, 1, ss.length-2);
        System.out.println(Arrays.toString(ss));
        System.out.println("k = " + k);
        Arrays.sort(ss);
        ArrayList list = new ArrayList();
        for (String s : ss) {
            if (siblingWords(s, base)) {
                list.add(s);
            }
        }
        System.out.println(list.size());
        if (list.size() > k-1) {
            System.out.println(list.get(k - 1));
        }
    }

    private static boolean siblingWords(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chart[i]) return false;
        }
        return true;
    }
}
