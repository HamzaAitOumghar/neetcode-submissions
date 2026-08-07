class Solution {

    public String encode(List<String> strs) {
        return strs.stream()
        .map(r->r.length()+"#"+r)
        .collect(Collectors.joining());
    }

    public List<String> decode(String str) {

        List<String> words = new ArrayList();

        int i = 0;

        while(i<str.length()){
            int j = i;

            while(str.charAt(j)!='#'){
                j++;
            }

            int wordLength = Integer.parseInt(str.substring(i, j));
            j++;
            String word = str.substring(j,j+wordLength);

            words.add(word);

            i=j+wordLength;
        }

        return words;

    }
}
