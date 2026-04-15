class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> chars = new HashMap<>();

        Map<Character,Integer> chars2 = new HashMap<>();


        for(char c : s.toCharArray()){

            if(chars.containsKey(c)){
              chars.put(c, chars.get(c) + 1);
            }else{
              chars.put(c,1);
            }

        }

          for(char c : t.toCharArray()){

            if(chars2.containsKey(c)){
              chars2.put(c, chars2.get(c) + 1);
            }else{
              chars2.put(c,1);
            }
        }

    for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
        Integer i = chars2.get(entry.getKey());
        if (i == null || !entry.getValue().equals(i)) {
           return  false;
        }
    }

    return true;        

    }
}
