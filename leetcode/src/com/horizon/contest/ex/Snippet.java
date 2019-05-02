package com.horizon.contest.ex;

public class Snippet {
	public String smallestEquivalentString(String A, String B, String S) {
		char[] pre = new char[26];
		for (int i = 0; i < 26; i++) {
			pre[i] = (char) ('a' + i);
		}
		char[] a = A.toCharArray(), b = B.toCharArray(), s = S.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i])
				continue;
			char x = findPre(pre, a[i]); 
            char y = findPre(pre, b[i]);
            if (x <= y)
                pre[y - 'a'] = x;
            else
                pre[x - 'a'] = y;
		}
		for (int i = 0; i < s.length; i++) {
			while (pre[s[i] - 'a'] != s[i]) {
				s[i] = pre[s[i] - 'a'];
			}
		}
		return new String(s);
	}
    
    public char findPre(char[] pre, char c) {
        if (pre[c - 'a'] == c) {
            return c;
        }
        return pre[c - 'a'] = findPre(pre, pre[c - 'a']); 
    }
}
