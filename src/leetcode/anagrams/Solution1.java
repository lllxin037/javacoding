package leetcode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

	public List<String> anagrams(String[] strs) {

	    
        if (strs == null || strs.length == 0)    
            return Collections.<String>emptyList();
        
        // the key is in format "a1b2c3...". Value is the list of index in strs.    
        Map<String, Integer> map = new HashMap<>();
        int[] counters = new int[26];
        
        List<String> ret = new ArrayList<>();
        StringBuilder key = new StringBuilder();
        
        for(int cur = 0; cur < strs.length; cur++) {
            String str = strs[cur];
            
            if (str == null)
                continue;
                
            for (int i = 0; i < str.length(); i++) {
                counters[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (counters[i] == 0)
                    continue;
                key.append((char)(i + 'a') );
                key.append(counters[i]);
            }
            
            Arrays.fill(counters, 0);
            Integer lastIndex = map.get(key.toString());
            if (lastIndex == null ) 
                map.put(key.toString(), cur);
            else 
            {
                if (lastIndex != -1)  {
                    ret.add(strs[lastIndex]);
                    map.put(key.toString(), -1);
                }
                
                ret.add(str);
            }
            key.setLength(0);
        }
        
        return ret;
	}

}
